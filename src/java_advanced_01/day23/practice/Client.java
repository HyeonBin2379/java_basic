package java_advanced_01.day23.practice;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5000);

            System.out.println("[클라이언트] 접속 성공");
            socket.close();
            System.out.println("[클라이언트] 접속 해제");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
