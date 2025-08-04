package javabasic_02.day08.string;

public class RefEx01 {

    public static void main(String[] args) {
        String refVar1 = null;
        String refVar2 = null;

        // refVar1, refVar2
        refVar1 = new String("자바");     // 힙 메모리를 할당받음
        refVar2 = "자바";                         // 리터럴 풀에 저장한 값을 할당
        String refVar3 = "자바";
        String refVar4 = null;

        System.out.println(refVar1 == refVar2);  // 저장된 주소값이 다름

        // JVM은 "자바" 리터럴을 리터럴 풀에 저장하고, 서로 다른 참조변수에 할당
        // refVar2 == refVar3가 참이라는 것은 리터럴 풀에 저장된 동일한 대상을 참조한다는 의미이지, 실제 값이 같다는 의미가 아님
        System.out.println(refVar1 == refVar3);
        System.out.println(refVar2 == refVar3);

        // 실제 값이 동일한지를 확인하려면 equals() 메서드를 사용해야 함.
        System.out.println("--------------------");
        System.out.println(refVar1.equals(refVar2));
        System.out.println(refVar2.equals(refVar3));

        // NullPointerException
        // : 참조변수에 할당한 객체가 없는 상태에서 객체의 변수에 접근하거나, 메서드를 호출하려 했기 때문에 발생한 예외
        System.out.println("-------NullPointerException");
        System.out.println(refVar4);
        System.out.println(refVar4.length());
    }
}
