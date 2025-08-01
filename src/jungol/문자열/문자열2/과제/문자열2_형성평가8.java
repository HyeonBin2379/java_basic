package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while (true) {
            String str = sc.nextLine();

            if (str.equals("END")) {
                break;
            }
            sb.append(str);
            System.out.println(sb.reverse());
            sb.delete(0, sb.length());
        }
    }
}
