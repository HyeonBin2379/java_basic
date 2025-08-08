package javabasic_02.day12;

public interface RemoteControl {

    // 볼륨의 최대치: 30, 최소치: 0
    int MAX_VOLUME = 30;
    int MIN_VOLUME = 0;

    // 전원 켜기, 끄기
    void turnOn();
    void turnOff();

    void setvolume(int volume);
    void setMute(boolean mute);

    // 디폴트 인스턴스 메서드 정의
//    default void setMute(boolean mute) {
//        if (mute) {
//            System.out.println("무음 처리 작동시작");
//            setvolume(MIN_VOLUME);
//        } else {
//            System.out.println("무음 해제");
//        }
//    }

    static void changeBattery() {
        System.out.println("리모컨 건전지를 교환해야 합니다.");
    }

    private void cooldown() {

    }
}
