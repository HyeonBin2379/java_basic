package java_advanced_01.day21.jsonEx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class CreateJsonEx {

    public static void main(String[] args) {
        // 1. JSON 객체 생성
        JSONObject root = new JSONObject();

        // 2. JSON 객체에 속성 추가
        root.put("id", "lhb");
        root.put("name", "이현빈");
        root.put("password", "1234");

        // 3. 복합 속성 추가
        JSONObject tel = new JSONObject();
        tel.put("home", "010-1111-1414");
        tel.put("mobile", "010-1112-1818");
        root.put("tel", tel);

        JSONArray skill = new JSONArray();
        skill.put("Java");
        skill.put("HTML");
        skill.put("JPA");
        root.put("skill", skill);

        // 4. JSON 얻기
        String json = root.toString();

        // 5. 얻은 JSON 객체를 콘솔에 출력
        System.out.println(json);

        // 6. JSON 객체를 파일에 출력
        try (Writer writer = new FileWriter("lhb.json", StandardCharsets.UTF_8)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
