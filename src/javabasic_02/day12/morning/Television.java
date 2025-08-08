package javabasic_02.day12.morning;

public class Television implements RemoteControl {

    // 필드 추가 - volume
    // 필드 volume은 볼륨 버튼으로 음량 조정 가능
    private int volume;
    private int memoryVolume;   // mute 전 원래 볼륨 저장

    @Override
    public void setMute(boolean mute) {
        if (mute) {
            this.memoryVolume = this.volume;
            System.out.println("무음 처리 작동시작");
            setvolume(MIN_VOLUME);
        } else {
            System.out.println("무음 해제");
            setvolume(this.memoryVolume);
        }
    }

    @Override
    public void turnOn() {
        System.out.println("TV 전원을 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원을 끈다.");
    }

    @Override
    public void setvolume(int volume) {
        if (volume >= RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else {
            this.volume = Math.max(volume, RemoteControl.MIN_VOLUME);
        }
    }
}
