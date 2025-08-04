package javabasic_02.test.loop_array;

public class JavaBasic3 {

    public static void main(String[] args) {
        while (true) {
            int dice1 = (int)(Math.random()*6)+1;
            int dice2 = (int)(Math.random()*6)+1;
            int sum = dice1+dice2;

            System.out.printf("(%d, %d)\n", dice1, dice2);
            if (sum == 5) {
                System.out.println("주사위 눈의 수의 합이 5가 되어 종료합니다.");
                break;
            }
            System.out.printf("sum: %d\n", sum);
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i+j == 5) {
                    System.out.printf("(%d, %d)\n", i, j);
                }
            }
        }
    }
}
