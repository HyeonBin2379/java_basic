package java_advanced_01.day24.workshop;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    //필드
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String chatName;

    public void connect() throws IOException {
        socket = new Socket("localhost", 5000);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }

    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    String message = dis.readUTF();
                    if (message.trim().isEmpty()) {
                        continue;
                    }
                    System.out.println("[" + chatName + "] " + message);
                }
            } catch(Exception e1) {
                System.out.println("[클라이언트] 서버 연결 끊김");
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
    public void unconnect() throws IOException {
        socket.close();
    }


    //메소드: 메인
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            String firstMsg = br.readLine();
            String[] messageTokens = firstMsg.split(" ");
            if (!messageTokens[0].startsWith("NICK") || messageTokens.length != 2) {
                throw new IOException("올바른 닉네임 입력 형식이 아닙니다.");
            }
            chatClient.chatName = messageTokens[1].trim();
            chatClient.send(firstMsg);
            chatClient.receive();

            System.out.println("--------------------------------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter");
            System.out.println("채팅를 종료하려면 q를 입력하고 Enter");
            System.out.println("--------------------------------------------------");
            while(true) {
                String message;
                synchronized (System.out) {
                    System.out.print(chatClient.chatName + " ");
                    message = br.readLine();
                    if (firstMsg.equalsIgnoreCase("q")) {
                        break;
                    }
                    chatClient.send(String.format("[%s] %s\n", chatClient.chatName, message.trim()));
                }
            }
            chatClient.unconnect();
        } catch(IOException e) {
            System.out.println("[클라이언트] 서버 연결 안됨");
        }
    }


}