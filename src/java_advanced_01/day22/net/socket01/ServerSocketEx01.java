package java_advanced_01.day22.net.socket01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketEx01 {

    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        System.out.println("------------- Starting server socket ------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("-------------------------------------------------");

        // TCP 서버 시작
        startServer();

        // 키보드 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();

            if (key.equalsIgnoreCase("Q")) {
                break;
            }


        }

        // TCP 서버 종료
        stopServer();
    }

    // 스레드를 사용하여 서버를 구현
    public static void startServer() {
        // 스레드(Thread) : 프로그램을 실행하는 최소 단위
        Thread thread = new Thread(){
            @Override
            public void run() {
                // main 스레드와는 별개로 생성되는 스레드이므로 throws를 통한 예외 처리 대신 try-catch 사용
                try {
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨!");
                    while (true) {
                        System.out.println("\n[서버] 연결 요청을 기다립니다.\n");
                        // 연결 수락
                        Socket socket = serverSocket.accept();

                        // 연결된 클라이언트의 정보를 획득 가능
                        InetSocketAddress ia = (InetSocketAddress)socket.getRemoteSocketAddress(); 
                        System.out.println("[서버] " + ia.getAddress() + ":" + ia.getPort() + "의 연결 수락함");
                        
                        // 연결 끊기
                        socket.close();
                        System.out.println("[서버] " + ia.getHostName());
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        // startServer() 메서드 호출 시 실질적으로 실행되는 코드는 아래의 코드
        thread.start();
    }

    public static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("[서버 종료]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
