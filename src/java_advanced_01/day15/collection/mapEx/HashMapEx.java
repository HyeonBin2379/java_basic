package java_advanced_01.day15.collection.mapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

    public static void main(String[] args) {
        // HashMap 객체에게 힙 영역을 할당
        Map<String, Integer> map = new HashMap<>();

        // Entry 객체를 Map에 저장 - insert/create/saved
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);

        // Map의 크기 = 키의 개수
        System.out.println(map.size());

        // 객체 읽기 - read/get -> key를 이용하여 읽기
        String key = "A";
        int value = map.get(key);
        System.out.println("키를 이용하여 값 확인 " + value);
        System.out.println();

        // 키 Set 컬렉션을 얻어서, 반복해서 키와 값을 읽기
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            Integer v = map.get(k);

            System.out.println(k + " " + v);
        }
        System.out.println();

        for (String k : keySet) {
            Integer v = map.get(k);
            System.out.println(k + " " + v);
        }

        // entrySet 컬렉션을 사용하여 반복해서 키와 값을 얻는 방법
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIter = entrySet.iterator();
        while (entryIter.hasNext()) {
            Map.Entry<String, Integer> entry = entryIter.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        for (Map.Entry<String, Integer> entry : entrySet) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }


        // 키로 엔트리를 삭제
        map.remove("B");
        System.out.println("삭제 후 Map의 크기: " + map.size());
        System.out.println();
    }
}
