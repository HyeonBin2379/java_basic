package java_advanced_01.day24.jsonchatting;

import java.io.IOException;
import java.net.Socket;

// ChatClient: 채팅 서버와 연결하기 위한 소켓을 생성하고,
// 서버와의 연결에 성공하면 채팅 서버와 JSON 형식의 메시지를 주고받는 통신을 수행하는 클래스
public class ChatClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8000;
        try {
            Socket socket = new Socket(host, port);

            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
