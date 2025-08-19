package java_advanced_01.day17.test;

import java.util.Arrays;
import java.util.Collections;

public class ComparableMain {

    static class User implements Comparable<User> {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            return Integer.compare(this.age, o.age);
        }
    }

    static User[] users = new User[] {
            new User("홍길동", 32),
            new User("박희동", 14),
            new User("김동성", 48),
            new User("김유신", 64)
    };

    public static void main(String[] args) {
        System.out.println("-----------나이 순 오름차순----------");
        Arrays.sort(users);
        for (User user : users) {
            System.out.println(user.name + " " + user.age + "세");
        }
        System.out.println("-----------나이 순 내림차순----------");
        Arrays.sort(users, Collections.reverseOrder());
        for (User user : users) {
            System.out.println(user.name + " " + user.age + "세");
        }
    }
}
