package boardtest.v1;

import java.util.Map;
import java.util.Scanner;

// 사용자가 현재 게시물 목록 열람 가능
// 사용자는 메뉴를 선택하여 게시글 생성, 조회, 삭제 가능
// 사용자는 게시판 프로그램을 종료 가능
public class BoardExample {

    private static final String menuNumberRegex = "[1-4]";
    private static final String checkNumberRegex = "[1-2]";
    private static final String readOptionRegex = "[1-3]";

    // scanner 객체는 이 클래스의 모든 인스턴스가 공용으로 사용 가능
    static Scanner scanner = new Scanner(System.in);

    BoardManager boardManager;

    public BoardExample() {}
    public BoardExample(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    // 현재 게시판의 전체 게시글 목록을 출력 가능
    public void list() {
        String boardList = """
                [게시물 목록]
                ----------------------------------------------------------
                no     writer      date         title
                ----------------------------------------------------------
                """;
        Map<String, Board> boardMap = boardManager.getBoardMap();
        System.out.println(boardList);

        mainMenu();
    }

    // 메인 메뉴를 호출
    public void mainMenu() {
        String mainMenu = """
                    ----------------------------------------------------------
                    메인메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit
                    ----------------------------------------------------------
                    """;
        System.out.print(mainMenu);
        System.out.print("메뉴 선택 : ");
    }

    // 게시물 메뉴 선택 기능
    public void run() {
        while (true) {
            list();
            // 외부에서 사용자가 입력한 데이터타입은 모두 문자열
            String input = scanner.nextLine();

            if (input.equals("4")) {
                System.out.println("\n게시판 종료");
                break;
            }
            if (input.matches(menuNumberRegex)) {
                switch (input) {
                    case "1":
                        System.out.println("*** create() 메서드 실행됨 ***");
                        break;
                    case "2":
                        System.out.println("*** read() 메서드 실행됨 ***");
                        break;
                    case "3":
                        System.out.println("*** clear() 메서드 실행됨 ***");
                        break;
                }
            } else {
                System.out.println("[1-4]번 번호를 입력하세요.");
            }
        }
    }

    public boolean checkMenu() {
        return true;
    }

    public void create() {

    }

    public void read() {

    }

    public void clear() {

    }
}
