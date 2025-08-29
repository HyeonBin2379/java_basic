package java_advanced_01.day24.jsonchatting;

import org.json.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
* ChatServer
* - 채팅 클라이언트의 연결 요청을 수락
* - 통신용 SocketClient 객체를 생성
* */
public class ChatServer {

    // 서버-클라이언트는 1:N 관계 -> 스레드 풀 사용(개수는 지정)
    // 서버는 클라이언트 1개당 통신용 스레드 1개를 할당 -> 통신 종료 시 스레드 반환
    static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(100);

    private static final int PORT = 50001;
    // 100개의 클라이언트와의 동시 채팅을 관리하기 위한 맵
    private static final Map<String, SocketClient> chatRoom = new ConcurrentHashMap<>();

    private static ServerSocket serverSocket;

    // 메서드: 채팅서버 시작 시 가장 먼저 호출되어야 하는 메서드
    // 50001번 Port에 바인딩하는 ServerSocket을 생성
    // 작업스레드가 처리할 Runnable을 Thread 생성 시 제공(람다식도 사용 가능) 
    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started.");
            Thread thread = new Thread(this::handleClient);
            thread.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleClient() {
        try {
            while (true) {
                // 1. accept()로 연결을 수락, 통신용 소켓클라이언트를 반복 생성
                Socket socket = serverSocket.accept();
                // 2. 통신용 SocketClient를 반복 생성
                SocketClient client = new SocketClient(this, socket);


                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 메서드: 클라이언트 연결 시 SocketClient 생성 후 Map에 추가한 다음 입장을 공지
    public void addSocketClient(SocketClient socketClient) {
        // 클라이언트 정보를 이용하여 고유키 생성
        String key = String.format("%s@%s", socketClient.getChatName(), socketClient.getClientIp());

        chatRoom.put(key, socketClient);
        System.out.printf("입장 > : %s\n", key);
        System.out.printf("현재 채팅자 수: %d\n", chatRoom.size());
    }

    // 메서드: 클라이언트 연결 종료 시 SocketClient 제거 후 퇴장 공지
    public void removeSocketClient(SocketClient socketClient) {
        String key = String.format("%s@%s", socketClient.getChatName(), socketClient.getClientIp());
        chatRoom.remove(key);
        System.out.printf("퇴장> : %s\n", key);
        System.out.printf("현재 채팅자 수: %d\n", chatRoom.size());
    }

    // 메시지 브로드캐스트 기능: JSON 메시지를 생성하여 채팅방 내 모든 클라이언트에게 메시지 전송
    public void sendToAll(SocketClient sender, String message) {
        JSONObject root = new JSONObject();

        // 메시지를 작성한 클라이언트 정보, 채팅 내용을 JSON 파일에 저장
        root.put("clientIp", sender.getClientIp());
        root.put("chatName", sender.getChatName());
        root.put("message", message);

        // 추가한 정보들을 바탕으로 JSON 메시지 생성
        String json = root.toString();

        // send()로 JSON 메시지를 전송
        Collection<SocketClient> clients = chatRoom.values();
        clients.stream()
                .filter(client -> client != sender)
                .forEach(client -> client.send(json));
    }

    public void stop(ServerSocket serverSocket) {
        try {
            serverSocket.close();
            THREAD_POOL.shutdown();
            chatRoom.clear();
            System.out.println("서버 종료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
