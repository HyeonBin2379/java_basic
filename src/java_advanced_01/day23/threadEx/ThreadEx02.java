package java_advanced_01.day23.threadEx;

class Calculator {

    // User1과 User2가 서로 공유하는 영역
    private int memory;

    public int getMemory() {
        return memory;
    }

    // 동기화 메서드
    public synchronized void setMemory1(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000); // 2초간 일시정지
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Interrupted " + this.memory);
        }
    }

    // 동기화 블록을 포함하는 메서드
    public void setMemory2(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " Interrupted " + this.memory);
            }
        }
    }
}

class User1 extends Thread {
    private Calculator calculator;

    public User1() {
        setName("User1Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory2(100);
        System.out.println(getName() + ": " + calculator.getMemory());
    }
}

class User2 extends Thread {
    private Calculator calculator;

    public User2() {
        setName("User2Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory2(200);
        System.out.println(getName() + ": " + calculator.getMemory());
    }
}

// Calculator를 생성해서 User1과 User2에서 사용하도록 setCalculator()를 호출
// -> 두 스레드를 실행하면 알아서 동작
public class ThreadEx02 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }
}
