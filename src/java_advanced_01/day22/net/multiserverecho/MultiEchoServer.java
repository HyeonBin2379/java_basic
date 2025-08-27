package java_advanced_01.day22.net.multiserverecho;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiEchoServer {
    private static final int PORT = 5000;

    // ExecutorService: 스레드 풀을 제공하기 위한 클래스
    private static final ExecutorService POOL = Executors.newCachedThreadPool();
    // AtomicInteger: 원자화된 정수 타입
    // -> 멀티스레드 사용 시 4byte 단위로 전송되는 정수의 원자성(더 이상 쪼개지지 않음)을 보장
    private static final AtomicInteger CLIENT_SEQ = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println("[Server] Starting on port " + PORT);
        // Ctrl+C 시 스레드 풀 정리
        // 현재 실행 중인 모든 스레드를 종료하고 스레드풀을 정리
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n[Server] Shutting down...");
            POOL.shutdownNow();
        }));

        // 지정한 포트번호와 서버 소켓을 바인딩
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // 클라이언트 측의 요청 수신
                Socket socket = serverSocket.accept();

                // 멀티스레드 환경에서 서버와 연결된 클라이언트를 식별하기 위해 일련번호를 부여
                int id = CLIENT_SEQ.getAndIncrement();
                System.out.println("[Server] Client#" + id + " connected from " + socket.getRemoteSocketAddress());

                // 스레드풀로부터 클라이언트와 채팅메시지 송수신하기 위한 스레드를 할당받아 실행
                POOL.submit(new ClientHandler(socket, id));
            }
        } catch (IOException e) {
            System.err.println("[Server] Error: " + e.getMessage());
        }
    }

    // 개별 클라이언트-서버 간 채팅 메시지 송수신을 스레드 단위에서 수행됨
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final int clientId;

        // 서버와 연결된 특정 클라이언트와의 메시지 송수신 작업을 처리하기 위한 객체 생성
        ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;   // 클라이언트에 관한 고유번호
        }

        @Override
        public void run() {
            try (
                    // 클라이언트 측의 채팅 메시지를 수신하기 위한 입력 스트림
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    // 클라이언트로부터 수신한 채팅 메시지를 콘솔창에 출력하는 스트림
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)
            ) {
                out.println("Welcome! You are Client#" + clientId + ". Type 'exit' to quit.");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("[Server] From Client#" + clientId + ": " + line);
                    if ("exit".equalsIgnoreCase(line.trim())) {
                        out.println("Bye Client#" + clientId);
                        break;
                    }
                    // 받은 메시지를 그대로 돌려주는 에코
                    out.println("Echo to #" + clientId + ": " + line);
                }
            } catch (IOException e) {
                // 특정 클라이언트와 채팅 메시지를 송수신하는 과정에서 오류 발생
                System.err.println("[Server] Client#" + clientId + " I/O error: " + e.getMessage());
            } finally {
                // 특정 클라이언트와의 연결을 종료
                try { socket.close(); } catch (IOException ignored) {}
                System.out.println("[Server] Client#" + clientId + " disconnected.");
            }
        }
    }
}
