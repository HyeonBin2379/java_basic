package java_advanced_01.day22.net.chatting;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatClient {

    private static Thread thread;
    private static String nickname;

    public static void main(String[] args) {
        // 클라이언트가 연결하려는 서버 포트
        String host = "127.0.0.1";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
             BufferedReader keyboard = new BufferedReader(
                     new InputStreamReader(System.in, StandardCharsets.UTF_8))
        ) {
            System.out.print("NICK ");
            nickname = keyboard.readLine();
            if (nickname.trim().isEmpty()) {
                throw new IOException("닉네임에는 공백을 사용할 수 없습니다.");
            }
            out.println(nickname);
            System.out.printf("[%s] Connected to %s:%d\n", nickname, host, port);

            // 서버의 첫 인사 수신
            String greet = in.readLine();
            if (greet != null) {
                System.out.println(greet);
            }

            String msg;
            while (true) {
                // 서버와 연결된 클라이언트에게 작성한 메시지를 전송
                System.out.printf("%s> ", nickname);
                msg = keyboard.readLine();
                if (msg == null) {
                    break;   // EOF (Ctrl+D/Ctrl+Z)
                }
                if (msg.trim().isEmpty()) {
                    out.flush();
                }
                out.println(msg);

                // 서버 측의 응답을 수신
                String resp = in.readLine();
                if (resp != null) {
                    throw new EOFException("Server closed connection.");
                }
                System.out.println(resp);

                // 채팅창에 quit이 입력되면 클라이언트를 종료
                if ("/quit".equalsIgnoreCase(msg.trim())) {
                    break;
                }
            }
            System.out.printf("[%s] Bye.\n", nickname);
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.printf("[%s] Error: %s\n", nickname, e.getMessage());
        }
    }

    private static void printChat(BufferedReader in) throws IOException {
        String resp = in.readLine();
        if (resp == null) {
            throw new EOFException("Server closed connection.");
        }
        System.out.println(resp);
    }
}
