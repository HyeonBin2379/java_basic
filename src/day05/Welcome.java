package day05;

import java.util.Scanner;

public class Welcome {

    private static String menu = """
            *************************************************
                          Welcome to Shopping Mall
                          Welcome to Book Market!
            *************************************************
             1. 고객 정보 확인하기     4. 바구니에 항목 추가하기
             2. 장바구니 상품 목록 보기 5. 장바구니 항목 수향 줄이기
             3. 장바구니 비우기        6. 장바구니 항목 삭제하기
             7. 영수증 표시하기        8. 종료
            *************************************************
            """;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요. : ");
        String name = sc.nextLine();

        System.out.print("연락처를 입력하세요. : ");
        String phoneNumber = sc.nextLine();

        Menu:
        while (true) {
            System.out.println(menu);
            System.out.print("메뉴 번호를 선택하세요 : ");
            int menuNum = sc.nextInt();

            switch (menuNum) {
                case 1:
                    System.out.println("현재 고객 정보 :");
                    System.out.printf("이름 %s   연락처 %s\n", name, phoneNumber);
                    break;
                case 8:
                    break Menu;
            }
        }
    }
}
