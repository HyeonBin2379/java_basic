package java_advanced_01.day16.comparableEx;

public class Person implements Comparable<Person> {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        // 객체 o는 비교할 대상
        if (this.age < o.age) { // 비교 대상보다 나이가 많음
            return -1;
        } else if (this.age > o.age) {  // 비교 대상보다 나이가 적음
            return 1;
        } else {
            return 0;   // 비교 대상과 나이가 동일
        }
//        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
