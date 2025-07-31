package jungol.입력;

public class 입력_자가진단5 {

    public static void main(String[] args) {
        double yardToCentimeter = 91.44;
        double inchToCentimeter = 2.54;

        double yard = 2.1;
        double inch = 10.5;

        System.out.printf("%4.1fyd =%6.1fcm\n", yard, yard*yardToCentimeter);
        System.out.printf("%4.1fin =%6.1fcm\n", inch, inch*inchToCentimeter);
    }
}
