package javabasic_02.day12;

public class User1 {

    public static void main(String[] args) {
        // loose-coupling : 인터페이스 타입 참조변수가 참조할 객체를 바꿔서 사용 가능
        Service service = new ServiceImpl2();

        // 디폴트 메서드 호출
        service.defaultMethod1();
        service.defaultMethod2();

        // 정적 메서드 호출
        Service.staticMethod1();
        Service.staticMethod2();
    }
}
