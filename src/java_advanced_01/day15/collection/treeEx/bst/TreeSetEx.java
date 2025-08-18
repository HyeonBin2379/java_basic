package java_advanced_01.day15.collection.treeEx.bst;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {

    public static void main(String[] args) {
        TreeSet<Integer> score = new TreeSet<>();

        // 점수 추가 -> add()
        score.add(87);
        score.add(98);
        score.add(76);
        score.add(54);
        score.add(80);

        for (Integer nodeData : score) {
            System.out.println(nodeData);
        }
        System.out.println();

        // 특정 점수 객체 가져오기 -> first(), last(), lower(), higher(), floor(), ceiling()
        System.out.println("가장 낮은 점수: " + score.first());
        System.out.println("가장 높은 점수: " + score.last());
        System.out.println("95점보다 낮은 점수 중 최대 점수: " + score.lower(95));
        System.out.println("95점보다 높은 점수 중 최소 점수: " + score.higher(95));
        System.out.println("95점이거나 바로 아래 점수: " + score.floor(95));
        System.out.println("85점이거나 바로 위의 점수: " + score.ceiling(85));

        // 기본은 오름차순 정렬
        // 내림차순 정렬 -> descendingSet() 사용
        NavigableSet<Integer> descendingScores = score.descendingSet();
        for (Integer nodeData : descendingScores) {
            System.out.println(nodeData);
        }

        // 범위 검색(80 <= 점수) -> tailSet()
        NavigableSet<Integer> rangeSet = score.tailSet(80, true);
        for (Integer i : rangeSet) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 범위 검색(80 <= 점수 < 90)
        NavigableSet<Integer> subSet = score.subSet(80, true, 90, false);
        for (Integer i : subSet) {
            System.out.print(i + " ");
        }
    }
}
