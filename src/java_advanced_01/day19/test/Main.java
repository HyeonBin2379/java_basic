package java_advanced_01.day19.test;

import java.util.Optional;

class Person {
    private Phone phoneNumber;
    private String name;

    Person(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return this.phoneNumber;
    }
}

class Phone {
    private OS os;

    public OS getOS() {
        return this.os;
    }
}

class OS {
    public String printOS() {
        return "IOS";
    }
}
public class Main {

    public static void main(String[] args) {
        Person person = new Person("홍길동");

        // Person 객체의 참조변수 필드인 phoneNumber의 값이 null이므로
        // person.getPhone()의 반환값 또한 null이 된다.
        // 즉, Phone 객체가 없는 상태에서 getOS().printOS()를 호출하게 되어 NullPointerException 예외가 발생한다.
//        Phone phone = person.getPhone();
//        person.getPhone().getOS().printOS();

        Person p = new Person("홍미자");
        Phone ph = p.getPhone();

        // Null Object Pattern
        if (ph != null) {
            OS os = ph.getOS();
            if (os == null) {
                String osName = System.getProperty("os.name").toLowerCase();
            }
        }

        // Optional 클래스의 NPE 처리 -> 즉, Optional은 Null을 처리하기 위한 Wrapper 클래스
        Person p1 = new Person("홍길동");
        Optional.ofNullable(p1).map(Person::getPhone).map(Phone::getOS).map(OS::printOS);
    }

}
