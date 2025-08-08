package javabasic_02.day12.afternoon.sec01;

public class User1 {

    public static void main(String[] args) {
        // SmartTelevision의 RemoteControl 기능만 사용
        RemoteControl rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        // SmartTelevision의 Seachable 관련 기능만 사용
        Searchable searchable = new SmartTelevision();
        searchable.search("https://www.youtube.com");
    }
}
