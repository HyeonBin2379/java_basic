package javabasic_01.jungol.입력;

import java.util.Scanner;

public class 입력_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("height = ");
        int height = sc.nextInt();


        System.out.printf("Your height is %dcm.\n", height);
    }
}
