package boardtest.v2;

import boardtest.v2.common.BoardText;
import boardtest.v2.common.ValidCheck;
import boardtest.v2.exception.BoardException;

import java.text.SimpleDateFormat;
import java.util.*;

// 사용자가 현재 게시물 목록 열람 가능
// 사용자는 메뉴를 선택하여 게시글 생성, 조회, 삭제 가능
// 사용자는 게시판 프로그램을 종료 가능
public class BoardDAO {

    private static ValidCheck validCheck = new ValidCheck();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // scanner 객체는 이 클래스의 모든 인스턴스가 공용으로 사용 가능
    private static int bno = 1;     // 공용 변수

    // BoardManager가 게시판을 관리
    BoardManager boardManager;

    public BoardDAO() {
    }
    public BoardDAO(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    // 현재 게시판의 전체 게시글 목록을 출력 가능
    public void list() {
        // 게시판은 관리자 담당 -> 관리자로부터 게시판을 받아온다.
        // Manager에게 전체 게시물 목록을 요청
        Map<String, Board> boardMap = boardManager.getBoardMap();
        List<Board> boardList = new LinkedList<>(boardMap.values());
        String boardListData = rendering(boardList);
        System.out.print(BoardText.getBoardList(boardListData));

        mainMenu();
    }

    private String rendering(List<Board> boardList) {
        StringBuilder sb = new StringBuilder();
        // 스트림 사용 -> 원본의 정렬 순서를 유지하면서 역순으로 리스트 출력 가능
        boardList.stream()
                .sorted(Comparator.comparing(Board::getBno).reversed())
                .forEach(board -> sb.append(BoardText.getBoardInfo(BoardText.RECORD, board)));

        return sb.toString();
    }

    // 메인 메뉴를 호출
    public void mainMenu() {
        System.out.println(BoardText.getDecorated(BoardText.BORDER_LINE, BoardText.MAIN_MENU.getText()));
        System.out.print(BoardText.MENU_SELECT.getText());
    }

    // 게시물 메뉴 선택 기능
    public void run() {
        while (true) {
            list();
            // 외부에서 사용자가 입력한 데이터 타입은 항상 문자열
            try {
                String menuNumber = scanner.nextLine();

                validCheck.isMenuValid(menuNumber);
                if (menuNumber.equals("4")) {
                    System.out.println(BoardText.EXIT.getText());
                    break;
                }
                switch (menuNumber) {
                    case "1" -> create();
                    case "2" -> read();
                    case "3" -> clear();
                }
            } catch (BoardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 새 글 작성 후 저장 기능 -> Map 컬렉션에 저장
    public void create() throws BoardException {
        System.out.println(BoardText.CREATE.getText());
        System.out.print(BoardText.TITLE.getText());
        String title = scanner.nextLine();
        System.out.print(BoardText.BOARD.getText());
        String content = scanner.nextLine();
        System.out.print(BoardText.WRITER.getText());
        String writer = scanner.nextLine();

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

            // 새 게시물 추가로 인해 boardMap에서 변동이 발생 -> boardManager의 boardMap을 갱신
            Map<String, Board> boardMap = boardManager.getBoardMap();
            boardMap.put(String.valueOf(bno++), board);
            boardManager.setBoardMap(boardMap);
        }
    }

    // 보조 메뉴 확인 및 선택 메서드
    private boolean checkMenu() {
        System.out.print(BoardText.getSubMenu(BoardText.CHECK_MENU));
        while (true) {
            try {
                System.out.print(BoardText.MENU_SELECT.getText());
                String menuNumber = scanner.nextLine();

                validCheck.isCheckMenuValid(menuNumber);

                return menuNumber.equals("1");
            } catch (BoardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void read() throws BoardException {
        System.out.println(BoardText.READ.getText());
        while (true) {
            try {
                System.out.print(BoardText.BNO.getText());
                String numberInput = scanner.nextLine();
                Map<String, Board> boardMap = boardManager.getBoardMap();

                validCheck.isValidBoardNumber(numberInput, boardMap.keySet());

                Board board = boardMap.get(numberInput);
                System.out.println(BoardText.getReadInfo(board));
                readOption(board.getBno());
                return;
            } catch (BoardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void readOption(int bno) throws BoardException {
        System.out.print(BoardText.getSubMenu(BoardText.READ_CHECK_MENU));
        System.out.print(BoardText.MENU_SELECT.getText());
        String menuNumber = scanner.nextLine();

        validCheck.isReadOptionMenuValid(menuNumber);
        if (menuNumber.equals("3")) {
            return;
        }
        switch (menuNumber) {
            case "1" -> update(bno);
            case "2" -> delete(bno);
        }
    }

    public void update(int bno) throws BoardException {
        System.out.println(BoardText.UPDATE.getText());
        System.out.print(BoardText.TITLE.getText());
        String title = scanner.nextLine();
        System.out.print(BoardText.BOARD.getText());
        String content = scanner.nextLine();
        System.out.print(BoardText.WRITER.getText());
        String writer = scanner.nextLine();

        // 이미 read()에서 bno에 대응되는 Board의 존재 여부에 관한 유효성 검사를 수행
        // 따라서 update()에서는 유효성 검사 불필요
        Map<String, Board> boardMap = boardManager.getBoardMap();
        Board board = boardMap.get(Integer.toString(bno));
        board.setBTitle(title);
        board.setBContent(content);
        board.setBWriter(writer);

        if (checkMenu()) {
            boardMap.replace(Integer.toString(board.getBno()), board);
            boardManager.setBoardMap(boardMap);
        }
    }

    public void delete(int bno) {
        Map<String, Board> boardMap = boardManager.getBoardMap();

        boardMap.remove(Integer.toString(bno));
        boardManager.setBoardMap(boardMap);
    }

    public void clear() {
        System.out.println(BoardText.CLEAR.getText());
        Map<String, Board> boardMap = boardManager.getBoardMap();

        if (boardMap.isEmpty()) {
            System.out.println("게시판에 작성된 게시물이 없습니다.");
            return;
        }
        if (checkMenu()) {
            boardMap.clear();
            boardManager.setBoardMap(boardMap);
        }
    }
}
