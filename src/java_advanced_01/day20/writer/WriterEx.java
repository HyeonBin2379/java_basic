package java_advanced_01.day20.writer;

import java.io.FileWriter;
import java.io.Writer;

// Writer 클래스는 OutputStream과 사용법이 동일(출력단위가 문자 타입이란 차이점만 존재)
// 문자열을 출력하는 writer(String str) 메서드를 추가 제공
// 1개의 문자, 문자 배열, 문자열 단위의 출력을 수행
public class WriterEx {

    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("C:/Temp/testChar.txt");

        // 문자 1개씩 파일에 출력
        char ch1 = 'A';
        writer.write(ch1);
        char ch2 = 'B';
        writer.write(ch2);

        // 문자 배열 단위로 파일에 출력
        char[] chars = {'C', 'D', 'E', 'F'};
        writer.write(chars);

        // 문자열 단위로 파일에 출력
        String str = "Hello IOStream!!";
        writer.write(str);

        writer.flush();
        writer.close();
    }
}
