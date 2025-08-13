package java_advanced_01.day14;

public class ExceptionEx01 {

    public static void main(String[] args) {
        try {
            String[] array = {"100", "l00"};
            for (int i = 0; i < array.length; i++) {
                String string = array[i];
                Integer number = Integer.parseInt(string);
                System.out.println(number);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e1) {
            System.out.println(e1.getMessage());
        }
        System.out.println("프로그램 종료");
    }
}
