package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_자가진단4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int num = sc.nextInt();

        for (int i = 0; i < Math.min(input.length(), num); i++) {
            System.out.print(input.charAt(input.length()-1-i));
        }
    }
}
