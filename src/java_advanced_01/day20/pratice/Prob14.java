package java_advanced_01.day20.pratice;

import java.io.*;
import java.util.Arrays;

//문제 : 정수 배열 {5,10,15,20} dmf array.dat에 저장한 후 다시 읽어 합계와 평균을 구하고 평균을 기준으로 정렬하여 콘솔에 출력하세요
public class Prob14 {
    public static void main(String[] args) {
//        // 정수 배열의 데이터를 파일에 저장
//        int[] array = {5, 10, 15, 20};
//        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Temp/array.dat"));
//        for (int num : array) {
//            dos.writeInt(num);
//        }
//        dos.flush();
//        dos.close();
//
//        // 파일에서 정수값을 읽어옴
//        DataInputStream dis = new DataInputStream(new FileInputStream("C:/Temp/array.dat"));
//        int total = 0;
//        for (int i = 0; i < array.length; i++) {
//            total += dis.readInt();
//        }
//        // 계산한 총합과 평균을 출력
//        System.out.println("total = " + total);
//        System.out.println("avg = " + (double)total/array.length);
//        dis.close();

        // 1. 정수 배열 {5, 10, 15, 20}(=> resource) 선언 및 초기화, 저장할 파일의 이름을 지정
        int[] arr = {5, 10, 15, 20};
        String fileName = "C:/Temp/array.dat";

        // 2. 배열을 파일에 저장하는 로직 구현
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(arr.length);
            for (int num : arr) {
                dos.writeInt(num);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3. 저장한 파일에서 배열 읽기 로직 구현
        int[] readArray;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int length = dis.readInt();

            readArray = new int[length];
            for (int i = 0; i < arr.length; i++) {
                readArray[i] = dis.readInt();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 4. 배열의 요소들을 모두 더하여 합계와 평균을 연산
        if (readArray != null) {
            int sum = Arrays.stream(readArray).sum();
            double avg = (double)sum/readArray.length;
            Arrays.sort(readArray);

            System.out.println("합계 " + sum);
            System.out.println("평균 " + avg);
            System.out.println(Arrays.toString(readArray));
        }
    }
}
