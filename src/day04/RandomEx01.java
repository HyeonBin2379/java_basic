package day04;

public class RandomEx01 {

    public static void main(String[] args) {
        Math.random();                      // 0.0 <= random() < 1.0

        // 0.0*6 <= Math.random() < 1.0*6
        // (int)0.0*6 <= (int)(Math.random()*6) < (int)6.0
        // 0 <= (int)(Math.random()*6) < 6
        // 1 <= (int)(Math.random()*6)+1 < 7
//        int dice = (int)(Math.random()*6)+1;
//        int lotto = (int)(Math.random()*45)+1;

//        System.out.println(dice);
//        System.out.println(lotto);

        // start부터 시작하는 n개의 정수 중에서 1개의 정수를 얻기 위한 코드 작성
//        int start = 1, n = 10;
//        int num = (int)(Math.random()*n)+start;     // java의 난수 생성 공식

        int diceNum = 0;

        for (int i = 1; i <= 3; i++) {
            diceNum = (int)(Math.random()*6)+1;
            System.out.println(i + "번째 나온 주사위 수 " +diceNum);
        }
    }
}
