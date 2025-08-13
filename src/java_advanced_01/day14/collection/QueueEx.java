package java_advanced_01.day14.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) {
        Queue<Integer> queue_int = new LinkedList<>();
        Queue<String> queue_str = new LinkedList<>();

        // 데이터(객체) 추가
        queue_int.add(1);
        queue_int.add(2);
        queue_int.add(3);
        queue_int.add(4);

        System.out.println(queue_int.remove(2));
        System.out.println(queue_int);
        queue_int.poll();
        System.out.println(queue_int);

        queue_str.add("");
    }
}
