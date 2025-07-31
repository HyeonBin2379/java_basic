package jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letter = sc.nextLine().charAt(0);

        char[] jungol = {'J', 'U', 'N', 'G', 'O', 'L'};
        int index = -1;
        for (int i = 0; i < 6; i++) {
            if (jungol[i] == letter) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("none");
        } else {
            System.out.println(index);
        }
    }
}
