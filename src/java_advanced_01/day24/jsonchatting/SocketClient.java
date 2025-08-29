package java_advanced_01.day24.jsonchatting;

import lombok.Getter;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class SocketClient {

    // 필요한 객체:
    private ChatServer chatServer;  // ChatServer의 메서드 호출을 위해 필요
    private Socket socket;          // 연결 종료 시 필요

    // 문자메시지 읽기/쓰기 수행용 스트림
    private DataInputStream dis;
    private DataOutputStream dos;

    // 클라이언트 IP, 닉네임 저장
    @Getter
    private String clientIp;
    @Getter
    private String chatName;

    // SocketClient 생성 시 채팅에 필요한 요소들도 세팅
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;

            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());

            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();

            receive();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 메서드: JSON 메시지 받기 - 클라이언트가 보낸 JSON 메시지를 읽는 업무를 수행
    // dis.readUTF()로 JSON을 읽고 JSONObject로 파싱하여 commend값을 얻어낸 다음 처리

    /*
    * command
    * - incomming -> JSON에서 대화명을 읽고 채팅방에 SocketClient를 추가
    * - message -> 메시지를 읽고 연결된 모든 클라이언트들에게 메시지 브로드캐스팅
    * - 클라이언트가 채팅을 종료할 경우, dis.UTF()에서 IOException 예외 처리 후, chatRoom에 저장된 SocketClient를 제거
    * */
    public void receive() {
        ExecutorService threadPool = ChatServer.getTHREAD_POOL();
        threadPool.execute(this::handleJson);
    }
    private void handleJson() {
        try {
            while (true) {
                String receiveJson = dis.readUTF();
                JSONObject obj = new JSONObject(receiveJson);
                String command = obj.getString("command");

                switch (command) {
                    case "incoming" -> {
                        this.chatName = obj.getString("data");
                        chatServer.sendToAll(this, "입장하셨습니다.");
                        chatServer.addSocketClient(this);
                    }
                    case "message" -> {
                        String message = obj.getString("data");
                        System.out.printf("[%s] %s\n", chatName, message);
                        chatServer.sendToAll(this, message);
                    }
                }
            }
        } catch (IOException e) {
            chatServer.sendToAll(this, "퇴장하셨습니다.");
            chatServer.removeSocketClient(this);
            System.out.println(e.getMessage());
        }
    }

    // 메서드: 연결된 클라이언트로 JSON 메시지 보내기
    public void send(String json) {
        try {
            dos.writeUTF(json);
            dos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 메서드: 연결 종료
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
