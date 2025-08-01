package jungol.문자열.문자열2;

import java.util.Scanner;

public class 문자열2_연습문제8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            sum1 += str1.charAt(i);
            sum2 += str2.charAt(i);
        }

        if (sum1 != sum2) {
            System.out.printf("%s 가(이) 더 큽니다.\n", Math.max(sum1, sum2) == sum1 ? str1 : str2);
        } else {
            System.out.printf("%s와 %s는 같습니다.\n", str1, str2);
        }

        String subStr1 = str1.substring(0, 3);
        String subStr2 = str2.substring(0, 3);
        System.out.println(subStr1.equals(subStr2) ? "앞의 세 문자가 같습니다." : "앞의 세 문자가 같지 않습니다.");
    }
}
