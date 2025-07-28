package jungol.선택제어문.자가진단;

import java.util.Scanner;

public class 선택제어문_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String g = sc.next();
        int a = Integer.parseInt(sc.next());

        if (a >= 18) {
            if (g.equals("M")) {
                System.out.println("MAN");
            } else {
                System.out.println("WOMAN");
            }
        } else {
            if (g.equals("M")) {
                System.out.println("BOY");
            } else {
                System.out.println("GIRL");
            }
        }
    }
}
