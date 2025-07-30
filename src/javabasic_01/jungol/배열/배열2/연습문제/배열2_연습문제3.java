package javabasic_01.jungol.배열.배열2.연습문제;

public class 배열2_연습문제3 {

    public static void main(String[] args) {
        int[] arr = new int[41];
        for (int i = 1; i <= 40; i++) {
            arr[i] = i <= 2 ? 1 : arr[i-1]+arr[i-2];
        }

        for (int i = 10; i <= 40; i += 10) {
            System.out.printf("피보나치 수열 %d항: %d\n", i, arr[i]);
        }
    }
}
