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
    ExecutorService threadPool = Executors.newFixedThreadPool(10); //10개의 클라이언트가 동시에 채팅할 수 있도록 운영
    ServerSocket serverSocket;  // 클라이언트의 연결 요청 수락
    Map<String, SocketClient> chatRoom = new ConcurrentHashMap<>(new HashMap<>()); //통신용 SocketClient를 관리하는 동기화된 Map 컬렌션이다.

    //메소드 : 서버 시작 채팅서버가 시작할때 가장 먼저 호출되는 메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(5000);
        System.out.println( "OK [서버] 시작됨");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("OK 서버 강제종료");
            this.stop();
        }));

        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    Socket socket = serverSocket.accept();
                    // 서버-클라이언트 간 연결 수립 후 유지
                    SocketClient sc = new SocketClient(this, socket);
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        });
        thread.start();
    }

    // 메소드 : 클라이언트 연결시 SocketClient 생성 하고 Map에 추가하는 기능
    public void addSocketClient(SocketClient socketClient) throws IOException{
        String key = socketClient.chatName;
        if (chatRoom.containsKey(key)) {
            throw new IOException("ERR 닉네임 " + key + "는 이미 사용중입니다.");
        }
        chatRoom.put(key, socketClient);
        System.out.println(key + " connected.");
        System.out.print("OK 현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    //메소드 : 클라이언트 연결 종료 시 SocketClient 제거
    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName;
        chatRoom.remove(key);
        System.out.println(key + " disconnected.");
        System.out.print("OK 현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    // 메시지 브로드캐스트 기능
    public void sendToAll(SocketClient sender, String message) {
        Collection<SocketClient> socketClients = chatRoom.values();
        socketClients.forEach(socketClient -> socketClient.send(message));
    }

    // 1명의 클라이언트에게만 메시지 전달
    public void whisper(String receiverName, String message) {
        SocketClient socketClient = chatRoom.get(receiverName);
        socketClient.send(String.format("%s << %s", receiverName, message));
    }

    //서버종료 : stop()
    public void stop() {
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().forEach(SocketClient::close);
            System.out.println( "OK [서버] 종료됨 ");
        } catch (IOException e1) {}
    }
    //메소드: 메인
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            ChatServer chatServer = new ChatServer();
            chatServer.start();

            System.out.println("----------------------------------------------------");
            System.out.println("서버를 종료하려면 /quit를 입력하고 Enter.");
            System.out.println("----------------------------------------------------");

            while(true) {
                String key = br.readLine();
                if(key.equals("/quit")) {
                    break;
                }
            }
            chatServer.stop();
        } catch(IOException e) {
            System.out.println("ERR [서버] " + e.getMessage());
        }
    }
}
