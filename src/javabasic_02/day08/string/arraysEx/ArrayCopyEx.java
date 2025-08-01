package javabasic_02.day08.string.arraysEx;

import java.util.Arrays;

public class ArrayCopyEx {

    public static void main(String[] args) {
        int[] oldArray = {10, 20, 30, 40, 50};
        int[] newArray = new int[oldArray.length*10];

        // 1. for문을 사용한 배열 복사
        int nextIndex = 0;
        for (int k : oldArray) {
            newArray[nextIndex++] = k;
        }
        for (int j : newArray) {
            System.out.print(j + " ");
        }
        System.out.println();

        // 2. System.arraycopy()를 사용한 배열 복사
        int[] systemArray1 = new int[oldArray.length*2];
        System.arraycopy(oldArray, 0, systemArray1, 0, oldArray.length);
        System.out.println(Arrays.toString(systemArray1));

        // 3. Arrays.copyOf()를 사용한 배열 복사 - for문을 사용할 때보다 약 2배 빠른 속도
        int[] arraysCopyOf = new int[oldArray.length*2];
        arraysCopyOf = Arrays.copyOf(oldArray, arraysCopyOf.length);
        System.out.println(Arrays.toString(arraysCopyOf));
    }
}
