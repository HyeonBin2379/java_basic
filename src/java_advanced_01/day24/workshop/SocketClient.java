package java_advanced_01.day24.workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// 서버 측에서 클라이언트와 1:1 로 통신하기 위한 창구 역할 수행
public class SocketClient {

    //필요 객체 (필드)
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String clientIp;
    String chatName;    // 연결된 클라이언트 측의 닉네임(대화명)

    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;

            // 클라이언트 소켓과의 통신 회선 설정
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();

            receive();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while(true) {
                    String receivedChat = dis.readUTF();
                    List<String> tokens = Arrays.stream(receivedChat.split(" ")).toList();

                    // 아래의 키워드로 시작되는 메시지는 서버에만 출력됨
                    switch (tokens.get(0)) {
                        case "NICK":
                            this.chatName = tokens.get(1);
                            chatServer.addSocketClient(this);
                            chatServer.sendToAll(this, String.format("%s joined.", tokens.get(1)));
                            break;
                        case "/who":
                            String clientNames = String.format("USERS %s", getClientNames());
                            System.out.printf("[%s] %s\n", chatName, receivedChat);
                            send(clientNames);
                            break;
                        case "/w":
                            String receiver = tokens.get(1);
                            String newMessage = receivedChat.replace("/w " + receiver, "");

                            System.out.printf("[%s] %s\n", chatName, receivedChat);
                            chatServer.whisper(receiver, chatName, newMessage.trim());
                            break;
                        case "/quit":
                            chatServer.sendToAll(this, String.format("%s left.", chatName));
                            chatServer.removeSocketClient(this);
                            return;
                        default:
                            if (!receivedChat.trim().isEmpty()) {
                                String chatMessage = String.format("[%s] %s", chatName, receivedChat);
                                System.out.println(chatMessage);
                                chatServer.sendToAll(this, chatMessage);
                            }
                    }
                }
            } catch(IOException e) {
                chatServer.removeSocketClient(this);
                chatServer.sendToAll(this, String.format("%s disconnected.", chatName));
                System.out.println(e.getMessage());
            }
        });
    }

    private String getClientNames() {
        Collection<SocketClient> connections = chatServer.chatRoom.values();
        return connections.stream()
                .map(socketClient -> socketClient.chatName)
                .sorted()   // 멀티스레딩 환경에서 저장 순서를 유지
                .collect(Collectors.joining(", "));
    }

    //메소드 : 연결된 클라이언트로 메세지 전송
    public void send(String chat) {
        try {
            dos.writeUTF(chat);
            dos.flush();
        } catch (IOException e) {
        }
    }
    // 메소드 연결 종료
    public void close() {
        try {
            socket.close();
        } catch(Exception e) {}
    }

}
