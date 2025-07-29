package day05;

public class BreakEx02 {

    public static void main(String[] args) {

        Outer: for (char upper = 'A'; upper <= 'Z'; upper++) {
            for (char lower = 'a'; lower <= 'z'; lower++) {
                System.out.println(upper + " - " + lower);
                if (lower == 'k') {
                    break Outer;
                }
            }
        }
    }
}
