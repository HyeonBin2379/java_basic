package java_advanced_01.day17.lambdaEx.lambda03;

public class Button {
    // 정적 멤버 인터페이스 정의
    public static interface ClickListener {
        void onClick();
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }

    // 람다를 활용한 이벤트 처리
    public static void main(String[] args) {
        // OK 버튼 생성
        Button buttonOK = new Button();
        // OK 버튼 객체에 람다식 주입
        buttonOK.setClickListener(() -> {
            System.out.println("OK 버튼 클릭!");
        });
        // OK 버튼 클릭 행위
        buttonOK.click();

        Button buttonCancel = new Button();
        buttonCancel.setClickListener(() -> {
            System.out.println("취소 버튼 클릭!");
        });
        buttonCancel.click();

        for (int i = 0; i < 5; i++) {
            buttonCancel.click();
        }
    }
}
