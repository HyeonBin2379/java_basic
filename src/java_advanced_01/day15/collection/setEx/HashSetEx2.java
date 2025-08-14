package java_advanced_01.day15.collection.setEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx2 {

    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        // 객체 저장
        set.add(new Member("신세계", 30));
        set.add(new Member("신세계", 30));
        set.add(new Member("신세종", 30));

        int size = set.size();
        System.out.println(size);

        // Iterator 적용하여 객체를 처리
        Iterator<Member> iter = set.iterator();
        while (iter.hasNext()) {
            Member member = iter.next();
            System.out.println(member.name + " " + member.age);
        }
        System.out.println();

        for (Member member : set) {
            System.out.println(member.name + " " + member.age);
        }
    }
}
