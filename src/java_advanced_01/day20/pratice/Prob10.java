package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 10: 키보드 입력을 파일로 저장 (바이트 스트림)
//       사용자가 입력한 내용을 keyboard.txt에 저장하세요. 단, exit 입력 시 종료합니다.
public class Prob10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Temp/keyboard.txt"));

        while (true) {
            String input = br.readLine();
            if (input.equals("exit")) {
                break;
            }
            bos.write(input.getBytes());
        }
        bos.flush();

        br.close();
        bos.close();
    }
}
