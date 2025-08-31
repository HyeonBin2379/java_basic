package java_advanced_01.day24.workshop;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    //필드
    private static DataInputStream dis;
    private static DataOutputStream dos;

    private Socket socket;
    private String chatName;

    public void connect() throws IOException {
        socket = new Socket("localhost", 5000);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("connected to server");
    }

    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String message = dis.readUTF();
                    if (message.trim().isEmpty()) {
                        continue;
                    }
                    System.out.println(message);
                }
            } catch(Exception e1) {
                // 서버 강제종료 시 실행 중인 모든 클라이언트 종료
                System.out.println("disconnected to server");
                System.exit(0);
            }
        });
        thread.start();
    }

    //메소드: 메시지 전송
    public void send(String message) throws IOException {
        dos.writeUTF(message);
        dos.flush();
    }

    //메소드: 서버 연결 종료
    public void disconnect() throws IOException {
        socket.close();
    }

    //메소드: 메인
    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            // 닉네임 입력은 최초 1회만 수행
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String firstMessage = br.readLine();
            chatClient.validateAndRegister(firstMessage);
            chatClient.send(firstMessage);
            chatClient.receive();

            System.out.println("--------------------------------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter");
            System.out.println("채팅를 종료하려면 /quit을 입력하고 Enter");
            System.out.println("--------------------------------------------------");

            while (true) {
                String message = br.readLine();
                chatClient.send(message.trim());
                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
            }
            br.close();
            chatClient.disconnect();
        } catch(IOException e) {
            System.out.println("ERR [클라이언트] 서버 연결 안됨");
        }
    }

    public void validateAndRegister(String firstMessage) throws IOException {
        String[] messageTokens = firstMessage.split(" ");
        if (!messageTokens[0].equals("NICK") || messageTokens.length != 2) {
            throw new IOException("ERR [클라이언트] 메시지의 형식이 올바르지 않습니다.");
        }
        if (messageTokens[1].trim().isEmpty() || messageTokens[1].contains(" ")) {
            throw new IOException("ERR [클라이언트] 닉네임에는 공백 및 빈 문자열을 사용할 수 없습니다.");
        }
        chatName = messageTokens[1].trim();
    }
}