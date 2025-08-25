package java_advanced_01.day20.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriterEx03 {

    public static void main(String[] args) {
        try {
            // 1. 출력 스트림을 생성 - C:Temp/test3.db를 데이터 도착지로 지정하고, byte 배열의 데이터를 저장
            OutputStream os = new FileOutputStream("C:/Temp/test3.db");

            // 2. 내보낼 데이터를 지정
            byte[] array = {10, 20, 30, 40, 50};

            // 3. 데이터를 출력스트림으로 전송하여 해당 목적지에 출력 -> 배열의 특정 인덱스 범위를 출력
            os.write(array, 1, 3);

            // 4. 출력스트림의 내부 버퍼에 남아 있는 바이트 데이터를 모두 출력하고, 버퍼를 비움
            os.flush();

            // 5. 출력스트림을 종료
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
