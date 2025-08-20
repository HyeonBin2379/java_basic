package boardtest.v1;

public class BoardMain {

    public static void main(String[] args) {
        BoardManager boardManager = BoardManager.getInstance();
        // 생성자 주입 방식 -> 서비스 기능 요청 시 파라미터를 통해 사용할 객체를 전달
        // 일반적으로 주입되는 객체의 타입은 인터페이스 -> 약한 결합
        // boardManager는 BoardExample에게 접근할 권한을 획득
        BoardExample boardExample = new BoardExample(boardManager);
        boardExample.run();
    }
}
