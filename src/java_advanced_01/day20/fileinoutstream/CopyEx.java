package java_advanced_01.day20.fileinoutstream;

import java.io.*;

// 파일 복사 기능: FileInputStream으로 읽은 바이트를 곧바로 FileOutputStream으로 출력하는 기능
public class CopyEx {

    public static void main(String[] args) throws IOException {
        String orignialFileName = "C:/Temp/test.jpg";
        String newFileName = "C:/Temp/testCopy.jpg";

        // InputStream, OutputStream 객체 생성 => 파일을 대상으로 입출력 스트림을 생성
        InputStream is = new FileInputStream(orignialFileName);
        OutputStream os = new FileOutputStream(newFileName);

        // 이미지 객체의 데이터를 바이트 형태로 읽기(버퍼의 크기를 가용치만큼 설정)
//        byte[] buffer = new byte[is.available()];   // 읽은 바이트 수만큼을 저장
//        while (true) {
//            // 버퍼 단위로 파일 복사 작업을 수행
//            int numRead = is.read(buffer);
//            if (numRead == -1) {
//                break;
//            }
//            os.write(buffer, 0, numRead);
//        }

        // Java 9부터는 입력스트림에서 출력스트림으로 바이트를 복사하는 메서드 transferTo()를 제공
        is.transferTo(os);

        // 내부 버퍼에 남아 있는 바이트 데이터 비우기
        os.flush();

        // 모든 스트림 닫기
        os.close();
        is.close();
        System.out.println(newFileName + " 복사 완료!");
    }
}
