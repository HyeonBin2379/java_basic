package bookproject.com.market.v1.main;

import static bookproject.com.market.v1.common.BookMarketText.*;

import bookproject.com.market.v1.bookitem.Book;
import bookproject.com.market.v1.bookitem.BookManager;
import bookproject.com.market.v1.cart.Cart;
import bookproject.com.market.v1.cart.CartItem;
import bookproject.com.market.v1.common.BookMarketText;
import bookproject.com.market.v1.member.Admin;
import bookproject.com.market.v1.member.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Welcome {

    private static final List<String> tuples = Arrays.asList(
            "ISBN1234 | 쉽게 배우는 JSP 웹 프로그래밍 | 27000 | 송미영 | 단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍 | IT전문서 | 2018/10/08",
            "ISBN1235 | 안드로이드 프로그래밍 | 33000 | 우재남 | 실습 단계별 명쾌한 멘토링! | IT전문서 | 2022/01/22",
            "ISBN1236 | 안드로이드 프로그래밍 | 33000 | 고광일 | 컴퓨팅 사고력을 키우는 블록 코딩 | 컴퓨터입문 | 2019/06/10"
    );

    private static final Scanner input = new Scanner(System.in);
    private static final Cart mCart = new Cart();
    private static boolean isRunning;

    private final BookManager mBookManager;
    private User mUser;

    public Welcome(BookManager mBookManager) {
        this.mBookManager = mBookManager;
        this.mBookManager.setBookData(tuples);
    }

    public void run() {
        // 현재 사용자의 이름과 연락처 입력 -> 사용자 객체 생성
        System.out.print("당신의 이름을 입력하세요. : ");
        String userName = input.nextLine();
        System.out.print("연락처를 입력하세요. : ");
        String userMobile = input.nextLine();

        mUser = new User(userName, userMobile);
        isRunning = true;
        while (isRunning) {
            // 메뉴 출력 후 메뉴 번호 입력
            menuIntroduction();
            System.out.print("메뉴 번호를 선택해주세요 : ");
            int menuNum = Integer.parseInt(input.nextLine());

            if (menuNum < 1 || menuNum > 9) {
                System.out.println("1~9 사이의 숫자만 입력 가능합니다.");
                continue;
            }
            // 메뉴 선택
            switch (menuNum) {
                case 1 -> menuGuestInfo(userName, userMobile);
                case 2 -> menuCartItemList();
                case 3 -> menuCartClear();
                case 4 -> menuCartAddItem(mBookManager);
                case 5 -> menuCartRemoveItemCount();
                case 6 -> menuCartRemoveItem();
                case 7 -> menuCartBill();
                case 8 -> menuExit();
                case 9 -> menuAdminLogin();
            }
        }
    }

    // 선택 가능한 메뉴 목록 출력
    public void menuIntroduction() {
        System.out.println(MENU.getText());
    }

    // 사용자 정보 출력하기
    public void menuGuestInfo(String name, String mobile) {
        // 이름 길이에 관계없이 정렬 형식을 유지하도록 출력
        System.out.printf(USER_INFO.getText(), name, mobile);
    }

    // 장바구니 상품 목록 보기
    public void menuCartItemList() {
        mCart.printCart();
    }

    // 장바구니 비우기
    public void menuCartClear() {
        // 장바구니가 빈 경우
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니의 항목이 없습니다.");
            return;
        }
        // 장바구니의 모든 항목 삭제
        if (checkYesOrNo(CLEAR_CART)) {
            mCart.deleteBook();
            System.out.println("장바구니의 모든 항목을 삭제했습니다.");
        }
    }

    private boolean checkYesOrNo(BookMarketText msg) {
        System.out.printf(CHECK_MENU.getText(), msg.getText());
        String yesOrElse = input.nextLine();
        return yesOrElse.equalsIgnoreCase("Y");
    }

    // 바구니에 항목 추가하기
    public void menuCartAddItem(BookManager bookManager) {
        // 도서 목록 출력
        mCart.printBookList(bookManager.getBookList());

        // 장바구니에 항목 추가
        while (true) {
            // 구매할 도서 ID 입력
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            String bookID = input.nextLine();
            // 구매할 도서 ID에 대응되는 도서를 도서목록에서 검색
            Book book = bookManager.getBook(bookID);

            // 구매할 도서가 도서목록에 존재
            if (book != null) {
                if (checkYesOrNo(ADD_CART)) {
                    // 선택한 도서를 구매대상으로 선택
                    mCart.insertBook(book);
                    System.out.println(book.getBookId() + " 도서가 장바구니에 추가되었습니다.");
                }
                return;
            }
            System.out.println("다시 입력해 주세요");
        }
    }

    // 장바구니 항목 수량 줄이기
    public void menuCartRemoveItemCount() {
        while (true) {
            System.out.print("장바구니에서 수량을 줄일 도서의 ID를 입력하세요 :");
            String bookID = input.nextLine();
            System.out.print("장바구니 항목에서 줄일 도서의 수량을 입력하세요 :");
            int quantity = Integer.parseInt(input.nextLine());

            if (mCart.isCartInBook(bookID)) {
                CartItem cartItem = mCart.getCartItem(bookID);

                if (cartItem.getQuantity() < quantity) {
                    System.out.println(cartItem.getBookID() + "의 수량을 더 이상 줄일 수 없습니다.");
                    continue;
                }
                if (checkYesOrNo(REMOVE_ITEM_COUNT)) {
                    int index = mCart.indexOf(cartItem);
                    cartItem.setQuantity(cartItem.getQuantity()-quantity);
                    mCart.updateCart(index, cartItem);
                }
                return;
            }
        }
    }

    // 장바구니 항목 삭제하기
    public void menuCartRemoveItem() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
            return;
        }
        menuCartItemList();
        while (true) {
            System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
            String bookID = input.nextLine();

            if (mCart.isCartInBook(bookID)) {
                if (checkYesOrNo(DELETE_CART_ITEM)) {
                    CartItem cartItem = mCart.getCartItem(bookID);
                    mCart.removeCart(mCart.indexOf(cartItem));
                    System.out.println(cartItem.getBookID() + " 장바구니에서 도서가 삭제되었습니다.");
                }
                return;
            }
            System.out.println("다시 입력해 주세요.");
        }
    }

    // 영수증 표시하기
    public void menuCartBill() {
        if (mCart.isCartEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
            return;
        }
        if (checkYesOrNo(IS_SAME_USER)) {
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

    public void printBill(String name, String phone, String address) {
        LocalDate today = LocalDate.now();
        String strDate = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.printf(BILL_HEADER.getText(), name, phone, address, strDate);

        menuCartItemList();

        int totalPrice = mCart.calculateTotalPrice();
        System.out.printf(BILL_FOOTER.getText(), totalPrice);
    }

    // 메뉴 종료
    public void menuExit() {
        System.out.println("프로그램을 종료합니다.");
        isRunning = false;
    }

    public boolean isCartInBook(String bookId) {
        return mCart.isCartInBook(bookId);
    }

    public void menuAdminLogin() {
        // 관리자 정보 입력 -> 관리자계정 로그인 시도
        System.out.println("관리자 정보를 입력하세요");
        System.out.print("아이디 : ");
        String loginID = input.nextLine();
        System.out.print("비밀번호 : ");
        String loginPW = input.nextLine();

        // 현재 로그인을 시도한 사용자가 관리자라고 가정
        Admin admin = new Admin(mUser.getName(), mUser.getPhone());

        // 입력한 ID, 비밀번호가 관리자 계정과 일치하는지 확인
        if (loginID.equals(admin.getId()) && loginPW.equals(admin.getPassword())) {
            // 일치하면 관리자의 인적사항을 모두 출력
            System.out.printf(ADMIN_INFO.getText(), admin.getName(), admin.getPhone(), admin.getId(), admin.getPassword());
            return;
        }
        System.out.println("관리자 정보가 일치하지 않습니다.");
    }
}
