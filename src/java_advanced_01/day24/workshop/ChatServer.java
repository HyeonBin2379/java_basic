package java_advanced_01.day24.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    //3개의 필드
    ServerSocket serverSocket;  // 클라이언트의 연결 요청 수락
    ExecutorService threadPool = Executors.newFixedThreadPool(100); //100개의 클라이언트가 동시에 채팅할 수 있도록 운영하기 위해
    Map<String, SocketClient> chatRoom = new ConcurrentHashMap<>(new HashMap<>()); //통신용 SocketClient를 관리하는 동기화된 Map 컬렌션이다.

    //메소드 : 서버 시작 채팅서버가 시작할때 가장 먼저 호출되는 메소드
    //50001번 Port에 바인딩하는 ServerSocket을 생성하고 작업스레드가 처리할 Runnable을 람다식 ()->{....} 제공
    public void start() throws IOException {
        serverSocket = new ServerSocket(5000);
        System.out.println( "[서버] 시작됨");

        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    Socket socket = serverSocket.accept();
                    // 서버-클라이언트 간 연결 수립
                    SocketClient sc = new SocketClient(this, socket);

                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        });
        thread.start();
    }

    // 메소드 : 클라이언트 연결시 SocketClient 생성 하고 Map에 추가하는 기능
    public void addSocketClient(SocketClient socketClient) throws IOException{
        String key = socketClient.chatName;
        if (chatRoom.containsKey(key)) {
            throw new IOException("닉네임 " + key + "는 이미 사용중입니다.");
        }
        chatRoom.put(key, socketClient);
        System.out.println("입장: " + key);
        System.out.print("현재 채팅자 수: " + chatRoom.size() + "\n");
    }


    //메소드 : 클라이언트 연결 종료 시 SocketClient 제거
    public synchronized void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName;
        chatRoom.remove(key);
        System.out.println("나감: " + key);
        System.out.print("현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    // 메시지 브로드캐스트 기능 : JSON메시지를 생성하여 채팅방에 있는 모든
    //클라이언트에게 보내는 기능을 구현
    public void sendToAll(String message) {
        Collection<SocketClient> socketClients = chatRoom.values();
        socketClients.forEach(socketClient -> socketClient.send(message));
    }

    // 귓속말: 특정 클라이언트에게만 메시지 전달
    public void whisper(String chatName, String message) {
        SocketClient socketClient = chatRoom.get(chatName);
        socketClient.send(message);
    }

    //서버종료 : stop()
    public void stop() {
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().stream().forEach(SocketClient::close);
            System.out.println( "[서버] 종료됨 ");
        } catch (IOException e1) {}
    }
    //메소드: 메인
    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();

            System.out.println("----------------------------------------------------");
            System.out.println("서버를 종료하려면 q를 입력하고 Enter.");
            System.out.println("----------------------------------------------------");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String key = br.readLine();
                if(key.equals("q")) {
                    break;
                }
            }
            br.close();
            chatServer.stop();
        } catch(IOException e) {
            System.out.println("[서버] " + e.getMessage());
        }
    }
}
















