package jungol.입력;

import java.util.Scanner;

public class 입력_자가진단8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = Double.parseDouble(sc.nextLine());
        double num2 = Double.parseDouble(sc.nextLine());
        String str = sc.nextLine();

        System.out.printf("%.2f\n", num1);
        System.out.printf("%.2f\n", num2);
        System.out.println(str);
    }
}
