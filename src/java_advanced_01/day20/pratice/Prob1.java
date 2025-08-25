package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 1: 텍스트 파일에 문자열 저장
//         문자열 "Hello Java!"를 hello.txt에 저장하세요.
public class Prob1 {

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("C:/Temp/hello.txt");
        String str = "Hello Java!";
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
