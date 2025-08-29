package java_advanced_01.day22.net.chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {
    private static final int PORT = 5000;

    // ExecutorService: 스레드 풀을 제공하기 위한 클래스
    private static final ExecutorService POOL = Executors.newCachedThreadPool();
    private static final Map<String, PrintWriter> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting on port " + PORT);
        // Ctrl+C 시 스레드 풀 정리
        // 현재 실행 중인 모든 스레드를 종료하고 스레드풀을 정리
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down...");
            POOL.shutdownNow();
        }));

        // 지정한 포트번호와 서버 소켓을 바인딩
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // 클라이언트 측의 요청 수신을 위한 서버 소켓 생성
                Socket socket = serverSocket.accept();

                // 멀티스레드 환경에서 서버와 연결된 클라이언트를 식별하기 위해 일련번호를 부여
                POOL.submit(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println("ERR " + e.getMessage());
        }
    }

    // 클라이언트 -> 서버 채팅 메시지 전송은 스레드 단위에서 수행됨
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private String nickname;

        // 서버와 연결된 특정 클라이언트와의 메시지 송수신 작업을 처리
        // 한 스레드당 1개의 서버 소켓을 사용하여 클라이언트의 요청을 처리
        ClientHandler(Socket socket) {
            this.socket = socket;
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
//                nickname = in.readLine();
//                if (clients.containsKey(nickname)) {
//                    throw new IOException("중복된 이름입니다.");
//                }
//                clients.put(nickname, out);
//                System.out.println(nickname + " joined from " + socket.getRemoteSocketAddress());
//                out.println("Welcome! You are " + nickname + ". Type '/quit' to quit.");
                receivedNickName(in, out);

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
                    System.out.printf("[%s] %s\n", nickname, line);

                    broadcast(String.format("[%s] %s", nickname, line));
                }
            } catch (IOException e) {
                System.err.println("ERR " + nickname + " I/O error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    clients.get(nickname).close();
                } catch (IOException ignored) {}
                System.out.println(nickname + " left.");
            }
        }

        private void receivedNickName(BufferedReader in, PrintWriter out) throws IOException {
            nickname = in.readLine();
            if (clients.containsKey(nickname)) {
                throw new IOException("중복된 이름입니다.");
            }
            clients.put(nickname, out);

            // 새로운 유저 입장 -> 해당 유저에게 인삿말 전송
            System.out.printf("%s joined from %s\n", nickname, socket.getRemoteSocketAddress());
            out.println("Welcome! You are " + nickname + ". Type '/quit' to quit.");

            // 새로운 유저가 채팅방에 입장했음을 전체 유저에게 안내
            broadcast(String.format("%s joined", nickname));
        }

        private void broadcast(String message) {
            synchronized (clients) {
                clients.forEach((nick, writer) -> {
                    writer.println(message);
                    writer.flush();
                });
            }
        }
    }
}
