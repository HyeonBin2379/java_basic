package day05;

import java.util.Scanner;

public class Welcome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요. : ");
        String name = sc.nextLine();
        System.out.println("연락처를 입력하세요. : ");
        String phoneNumber = sc.nextLine();
        System.out.println("*******************************************");
        System.out.println("        Welcome to Shopping Mall");
        System.out.println("        Welcome to Book Market!");
        System.out.println("*******************************************");
        System.out.println("메뉴 번호를 선택하세요 : ");
        System.out.printf("현재 고객 정보 : \n이름 %s   연락처 %s\n", name, phoneNumber);
    }
}
