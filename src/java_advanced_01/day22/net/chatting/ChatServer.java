package java_advanced_01.day22.net.chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {
    private static final int PORT = 5000;

    // ExecutorService: 스레드 풀을 제공하기 위한 클래스
    private static final ExecutorService POOL = Executors.newCachedThreadPool();
    // AtomicInteger: 원자화된 정수 타입
    private static final AtomicInteger CLIENT_SEQ = new AtomicInteger(1);
    private static final Map<String, PrintWriter> clients = Collections.synchronizedMap(new HashMap<>());

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
                // 클라이언트 측의 요청 수신을 위한 서버 소켓 생성
                Socket socket = serverSocket.accept();

                // 멀티스레드 환경에서 서버와 연결된 클라이언트를 식별하기 위해 일련번호를 부여
                int id = CLIENT_SEQ.getAndIncrement();

                POOL.submit(new ClientHandler(socket, id));
            }
        } catch (IOException e) {
            System.err.println("[Server] Error: " + e.getMessage());
        }
    }

    // 클라이언트 -> 서버 채팅 메시지 전송은 스레드 단위에서 수행됨
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final int clientId;

        private String nickname;

        // 서버와 연결된 특정 클라이언트와의 메시지 송수신 작업을 처리
        // 한 스레드당 1개의 서버 소켓을 사용하여 클라이언트의 요청을 처리
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
                nickname = in.readLine();
                if (clients.containsKey(nickname)) {
                    throw new IOException("중복된 이름입니다.");
                }
                clients.put(nickname, out);
                System.out.println("[Server] " + nickname + " joined from " + socket.getRemoteSocketAddress());

                out.println("Welcome! You are " + nickname + ". Type 'quit' to quit.");
                String line;
                while ((line = in.readLine()) != null) {

                    if ("/quit".equalsIgnoreCase(line.trim())) {
                        out.println("Bye " + nickname);
                        break;
                    }
                    if ("/who".equalsIgnoreCase(line.trim())) {
                        out.printf("USERS %s\n", String.join(", ", clients.keySet()));
                    }

                    // 받은 메시지를 그대로 돌려주는 에코
//                    out.println("Echo to #" + nickname + ": " + line);
                    broadcast(line);
                    System.out.println("[Server] From " + nickname + ": " + line);
                }
            } catch (IOException e) {
                System.err.println("[Server] " + nickname + " I/O error: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (IOException ignored) {}
                System.out.println("[Server] " + nickname + " left.");
            }
        }

        private void broadcast(String message) {
            synchronized (clients) {
                clients.forEach((nick, writer) -> writer.println("Echo to " + nickname + ": " + message));
            }
        }
    }
}
