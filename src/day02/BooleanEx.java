package day02;

public class BooleanEx {

    public static void main(String[] args) {
        boolean stop = false;
        if (stop) {
            System.out.println("중지합니다.");
        } else {
            System.out.println("시작합니다.");
        }

        // int x = 30
        int x = 30;

        // 변수 x의 값이 20인가?
        boolean result1 = x == 20;

        // 변수 x의 값이 20이 아닌가?
        boolean result2 = x != 20;

        // 변수 x의 값이 0보다 크고 30보다 작은가?
        boolean result3 = 0 < x && x < 30;

        // 변수 x의 값이 0보다 적거나 30보다 크거나 같은가?
        boolean result4 = x < 0 || x >= 30;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
