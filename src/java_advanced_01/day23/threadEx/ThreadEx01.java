package java_advanced_01.day23.threadEx;

public class ThreadEx01 {

    public static void main(String[] args) {
        // 현재 실행 중인 스레드 객체에 관한 참조를 획득
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행");

        for (int i = 0; i < 3; i++) {
            // 익명 클래스를 사용하여 스레드를 생성함으로써 작업 단위를 지정
            Thread threadA = new Thread(){
                @Override
                public void run() {
                    // getName(): Thread의 인스턴스 메서드 -> 스레드의 이름을 반환
                    System.out.println(getName() + "실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "실행");
            }
        };
        chatThread.setName("chatting-thread");
        chatThread.setPriority(Thread.MIN_PRIORITY);
        chatThread.start();
    }
}
