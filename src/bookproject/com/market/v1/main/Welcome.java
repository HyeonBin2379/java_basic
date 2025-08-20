package bookproject.com.market.v1.main;

import bookproject.com.market.v1.bookitem.Book;
import bookproject.com.market.v1.bookitem.BookList;
import bookproject.com.market.v1.cart.Cart;
import bookproject.com.market.v1.cart.CartItem;
import bookproject.com.market.v1.member.Admin;
import bookproject.com.market.v1.member.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
             2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 수정
             3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기
             7. 영수증 표시하기\t\t8. 종료
             9. 관리자 로그인
            *******************************************************""";
    private static final List<String> tuples = Arrays.asList(
            "ISBN1234 | 쉽게 배우는 JSP 웹 프로그래밍 | 27000 | 송미영 | 단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍 | IT전문서 | 2018/10/08",
            "ISBN1235 | 안드로이드 프로그래밍 | 33000 | 우재남 | 실습 단계별 명쾌한 멘토링! | IT전문서 | 2022/01/22",
            "ISBN1236 | 안드로이드 프로그래밍 | 33000 | 고광일 | 컴퓨팅 사고력을 키우는 블록 코딩 | 컴퓨터입문 | 2019/06/10"
    );
    private static final Cart mCart = new Cart();

    private static boolean isRunning = true;
    private static User mUser;

    public static void main(String[] args) {
        BookList mBookList = new BookList(tuples);
        // 현재 사용자의 이름과 연락처 입력 -> 사용자 객체 생성
        Scanner input = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요. : ");
        String userName = input.nextLine();
        System.out.print("연락처를 입력하세요. : ");
        String userMobile = input.nextLine();

        mUser = new User(userName, userMobile);

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
                case 1 -> menuGuestInfo(userName, userMobile);
                case 2 -> menuCartItemList();
                case 3 -> menuCartClear();
                case 4 -> menuCartAddItem(mBookList);
                case 5 -> menuCartRemoveItemCount();
                case 6 -> menuCartRemoveItem();
                case 7 -> menuCartBill();
                case 8 -> menuExit();
                case 9 -> menuAdminLogin();
            }
        }
    }

    // 선택 가능한 메뉴 목록 출력
    public static void menuIntroduction() {
        System.out.println(MENU);
    }

    // 사용자 정보 출력하기
    public static void menuGuestInfo(String name, String mobile) {
        // 이름 길이에 관계없이 정렬 형식을 유지하도록 출력
        String userInfoFormat = """
                현재 고객 정보 :
                이름 %-5s\t연락처 %s
                """;
        System.out.printf(userInfoFormat, name, mobile);
    }

    // 장바구니 상품 목록 보기
    public static void menuCartItemList() {
        mCart.printCart();
    }

    // 장바구니 비우기
    public static void menuCartClear() {
        // 장바구니가 빈 경우
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니의 항목이 없습니다.");
            return;
        }
        // 장바구니의 모든 항목 삭제
        System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
        Scanner input = new Scanner(System.in);
        String str = input.next();

        if (str.equalsIgnoreCase("Y")) {
            mCart.deleteBook();
            System.out.println("장바구니의 모든 항목을 삭제했습니다.");
        }
    }

    // 바구니에 항목 추가하기
    public static void menuCartAddItem(BookList bookList) {
        // 도서 목록 출력
        bookList.print();

        // 장바구니에 항목 추가
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            // 구매할 도서 ID 입력
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            String str = input.next();
            input.nextLine();

            // 구매할 도서 ID에 대응되는 도서를 도서목록에서 검색
            Book book = bookList.findByBookId(str);

            // 구매할 도서가 도서목록에 없음
            if (book == null) {
                System.out.println("다시 입력해 주세요");
                continue;
            }
            // 구매하려는 도서가 도서목록에 존재
            System.out.println("장바구니에 추가하겠습니까? Y | N ");
            str = input.nextLine();

            // 선택한 도서가 장바구니에 있다면, 찾은 도서를 구매대상으로 선택
            if (str.equalsIgnoreCase("Y")
                    && !isCartInBook(book.getBookId())) {
                mCart.insertBook(book);
                System.out.println(book.getBookId() + " 도서가 장바구니에 추가되었습니다.");
                quit = true;
            }
        }
    }

    // 장바구니 항목 수량 줄이기
    public static void menuCartRemoveItemCount() {
        System.out.println("5. 장바구니의 항목 수량 수정");
    }

    // 장바구니 항목 삭제하기
    public static void menuCartRemoveItem() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
            return;
        }
        menuCartItemList();

        while (true) {
            System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
            Scanner input = new Scanner(System.in);
            String str = input.next();

            if (mCart.isCartInBook(str)) {
                String bookId = str;
                System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
                str = input.next();

                if (str.equalsIgnoreCase("Y")) {
                    CartItem cartItem = mCart.getCartItem(bookId);
                    mCart.removeCart(cartItem);
                    System.out.println(cartItem.getBookID() + " 장바구니에서 도서가 삭제되었습니다.");
                }
                return;
            }
            System.out.println("다시 입력해 주세요.");
        }
    }

    // 영수증 표시하기
    public static void menuCartBill() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("배송받을 분은 고객 정보와 같습니까? Y | N");
        String str = input.nextLine();

        if (str.equalsIgnoreCase("Y")) {
            System.out.print("배송지를 입력해주세요 ");
            String address = input.nextLine();
            printBill(mUser.getName(), mUser.getPhone(), address);
            return;
        }

        System.out.print("배송받을 고객명을 입력하세요 ");
        String name = input.nextLine();
        System.out.print("배송받을 고객의 연락처를 입력하세요 ");
        String phone = input.nextLine();
        System.out.print("배송받을 고객의 배송지를 입력하세요 ");
        String address = input.nextLine();
        printBill(name, phone, address);
    }

    public static void printBill(String name, String phone, String address) {
        LocalDate today = LocalDate.now();
        String strDate = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        String header = """
                -------------배송받을 고객 정보---------------
                고객명 : %s  \t\t연락처 : %s
                배송지 : %s\t\t발송일 : %s
                """;
        System.out.printf(header, name, phone, address, strDate);

        menuCartItemList();

        String footer = """
                \t\t\t주문 총금액 : %d원
                -------------------------------------------
                """;
        System.out.printf(footer, mCart.calculateTotalPrice());
    }

    // 메뉴 종료
    public static void menuExit() {
        System.out.println("프로그램을 종료합니다.");
        isRunning = false;
    }

    public static boolean isCartInBook(String bookId) {
        return mCart.isCartInBook(bookId);
    }

    public static void menuAdminLogin() {
        Scanner input = new Scanner(System.in);
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
