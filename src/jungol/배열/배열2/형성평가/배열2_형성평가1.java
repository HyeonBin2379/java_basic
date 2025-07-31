package jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] diceCount = new int[7];
        for (int i = 0; i < 10; i++) {
            int dice = sc.nextInt();
            diceCount[dice]++;
        }
        for (int i = 1; i < diceCount.length; i++) {
            System.out.printf("%d : %d\n", i, diceCount[i]);
        }
    }
}
