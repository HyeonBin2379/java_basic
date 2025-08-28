package java_advanced_01.day23.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("[서버]와 연결되었습니다.");

            socket.close();
            System.out.println("[서버와의 연결 해제]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
