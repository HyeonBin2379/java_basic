package java_advanced_01.day17.test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorMain {

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static User[] users = new User[] {
            new User("김유신", 64),
            new User("김동성", 48),
            new User("홍길동", 32),
            new User("박희동", 14)
    };

    public static void main(String[] args) {
        System.out.println("-----------나이 순 오름차순----------");
        Arrays.sort(users, (o1, o2) -> Integer.compare(o1.age, o2.age));
        for (User user : users) {
            System.out.println(user.name + " " + user.age + "세");
        }

        System.out.println("-----------이름 순 오름차순----------");
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Arrays.sort(users, (u1, u2) -> u1.name.compareTo(u2.name));
        for (User user : users) {
            System.out.println(user.name + " " + user.age + "세");
        }
    }
}
