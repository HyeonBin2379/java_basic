package java_advanced_01.day22.net.socket01;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketEx01 {

    public static void main(String[] args) {
        // TCP 클라이언트 생성
        // Socket 객체 생성과 동시에 localhost나 IP Port와의 연결을 요청
        try {
            Socket socket = new Socket("localhost", 50001);
            System.out.println("Connected to server 성공!");

            socket.close();
            System.out.println("클라이언트 연결 종료");
        } catch (IOException e) {
            System.out.println("연결 실패");
        }
    }
}
