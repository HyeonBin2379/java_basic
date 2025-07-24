package day02;

public class PrimitiveAndStringConversionEx {

    public static void main(String[] args) {
        String v1 = "10";

        // 문자열 10을 정수형 10으로 변환
        int d1 = Integer.parseInt(v1);
        System.out.println(d1+10);      // 결과값: 20

        v1 = "3.14";
        double d2 = Double.parseDouble(v1);
        System.out.println(d2 + 0.01);  // 결과값: 3.15


        v1 = "true";
        boolean bool1 = Boolean.parseBoolean(v1);

        if (!bool1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 정수형을 문자열로 변경
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        System.out.println(str1 + " " + str2);
    }
}
