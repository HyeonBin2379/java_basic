package java_advanced_01.day14.generic;

public class Box {
    // Box에 저장할 내용물을 content 필드로 선언
    // 다양한 내용물을 저장 가능한 Box를 구현하는 것이 목적
    // Object 타입: 모든 객체는 부모 타입인 Object로 자동 타입 변환 -> content는 어떤 객체든 대입 가능
    public Object content;

    public static void main(String[] args) {
        Box box = new Box();
        box.content = "바비인형";
        box.content = 100;
        box.content = 1000.012;

        // Object 타입으로 필드 선언 시 문제: Box 안 내용물을 얻을 때 발생
        // content는 Object 타입이므로 어떤 객체가 대입되어 있는지 확실하게 알 수가 없음
        // 다양한 타입의 내용물을 저장 가능하면서도, 대입된 내용물을 사용할 때는 내용물의 타입을 알고 싶음

        // 1. 다운캐스팅 활용
        String doll = (String) box.content;

        // 2. instanceof 연산자 활용 -> 그러나 타입을 모두 조사할 수 없음

        // 따라서, 필드를 Object 타입으로 선언하는 것은 좋지 않음

    }
}
