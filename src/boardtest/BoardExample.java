package boardtest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;
import javabasic_02.day07.Book;

public class BoardExample {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    private static final Scanner input = new Scanner(System.in);
    private static final List<Board> boards = new ArrayList<>();

    private static boolean isRunning = true;

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();
        boardExample.setBoards();
        while (isRunning) {
            try {
                boardExample.list();
            } catch (NumberFormatException e) {
                System.out.println("메뉴 번호가 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setBoards() {
        Calendar calendar = Calendar.getInstance();

        Board board1 = new Board();
        board1.setBno(boards.size()+1);
        board1.setBwriter("winter");
        calendar.set(2024, Calendar.JANUARY, 1);
        board1.setBdate(calendar.getTime());
        board1.setBtitle("게시판에 오신 것을 환영합니다.");
        boards.add(board1);

        Board board2 = new Board();
        board2.setBno(boards.size()+1);
        board2.setBwriter("winter");
        calendar.set(2024, Calendar.JANUARY, 2);
        board2.setBdate(calendar.getTime());
        board2.setBtitle("올 겨울은 많이 춥습니다.");
        boards.add(board2);
    }

    public void list() {
        String listTitle = """
                        [게시물 목록]
                        ---------------------------------------------------------------
                        no\t\twriter\t\tdate\t\ttitle
                        ---------------------------------------------------------------
                        %s
                        ---------------------------------------------------------------
                        """;
        System.out.printf(listTitle, rendering());
        mainMenu();
    }
    private String rendering() {
        StringBuilder sb = new StringBuilder();
        boards.stream()
                .sorted(Comparator.comparing(Board::getBno).reversed())
                .forEach(sb::append);
        return sb.toString();
    }

    public void mainMenu() throws NumberFormatException {
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());

        switch (menuNum) {
            case 1 -> create();
            case 2 -> read();
            case 3 -> clear();
            case 4 -> exit();
            default -> System.out.println("1~4 사이의 숫자만 입력 가능합니다.");
        }
    }

    public void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = input.nextLine();
        input.reset();
        System.out.print("내용: ");
        String content = input.nextLine();
        input.reset();
        System.out.print("작성자: ");
        String writer = input.nextLine();
        input.reset();

        System.out.println("-------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());

        if (menuNum == 1) {
            Board board = new Board();
            board.setBno(boards.size()+1);
            board.setBtitle(title);
            board.setBcontent(content);
            board.setBwriter(writer);
            board.setBdate(new Date());
            boards.add(board);
        }
    }

    public void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(input.nextLine());
        input.reset();

        String boardInfo = """
                ##############
                번호: %d
                제목: %s
                내용: %s
                작성자: %s
                날짜: %s
                ##############
                """;
        Board board = boards.get(findIndex(bno));
        System.out.printf(boardInfo, board.getBno(), board.getBtitle(), board.getBcontent(), board.getBwriter(), formatter.format(board.getBdate()));

        subMenu(board);
    }

    private void subMenu(Board board) {
        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());

        switch (menuNum) {
            case 1 -> update(board);
            case 2 -> delete(board);
            case 3 -> {
                return;
            }
            default -> System.out.println("1~3 사이의 숫자만 입력 가능합니다.");
        }
    }
    public void update(Board board) {
        System.out.println("[수정 내역 입력]");
        System.out.print("제목: ");
        String title = input.nextLine();
        input.reset();
        System.out.print("내용: ");
        String content = input.nextLine();
        input.reset();
        System.out.print("작성자: ");
        String writer = input.nextLine();
        input.reset();

        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());
        input.reset();

        if (menuNum == 1) {
            int index = findIndex(board.getBno());
            board.setBtitle(title);
            board.setBcontent(content);
            board.setBwriter(writer);
            boards.set(index, board);
        }
    }

    public void delete(Board board) throws IllegalArgumentException {
        int index = findIndex(board.getBno());
        IntStream.range(index+1, boards.size()).forEach(idx -> boards.get(idx).setBno(idx));
        boards.remove(board);
    }

    private int findIndex(int bno) {
        return boards.stream()
                .filter(board -> board.getBno() == bno)
                .findFirst()
                .map(boards::indexOf)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 게시글을 찾을 수 없습니다."));
    }

    public void clear() throws NumberFormatException {
        String title = """
                
                [게시물 전체 삭제]
                --------------------------------------------
                보조 메뉴: 1.Ok | 2.Cancel""";
        System.out.println(title);
        System.out.print("메뉴 선택: ");
        int menuNum = Integer.parseInt(input.nextLine());

        if (menuNum == 1) {
            boards.clear();
        }
    }

    public void exit() {
        isRunning = false;
        System.out.println("** 게시판 종료 **");
    }
}
