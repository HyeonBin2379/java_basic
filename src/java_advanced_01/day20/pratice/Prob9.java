package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 9: 여러 줄 입력받아 파일에 저장
//        사용자가 입력하는 여러 줄을 받아 output.txt 파일에 저장하세요. 단, "exit"를 입력하면 종료합니다.
public class Prob9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Temp/output.txt"));
        while (true) {
            String input = br.readLine();
            if (input.equals("exit")) {
                break;
            }
            bw.write(input + System.lineSeparator());
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
