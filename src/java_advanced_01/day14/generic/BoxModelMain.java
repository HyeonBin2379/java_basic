package java_advanced_01.day14.generic;

import java.util.ArrayList;

public class BoxModelMain {

    public static void main(String[] args) {
        // 철호가 "배추", "무", "상추", "삼겹살"을 구매 -> 물품을 box에 담고 box에 담긴 내용을 출력
        // 객체 생성 시점에 내용물의 타입이 String으로 결정됨
        BoxModel<String> box = new BoxModel<>();
        box.content = new ArrayList<>();
        box.content.add("배추");
        box.content.add("무");
        box.content.add("상추");
        box.content.add("삼겹살");

        for (String food : box.content) {
            System.out.println(food);
        }
    }
}
