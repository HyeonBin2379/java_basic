package bookproject;

import java.util.Scanner;

public class Welcome {

    // 각 메뉴별 명칭에 관계없이 좌우 정렬을 유지하도록 출력
    private static final String MENU_FORMAT = """
            *******************************************************
                    Welcome to Shopping Mall
                    Welcome to Book Market!
            *******************************************************
             %-20s\t%s
             %-20s\t%s
             %-20s\t%s
             %-20s\t%s
            ******************************************************* 
            """;
    private static final Scanner sc = new Scanner(System.in);

    private static boolean isRunning = true;

    public static void main(String[] args) {
        // 이름과 연락처 입력
        System.out.print("당신의 이름을 입력하세요. : ");
        String name = sc.nextLine();
        System.out.print("연락처를 입력하세요. : ");
        String phoneNumber = sc.nextLine();

        // 반복문에 라벨 부여
        while (isRunning) {
            menuIntroduction();
            // 메뉴 번호 입력
            System.out.print("메뉴 번호를 선택해주세요 : ");
            int menuNum = Integer.parseInt(sc.nextLine());

            // 메뉴 선택
            switch (menuNum) {
                case 1:
                    menuGuestInfo(name, phoneNumber);
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAddItem();
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
                default:
                    System.out.println("1~8 사이의 숫자만 입력 가능합니다.");
            }
        }
    }

    // 선택 가능한 메뉴 목록 출력
    public static void menuIntroduction() {
        // 메뉴 출력
        System.out.printf(MENU_FORMAT,
                "1. 고객 정보 확인하기", "4. 바구니에 항목 추가하기",
                "2. 장바구니 상품 목록 보기", "5. 장바구니의 항목 수량 줄이기",
                "3. 장바구니 비우기", "6. 장바구니의 항목 삭제하기",
                "7. 영수증 표시하기", "8. 종료");
    }

    // 고객 정보 확인하기
    public static void menuGuestInfo(String name, String phoneNumber) {
        // 이름 길이에 관계없이 정렬 형식을 유지하도록 출력
        System.out.printf("현재 고객 정보 :\n이름 %-5s\t연락처 %s\n", name, phoneNumber);
    }

    // 장바구니 상품 목록 보기
    public static void menuCartItemList() {
        System.out.println("2. 장바구니 상품 목록 :");
    }

    // 장바구니 비우기
    public static void menuCartClear() {

    }

    // 바구니에 항목 추가하기
    public static void menuCartAddItem() {

    }

    // 장바구니 항목 수량 줄이기
    public static void menuCartRemoveItemCount() {

    }

    // 장바구니 항목 삭제하기
    public static void menuCartRemoveItem() {

    }

    // 영수증 표시하기
    public static void menuCartBill() {

    }

    // 메뉴 종료
    public static void menuExit() {
        System.out.println("프로그램을 종료합니다.");
        isRunning = false;
    }
}
