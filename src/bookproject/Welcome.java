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

        while (true) {
            // 구매할 도서 ID 입력
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            String str = input.next();
            input.nextLine();

            // 구매할 도서 ID에 대응되는 도서를 도서목록에서 검색
            int index = findBookByNumId(bookList, str);
            Book book = (index != -1) ? bookList.get(index) : null;

            if (book != null) { // 구매하려는 도서가 도서목록에 존재
                System.out.println("장바구니에 추가하겠습니까? Y | N ");
                str = input.nextLine();

                // 선택한 도서가 장바구니에 있다면, 찾은 도서를 구매대상으로 선택
                if (str.equalsIgnoreCase("Y")
                        && !isCartInBook(book.getBookId())) {
                    mCart.insertBook(book);
                    System.out.println(book.getBookId() + " 도서가 장바구니에 추가되었습니다.");
                }
                return;
            }     // 찾는 도서가 도서목록에 없음
            System.out.println("다시 입력해 주세요");
        }
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

        while (true) {
            System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
            String str = input.next();

            if (mCart.isCartInBook(str)) {
                int index = mCart.indexOf(str);
                System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
                str = input.next();

                if (str.equalsIgnoreCase("Y")) {
                    CartItem cartItem = mCart.getCartItem(index);
                    mCart.removeCart(index);
                    System.out.println(cartItem.getBookID() + " 장바구니에서 도서가 삭제되었습니다.");
                }
                return;
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
        String[] tuples = {
                "ISBN1234 | 쉽게 배우는 JSP 웹 프로그래밍 | 27000 | 송미영 | 단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍 | IT전문서 | 2018/10/08",
                "ISBN1235 | 안드로이드 프로그래밍 | 33000 | 우재남 | 실습 단계별 명쾌한 멘토링! | IT전문서 | 2022/01/22",
                "ISBN1236 | 안드로이드 프로그래밍 | 33000 | 고광일 | 컴퓨팅 사고력을 키우는 블록 코딩 | 컴퓨터입문 | 2019/06/10"
        };

        for (int i = 0; i < tuples.length; i++) {
            String[] attributes = tuples[i].split(" \\| ");
            int index = findBookByNumId(bookList, attributes[0]);
            if (index != -1) {
                continue;
            }
            bookList.add(new Book(attributes[0], attributes[1], Integer.parseInt(attributes[2])));
            bookList.get(i).setAuthor(attributes[3]);
            bookList.get(i).setDescription(attributes[4]);
            bookList.get(i).setCategory(attributes[5]);
            bookList.get(i).setReleaseDate(attributes[6]);
        }
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

    private static int findBookByNumId(List<Book> bookList, String bookId) {
        for (Book book : bookList) {
            if (bookId.equals(book.getBookId())) {
                return bookList.indexOf(book);
            }
        }
        return -1;
    }
}
