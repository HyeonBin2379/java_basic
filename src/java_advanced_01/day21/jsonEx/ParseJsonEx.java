package java_advanced_01.day21.jsonEx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// JSON에서 속성의 순서는 중요하지 않음 -> 저장 순서에 관계없이 파싱하여 사용 가능
// 줄바꿈 처리를 수행하지 않음 -> 네트워크의 전송량을 줄여주어 오히려 장점이 됨
// .json 파일을 파싱하는 방법을 실습
public class ParseJsonEx {

    public static void main(String[] args) {
        // 1. .json 파일을 읽어와서 JSON 객체를 생성
        // .json 파일은 문자 데이터이므로 FileReader를 사용하여 데이터를 읽어옴
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("lhb.json", StandardCharsets.UTF_8))) {
            // JSON 객체 생성
            String json = bufferedReader.readLine();
            JSONObject root = new JSONObject(json);

            // 속성정보 읽기
            System.out.println("이름: " + root.getString("name"));

            // 복합속성 파싱
            JSONObject tel = root.getJSONObject("tel");
            System.out.println("home-tel: " + tel.getString("home"));
            System.out.println("mobile: " + tel.getString("mobile"));

            // 배열로 파싱
            JSONArray skill = root.getJSONArray("skill");
            String skills = IntStream.range(0, skill.length())
                    .mapToObj(idx -> skill.get(idx).toString())
                    .collect(Collectors.joining(", "));
            System.out.printf("skill: [%s]\n", skills);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
