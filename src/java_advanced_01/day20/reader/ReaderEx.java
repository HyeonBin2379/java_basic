package java_advanced_01.day20.reader;

import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class ReaderEx {

    public static void main(String[] args) throws Exception {
        Reader reader = null;

        // 1. 문자 1개씩 읽기
        reader = new FileReader("C:/Temp/testChar.txt");
        while (true) {
            // 읽어온 문자 1개를 반환(문자 타입은 정수형으로 변환되어 반환)
            int data = reader.read();

            // 더 이상 출력할 문자가 없으면 종료
            if (data == -1) {
                break;
            }

            System.out.print((char)data + " ");
        }
        reader.close();
        System.out.println();

        // 2. 문자 배열 단위로 읽기
        reader = new FileReader("C:/Temp/testChar.txt");
        char[] datas = new char[100];
        while (true) {
            // 읽어온 문자의 개수를 반환
            int numRead = reader.read(datas);

            if (numRead == -1) {
                break;
            }
            // 버퍼의 크기 > 읽은 문자 개수일 경우, 버퍼의 남은 부분에 쓰레기값이 출력될 수 있음
            // 따라서, 문자 배열 단위로 읽어온 값을 활용할 때는 read()의 반환값 역시 활용해야 함.
            for (int i = 0; i < numRead; i++) {
                System.out.print(datas[i]);
            }
        }
        reader.close();
        System.out.println();

        // 3. 문자열 단위로 읽기
    }
}
