package boardtest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class BoardExample {

    private static final Scanner input = new Scanner(System.in);
    private static final List<Board> boards = new ArrayList<>();

    private static int count = 0;
    private static boolean isRunning = true;

    public static void main(String[] args) throws ParseException {
        list();
    }

    public static void list() throws ParseException {
        Board board1 = new Board();
        board1.setBno(++count);
        board1.setBwriter("winter");
        board1.setBdate(new Date());
        board1.setBtitle("게시판에 오신 것을 환영합니다.");
        boards.add(board1);

        Board board2 = new Board();
        board2.setBno(++count);
        board2.setBwriter("winter");
        board2.setBdate(new Date());
        board2.setBtitle("올 겨울은 많이 춥습니다.");
        boards.add(board2);

        while (isRunning) {
            String listTitle = """
                    [게시물 목록]
                    ---------------------------------------------------------------
                    no\t\twriter\t\tdate\t\ttitle
                    ---------------------------------------------------------------
                    """;
            System.out.print(listTitle);
            boards.stream()
                    .sorted(Comparator.comparingInt(Board::getBno).reversed())
                    .forEach(System.out::println);
            System.out.println("\n---------------------------------------------------------------");

            mainMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("메인 메뉴: 1. Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        int menuNum = input.nextInt();

        switch (menuNum) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                clear();
                break;
            case 4:
                exit();
                break;
        }
    }

    public static void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = input.next();
        input.nextLine();
        System.out.print("내용: ");
        String content = input.next();
        input.nextLine();
        System.out.print("작성자: ");
        String writer = input.next();
        input.nextLine();

        System.out.println("-------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());

        if (menuNum == 1) {
            Board board = new Board();
            board.setBno(++count);
            board.setBtitle(title);
            board.setBcontent(content);
            board.setBwriter(writer);
            board.setBdate(Timestamp.valueOf(LocalDateTime.now()));
            boards.add(board);
        }

        System.out.println("** create() 메소드 실행됨 **");
    }

    public static void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(input.next());
        input.nextLine();

        String boardInfo = """
                ##############
                번호: %d
                제목: %s
                내용: %s
                작성자: %s
                날짜: %s
                ##############
                """;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Board board = boards.get(bno-1);
        System.out.printf(boardInfo, board.getBno(), board.getBtitle(), board.getBcontent(), board.getBwriter(), formatter.format(board.getBdate()));
        subMenu(bno);
        System.out.println("** read() 메소드 실행됨 **");
    }

    public static void subMenu(int bno) {
        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.next());
        input.nextLine();

        switch (menuNum) {
            case 1:
                update(bno);
                break;
            case 2:
                delete(bno);
                break;
        }
    }
    public static void update(int bno) {
        System.out.println("[수정 내역 입력]");
        System.out.print("제목: ");
        String title = input.next();
        input.nextLine();
        System.out.print("내용: ");
        String content = input.next();
        input.nextLine();
        System.out.print("작성자: ");
        String writer = input.next();
        input.nextLine();

        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.next());
        input.nextLine();

        if (menuNum == 1) {
            int index = findIndex(bno);
            boards.get(index).setBtitle(title);
            boards.get(index).setBcontent(content);
            boards.get(index).setBwriter(writer);
        }
    }

    public static void delete(int bno) {
        Board found = boards.get(findIndex(bno));
        boards.remove(found);
    }

    private static int findIndex(int bno) {
        return boards.stream()
                .filter(board -> board.getBno() == bno)
                .findFirst()
                .map(boards::indexOf)
                .get();
    }

    public static void clear() {
        String title = """
                
                [게시물 전체 삭제]
                --------------------------------------------
                보조 메뉴: 1.Ok | 2.Cancel""";
        System.out.println(title);
        System.out.print("메뉴 선택: ");
        int menuNum = input.nextInt();

        if (menuNum == 1) {
            boards.clear();
            return;
        }
        System.out.println("** clear() 메소드 실행됨 **");
    }

    public static void exit() {
        isRunning = false;
        System.out.println("** 게시판 종료 **");
    }
}
