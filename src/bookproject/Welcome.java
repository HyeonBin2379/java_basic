package bookproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Welcome {

    // 각 메뉴별 명칭에 관계없이 좌우 정렬을 유지하도록 출력
    private static final String MENU = """
            *******************************************************
                    Welcome to Shopping Mall
                    Welcome to Book Market!
            *******************************************************
             1. 고객 정보 확인하기\t\t4. 바구니에 항목 추가하기
             2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기
             3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기
             7. 영수증 표시하기\t\t8. 종료
             9. 관리자 로그인
            *******************************************************""";
    private static final Scanner input = new Scanner(System.in);
    private static final Cart mCart = new Cart();

    private static boolean isRunning = true;
    private static User mUser;

    public static void main(String[] args) {
        List<Book> mBookList = new ArrayList<>();

        // 현재 사용자의 이름과 연락처 입력 -> 사용자 객체 생성
        System.out.print("당신의 이름을 입력하세요. : ");
        String userName = input.nextLine();
        System.out.print("연락처를 입력하세요. : ");
        String userMobile = input.nextLine();

        mUser = new User(userName, userMobile);
        // 반복문에 라벨 부여
        while (isRunning) {
            // 메뉴 출력 후 메뉴 번호 입력
            menuIntroduction();
            System.out.print("메뉴 번호를 선택해주세요 : ");
            int menuNum = input.nextInt();

            if (menuNum < 1 || menuNum > 9) {
                System.out.println("1~9 사이의 숫자만 입력 가능합니다.");
                continue;
            }
            // 메뉴 선택
            switch (menuNum) {
                case 1:
                    menuGuestInfo(userName, userMobile);
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAddItem(mBookList);
                    break;
                case 5:
                    menuCartRemoveItemCount();
                    break;
                case 6:
                    menuCartRemoveItem();
                    break;
                case 7:
                    menuCartBill();
                    break;
                case 8:
                    menuExit();
                    break;
                case 9:
                    menuAdminLogin();
                    break;
            }
        }
    }

    // 선택 가능한 메뉴 목록 출력
    public static void menuIntroduction() {
        // 메뉴 출력
        System.out.println(MENU);
    }

    // 사용자 정보 출력하기
    public static void menuGuestInfo(String name, String mobile) {
        // 이름 길이에 관계없이 정렬 형식을 유지하도록 출력
        System.out.println("현재 고객 정보 :");
        System.out.printf("이름 %-5s\t연락처 %s\n", mUser.getName(), mUser.getPhone());
    }

    // 장바구니 상품 목록 보기
    public static void menuCartItemList() {
        mCart.printCart();
    }

    // 장바구니 비우기
    public static void menuCartClear() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니의 항목이 없습니다.");
            return;
        }
        System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
        String str = input.next();

        if (str.equalsIgnoreCase("Y")) {
            System.out.println("장바구니의 모든 항목을 삭제했습니다.");
            mCart.deleteBook();
        }
    }

    // 바구니에 항목 추가하기
    public static void menuCartAddItem(List<Book> bookList) {
        // 도서 목록 생성
        BookList(bookList);

        // 현재 도서 목록 출력
        for (Book book : bookList) {
            System.out.println(book);
        }

        boolean quit = false;
        while (!quit) {
            // 구매할 도서 ID 입력
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            String str = input.next();
            input.nextLine();

            // 구매할 도서 ID에 대응되는 도서를 도서목록에서 검색
            int index = findIndexByNumId(bookList, str);
            Book book = bookList.get(index);

            if (book != null) { // 구매하려는 도서가 도서목록에 존재
                System.out.println("장바구니에 추가하겠습니까? Y | N ");
                str = input.nextLine();

                // 찾은 도서를 구매대상으로 선택
                if (str.equalsIgnoreCase("Y")) {
                    System.out.println(book.getBookId() + " 도서가 장바구니에 추가되었습니다.");
                    // 선택한 도서가 장바구니에 있는지 확인
                    if (!isCartInBook(book.getBookId())) {
                        mCart.insertBook(book);
                    }
                }
                quit = true;
                continue;
            }     // 찾는 도서가 도서목록에 없음
            System.out.println("다시 입력해 주세요");
        }
    }
    private static int findIndexByNumId(List<Book> bookList, String bookId) {
        for (Book book : bookList) {
            if (bookId.equals(book.getBookId())) {
                return bookList.indexOf(book);
            }
        }
        return -1;
    }

    // 장바구니 항목 수량 줄이기
    public static void menuCartRemoveItemCount() {
        System.out.println("5. 장바구니의 항목 수량 줄이기");
    }

    // 장바구니 항목 삭제하기
    public static void menuCartRemoveItem() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
            return;
        }
        menuCartItemList();

        boolean quit = false;
        while (!quit) {
            System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
            String str = input.next();
            int index = mCart.indexOf(str);

            if (index != -1) {
                System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
                str = input.next();
                if (str.equalsIgnoreCase("Y")) {
                    System.out.println(str + " 장바구니에서 도서가 삭제되었습니다.");
                    mCart.removeCart(index);
                }
                quit = true;
                continue;
            }
            System.out.println("다시 입력해 주세요.");
        }
    }

    // 영수증 표시하기
    public static void menuCartBill() {
        System.out.println("7. 영수증 표기하기");
    }

    // 메뉴 종료
    public static void menuExit() {
        System.out.println("프로그램을 종료합니다.");
        isRunning = false;
    }

    // 도서 목록 생성
    public static void BookList(List<Book> bookList) {
        bookList.add(new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000));
        bookList.get(0).setAuthor("송미영");
        bookList.get(0).setDescription("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
        bookList.get(0).setCategory("IT전문서");
        bookList.get(0).setReleaseDate("2018/10/08");

        bookList.add(new Book("ISBN1235", "안드로이드 프로그래밍", 33000));
        bookList.get(1).setAuthor("우재남");
        bookList.get(1).setDescription("실습 단계별 명쾌한 멘토링!");
        bookList.get(1).setCategory("IT전문서");
        bookList.get(1).setReleaseDate("2022/01/22");

        bookList.add(new Book("ISBN1236", "안드로이드 프로그래밍", 33000));
        bookList.get(2).setAuthor("고광일");
        bookList.get(2).setDescription("컴퓨팅 사고력을 키우는 블록 코딩");
        bookList.get(2).setCategory("컴퓨터입문");
        bookList.get(2).setReleaseDate("2019/06/10");
    }

    public static boolean isCartInBook(String bookId) {
        return mCart.isCartInBook(bookId);
    }

    public static void menuAdminLogin() {
        // 관리자 정보 입력 -> 관리자계정 로그인 시도
        System.out.println("관리자 정보를 입력하세요");
        System.out.print("아이디 : ");
        String adminId = input.next();
        System.out.print("비밀번호 : ");
        String adminPW = input.next();

        // 현재 로그인을 시도한 사용자가 관리자라고 가정
        Admin admin = new Admin(mUser.getName(), mUser.getPhone());

        // 입력한 ID, 비밀번호가 관리자 계정과 일치하는지 확인
        if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPassword())) {
            // 일치하면 관리자의 인적사항을 모두 출력
            System.out.printf("이름 %s   연락처 %s\n", admin.getName(), admin.getPhone());
            System.out.printf("아이디 %s   비밀번호 %s\n", admin.getId(), admin.getPassword());
            return;
        }
        System.out.println("관리자 정보가 일치하지 않습니다.");
    }
}
