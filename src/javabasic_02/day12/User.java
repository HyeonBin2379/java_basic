package javabasic_02.day12;

public class User {

    public static void main(String[] args) {
        // 인터페이스를 통해 객체의 기능을 수행
        RemoteControl rc = new Television();
        rc.turnOn();
        rc.turnOff();
        rc.setvolume(10);
        rc.setvolume(11);
        rc.setMute(true);
        rc.setMute(false);
        RemoteControl.changeBattery();  // 정적 메서드 수행

        // 리모컨을 통해 청소기를 동작시키기
        // 1. 전원 키고
        // 2. 청소를 시킨다.
        // 3. 10분 후 청소기를 끈다.
//        rc = new Cleaner(10);
//        rc.turnOn();
//        rc.turnOff();
    }
}
