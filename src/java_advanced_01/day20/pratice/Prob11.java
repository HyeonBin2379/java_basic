package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 11: 간단한 메모장 (덮어쓰기 모드 vs 이어쓰기 모드)
//       사용자가 입력한 내용을 memo.txt에 저장하는 프로그램을 작성하세요.
//       "append" 모드를 선택하면 기존 내용 뒤에 이어쓰기,
//       "overwrite" 모드를 선택하면 새로 쓰기 기능을 수행합니다.
public class Prob11 {

    public static void main(String[] args) throws IOException {
        BufferedReader cmdBr = new BufferedReader(new InputStreamReader(System.in));
        String cmd = cmdBr.readLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;

        String input;
        switch (cmd) {
            case "append":
                bw = new BufferedWriter(new FileWriter("C:/Temp/memo.txt", true));
                input = br.readLine();
                bw.write(input);
                bw.flush();
                bw.close();
                break;
            case "overwrite":
                bw = new BufferedWriter(new FileWriter("C:/Temp/memo.txt", false));
                input = br.readLine();
                bw.write(input);
                bw.flush();
                bw.close();
                break;
        }
        cmdBr.close();
        br.close();
    }
}
