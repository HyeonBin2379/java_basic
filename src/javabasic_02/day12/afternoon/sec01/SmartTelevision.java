package javabasic_02.day12.afternoon.sec01;

// 1개의 구현 클래스에 여러 개의 인터페이스 사용 가능
public class SmartTelevision implements RemoteControl, Searchable {

    @Override
    public void turnOn() {
        System.out.println("TV 전원 On");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원 Off");
    }

    @Override
    public void search(String url) {
        System.out.println(url + " 검색합니다.");
    }
}
