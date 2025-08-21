package boardtest.v2.common;

import boardtest.v2.Board;

import java.text.SimpleDateFormat;

public enum BoardText {

    // 게시물 리스트 및 메인메뉴 출력 관련
    BORDER_LINE("-".repeat(60)),
    BOARD_LIST_FORMAT("""
                
                [게시물 목록]
                %1$s
                %2$s
                """),
    BOARD_TITLE(String.format("%-4s %-20s %-20s %-20s","no", "writer", "date", "title")),
    RECORD("%1$-4s %3$-20s %4$-20s %2$-20s\n"),
    DECORATED_TITLE("""
            %1$s
            %2$s
            %1$s"""),
    MAIN_MENU("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit"),
    MENU_SELECT("메뉴 선택: "),

    // 게시물 관련 작업별 타이틀
    CREATE("\n[새 게시물 입력]"),
    UPDATE("\n[수정 내용 입력]"),
    CLEAR("\n[게시물 전체 삭제]"),
    EXIT("\n게시판 종료"),
    READ("\n[게시물 읽기]"),

    // 게시물 읽기 관련 출력형식
    READ_NUMBER("bno: "),
    READ_LINE("#".repeat(30)),
    READ_INFO("""
            번호: %1$s
            제목: %2$s
            내용: %3$s
            작성자: %4$s
            날짜: %5$s"""),

    // 게시물 데이터 입력 형식
    BNO("번호: "),
    TITLE("제목: "),
    BOARD("내용: "),
    WRITER("작성자: "),

    // 보조 메뉴 출력 형식
    SUB_MENU_FORMAT("""
            %1$s
            %2$s
            """),
    CHECK_MENU("보조 메뉴: 1.OK | 2. Cancel"),
    READ_CHECK_MENU("보조 메뉴: 1.Update | 2. Delete | 3.List");

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final String text;

    BoardText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    /*
        게시물 데이터별 특정 형식을 적용
    * */
    public static String getBoardList(String boardListData) {
        return String.format(BOARD_LIST_FORMAT.text, getDecorated(BORDER_LINE, BOARD_TITLE.text), boardListData);
    }

    public static String getDecorated(BoardText deco, String boardText) {
        return String.format(DECORATED_TITLE.text, deco.text, boardText);
    }

    public static String getReadInfo(Board board) {
        return getDecorated(READ_LINE, BoardText.getBoardInfo(READ_INFO, board));
    }

    public static String getBoardInfo(BoardText format, Board board) {
        if (format == BoardText.RECORD) {
            return String.format(RECORD.text,
                    board.getBno(), board.getBTitle(),
                    board.getBWriter(), dateFormat.format(board.getBDate()));
        }
        return String.format(READ_INFO.text,
                    board.getBno(), board.getBTitle(),
                    board.getBContent(), board.getBWriter(), dateFormat.format(board.getBDate()));
    }

    public static String getSubMenu(BoardText boardText) {
        return String.format(SUB_MENU_FORMAT.text, BORDER_LINE.text, boardText.text);
    }
}
