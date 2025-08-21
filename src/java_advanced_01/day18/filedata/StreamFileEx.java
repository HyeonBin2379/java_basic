package java_advanced_01.day18.filedata;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFileEx {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // data.txt 파일 경로 얻기
        Path path= Paths.get(StreamFileEx.class.getResource("data.txt").toURI());

        // path로 연 파일을 한 행씩 읽으면서 문자열 스트림 생성
        // 기본 UTF-8 문자셋으로 읽기 수행
        Stream<String> stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(System.out::println);

        // 스트림을 이용하여 파일에 접근할 시, 작업이 완료되면 반드시 스트림 닫기 필요
        // (Stream은 AutoClosable 미구현)
        stream.close();
    }
}
