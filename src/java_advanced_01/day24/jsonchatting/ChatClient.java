package java_advanced_01.day24.jsonchatting;

import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

// ChatClient: 채팅 서버와 연결하기 위한 소켓을 생성하고,
// 서버와의 연결에 성공하면 채팅 서버와 JSON 형식의 메시지를 주고받는 통신을 수행하는 클래스
public class ChatClient {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String chatName;

    public void connect() throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }

    public void receive() {
        Thread thread = new Thread(this::parseJson);
        thread.start();
    }
    private void parseJson() {
        try {
            while(true) {
                String json = dis.readUTF();
                JSONObject root = new JSONObject(json);
                String clientIp = root.getString("clientIp");
                String chatName = root.getString("chatName");
                String message = root.getString("message");
                System.out.println("<" + chatName + "@" + clientIp + "> " + message);
            }
        } catch(Exception e1) {
            System.out.println("[클라이언트] 서버 연결 끊김");
            System.exit(0);
        }
    }

    public void send(String json) throws IOException {
        dos.writeUTF(json);
        dos.flush();
    }

    public void disconnect() throws IOException{
        socket.close();
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            System.out.println("대화명 입력:");
            chatClient.chatName = br.readLine();

            // 새로운 클라이언트가 채팅방에 입장
            String json = makeJson("incoming", chatClient.chatName);
            chatClient.send(json);
            chatClient.receive();

            // 채팅 메시지 송수신
            System.out.println("--------------------------------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter");
            System.out.println("채팅를 종료하려면 q를 입력하고 Enter");
            System.out.println("--------------------------------------------------");
            while(true) {
                String message = br.readLine();
                if(message.equalsIgnoreCase("q")) {
                    break;
                }
                json = makeJson("message", message);
                chatClient.send(json);
            }
            chatClient.disconnect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String makeJson(String command, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", command);
        jsonObject.put("data", message);
        return jsonObject.toString();
    }
}
