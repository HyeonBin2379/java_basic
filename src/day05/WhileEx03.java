package day05;

import java.util.Scanner;

public class WhileEx03 {

    public static void main(String[] args) {
        // 키보드에서 "1" 입력 시 속도 증가, "2" 입력 시 속도 감소, "3" 입력 시 프로그램 종료
        Scanner sc = new Scanner(System.in);
        int speed = 0;
//        boolean run = true;
//
//        while (run) {
//            System.out.println("------------------");
//            System.out.println("1. 속도 증가 | 2. 속도 감속 | 3. 종료");
//            System.out.println("------------------");
//            System.out.print("선택하세요 : ");
//            String stringNum = sc.nextLine();
//
//            if (stringNum.equals("1")) {
//                speed++;
//                System.out.println("현재 속도 = " + speed);
//            } else if (stringNum.equals("2")) {
//                speed--;
//                System.out.println("현재 속도 = " + speed);
//            } else if (stringNum.equals("3")) {
//                run = false;
//                System.out.println("엔진 끄기");
//            }
//        }

        while (true) {
            System.out.println("------------------");
            System.out.println("1. 속도 증가 | 2. 속도 감속 | 3. 종료");
            System.out.println("------------------");
            System.out.print("선택하세요 : ");
            String stringNum = sc.nextLine();

            switch (stringNum) {
                case "1":
                    speed += 1;
                    System.out.println("현재 속도 = " + speed);
                    break;
                case "2":
                    speed -= 1;
                    System.out.println("현재 속도 = " + speed);
                    break;
                case "3":
                    System.out.println("엔진 끄기");
                    return;
                default:
                    System.out.println("1, 2, 3만 입력");
            }
        }
    }
}
