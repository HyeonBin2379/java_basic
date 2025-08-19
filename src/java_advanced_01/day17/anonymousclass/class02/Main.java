package java_advanced_01.day17.anonymousclass.class02;

class Animal {
    public String eat() {
        return "맛있게 먹습니다.";
    }
}

public class Main {

    public static void main(String[] args) {
        // 익명 클래스: 클래스의 정의와 객체화를 동시에 수행, 이렇게 생성된 객체는 일회성
        // 별도의 캐스팅 없이도, 일회성 객체를 사용하여 처리 가능
        // 사용 시, 마지막에 세미콜론 사용 필수
        Animal dog = new Animal() {
            @Override
            public String eat() {
                return "강아지가 냠냠 먹습니다.";
            }
        };
    }
}
