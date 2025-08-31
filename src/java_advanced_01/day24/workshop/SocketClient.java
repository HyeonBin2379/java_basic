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

//클라이언트와 1:1 로 통신하는 역할
public class SocketClient {

    //필요 객체 (필드)
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String clientIp;
    String chatName;//닉네임(대화명)

    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();

            receive();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //메소드 : JSON 메세지 받기  : 클라이어트가 보낸 JSON 메시지를 읽는 업무를 수행한다.
    // dis.readUTF()로 JSON을 읽고 JSONObject로 파싱해서 command값을 얻어내어 처리함
    //command : incomming=> JSON에서 대화명을 읽는다. chatRoom에 SocketClient를 추가
    //            message => 메세지를 읽고 연결되어 있는 모든 클라이언트들에게 메시지를 보낸다.
    //          클라이언트가 채팅을 종료할 경우 dis.UTF()에서 IOException발생하므로 예외처리를 하여
    // chatRoom에 저장되어 있는 SocketClient를 제거한다.

    public void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while(true) {
                    String receivedChat = dis.readUTF();
                    List<String> tokens = Arrays.stream(receivedChat.split(" ")).toList();

                    switch (tokens.get(0)) {
                        case "NICK":
                            this.chatName = tokens.get(1);
                            chatServer.addSocketClient(this);
                            chatServer.sendToAll(this, String.format("%s joined.", this.chatName));
                            break;
                        case "/who":
                            String clientNames = String.format("USERS %s", getClientNames());
                            System.out.printf("[%s] %s\n", chatName, receivedChat);
                            send(clientNames);
                            break;
                        case "/w":
                            String receiver = tokens.get(1);
                            String newMessage = String.format("%s: %s", chatName, receivedChat.replace("/w " + receiver, "").trim());
                            chatServer.whisper(receiver, newMessage.trim());
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
                chatServer.sendToAll(this, String.format("%s disconnected.", chatName));
                chatServer.removeSocketClient(this);
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

    //메소드 : JSON 보내기  연결된 클라이언트로 JSON메세지를 보내는 기능
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
