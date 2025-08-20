package boardtest.v1;

import java.text.SimpleDateFormat;
import java.util.*;

// 사용자가 현재 게시물 목록 열람 가능
// 사용자는 메뉴를 선택하여 게시글 생성, 조회, 삭제 가능
// 사용자는 게시판 프로그램을 종료 가능
public class BoardExample {

    private static final String menuNumberRegex = "[1-4]";
    private static final String checkNumberRegex = "[1-2]";
    private static final String readOptionRegex = "[1-3]";

    private static final Scanner scanner = new Scanner(System.in);

    // scanner 객체는 이 클래스의 모든 인스턴스가 공용으로 사용 가능
    private static int bno = 1;     // 공용 변수

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // BoardManager가 게시판을 관리
    BoardManager boardManager;

    public BoardExample() {
    }
    public BoardExample(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    // 현재 게시판의 전체 게시글 목록을 출력 가능
    public void list() {
        // 게시판은 관리자 담당 -> 관리자로부터 게시판을 받아온다.
        Map<String, Board> boardMap = boardManager.getBoardMap();
        System.out.println("\n[게시물 목록]");
        System.out.println("-".repeat(60));
        System.out.printf("%-4s %-20s %-20s %-20s\n", "no", "writer", "date", "title");

        // Manager에게 전체 게시물 목록을 요청
        List<Map.Entry<String, Board>> entryList = new LinkedList<>(boardMap.entrySet());
        Collections.reverse(entryList);
        entryList.forEach(entry -> {
            Board value = entry.getValue();
            System.out.printf("%-4s %-20s %-20s %-20s\n", value.getBno(), value.getBWriter(), dateFormat.format(value.getBDate()), value.getBTitle());
        });
        System.out.println("-".repeat(60));

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
            // 외부에서 사용자가 입력한 데이터 타입은 항상 문자열
            String input = scanner.nextLine();

            if (input.equals("4")) {
                System.out.println("\n게시판 종료");
                break;
            }
            if (!input.matches(menuNumberRegex)) {
                switch (input) {
                    case "1" -> create();
                    case "2" -> read();
                    case "3" -> clear();
                }
            } else {
                System.out.println("[1-4]번 번호를 입력하세요.");
            }
        }
    }

    // 새 글 작성 후 저장 기능 -> Map 컬렉션에 저장
    public void create() {
        System.out.println("\n[새 게시물 입력]");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();

        Map<String, Board> boardMap = boardManager.getBoardMap();

        // 보조 메뉴 중 1번 선택 시
        if (checkMenu()) {
            // BoardBuilder를 사용하여 새 글을 생성
            Board board = Board.builder()
                    .bno(bno)
                    .bTitle(title)
                    .bContent(content)
                    .bWriter(writer)
                    .bDate(new Date())
                    .build();
            boardMap.put(String.valueOf(bno), board);
            boardManager.setBoardMap(boardMap);
        }
    }

    // 보조 메뉴 확인, 선택 메서드
    private boolean checkMenu() {
        System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
        System.out.print("메뉴 선택: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches(checkNumberRegex)) {
                return input.equals("1");
            } else {
                System.out.println("[1 or 2]번을 입력하세요.");
            }
        }
    }

    public void read() {

    }

    public void clear() {

    }
}
