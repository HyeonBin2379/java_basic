package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 7: 파일 크기 출력
//        copy.jpg 파일의 크기를 바이트 단위로 출력하세요.
public class Prob7 {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("C:/Temp/copy.jpg");
        int totalSize = 0;
        byte[] buf = new byte[is.available()];

        while (true) {
            int byteCnt = is.read(buf);
            if (byteCnt == -1) {
                break;
            }
            totalSize += byteCnt;
        }
        System.out.println(totalSize);
    }
}
