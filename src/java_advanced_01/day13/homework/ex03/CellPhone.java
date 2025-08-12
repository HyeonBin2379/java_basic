package java_advanced_01.day13.homework.ex03;

public class CellPhone {

    String model;
    double battery;

    CellPhone(String model) {
        this.model = model;
    }

    void call(int time) {
        try {
            if (time < 0) {
                throw new IllegalArgumentException("통화시간입력오류");
            }
            System.out.printf("통화 시간 : %d분\n", time);
            this.battery = Math.max(this.battery - 0.5 * time, 0.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    void charge(int time) {
        try {
            if (time < 0) {
                throw new IllegalArgumentException("충전시간입력오류");
            }
            System.out.printf("충전 시간 : %d분\n", time);
            this.battery = Math.min(this.battery + 3 * time, 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    void printBattery() {
        System.out.printf("남은 배터리 양: %.1f\n", battery);
    }
}
