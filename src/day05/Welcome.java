package day05;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 이름과 연락처 입력
        System.out.print("당신의 이름을 입력하세요. : ");
        String name = sc.nextLine();

        System.out.print("연락처를 입력하세요. : ");
        String phoneNumber = sc.nextLine();

        // 반복문에 라벨 부여
        Menu:
        while (true) {
            // 메뉴 출력
            System.out.printf(MENU_FORMAT,
                    "1. 고객 정보 확인하기", "4. 바구니에 항목 추가하기",
                    "2. 장바구니 상품 목록 보기", "5. 장바구니의 항목 수량 줄이기",
                    "3. 장바구니 비우기", "6. 장바구니의 항목 삭제하기",
                    "7. 영수증 표시하기", "8. 종료");

            // 메뉴 번호 입력
            System.out.print("메뉴 번호를 선택해주세요 : ");
            int menuNum = sc.nextInt();

            // 메뉴 선택(1, 8번 메뉴만 구현)
            switch (menuNum) {
                case 1:
                    // 이름 길이에 관계없이 정렬 형식을 유지하도록 출력
                    System.out.printf("현재 고객 정보 :\n이름 %-5s\t연락처 %s\n", name, phoneNumber);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    // switch문에서 break문 사용 시 반복문을 바로 탈출하기 위해 라벨 사용
                    break Menu;
                default:
                    System.out.println("1~8 사이의 숫자만 입력 가능합니다.");
            }
        }
    }
}
