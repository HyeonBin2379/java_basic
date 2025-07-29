package day05;

public class BreakEx01 {

    public static void main(String[] args) {
        while (true) {
            int diceNum = (int)(Math.random()*6)+1;
            System.out.println(diceNum);

            if (diceNum == 6) {
                break;
            }
        }
        System.out.println("게임 종료");
    }
}
