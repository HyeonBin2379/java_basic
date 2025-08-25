package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 8: 한 줄 입력 후 출력사용자로부터 문자열을 한 줄 입력받아 그대로 출력하는 프로그램을 작성하세요.
public class Prob8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열 입력: ");
        String input = br.readLine();
        System.out.println("입력한 문자열: " + input);
        br.close();
    }
}
