package java_advanced_01.day20.pratice;

import java.io.*;

// 문제 6: 이미지 복사 (바이트 스트림 활용)
//        image.jpg 파일을 읽어서 copy.jpg 파일로 복사하세요.  image.jpg는 여러분이 지정합니다.
public class Prob6 {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("C:/Temp/image.jpg");
        OutputStream os = new FileOutputStream("C:/Temp/copy.jpg");
        is.transferTo(os);
        is.close();
    }
}
