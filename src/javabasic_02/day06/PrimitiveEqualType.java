package javabasic_02.day06;

// ==, != 연산자: 변수의 값이 같은지, 아닌지를 확인하기 위한 연산
// 참조타입에서 == 와 !=를 사용할 시, 참조변수의 주소값을 비교
public class PrimitiveEqualType {

    public static void main(String[] args) {
        // 정수형 배열 arr1, arr2, arr3 선언
        int[] arr1;
        int[] arr2;
        int[] arr3;

        // 정수형 배열 arr1, arr2, arr3의 메모리 생성
        arr1 = new int[3];
        arr2 = new int[3];
        arr3 = new int[3];

        System.out.println("==============");
        System.out.println(arr1.length);
        System.out.println(arr2.length);
        System.out.println(arr3.length);

        System.out.println("==============");
        arr1[0] = 1;    // 배열 arr1의 첫번째 인덱스에 1을 저장
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        // 배열 arr3에 차례로 1, 2, 3을 할당하고 결과를 확인
        arr3[0] = 1;
        arr3[1] = 2;
        arr3[2] = 3;

        System.out.println("==============");
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
        System.out.println(arr3[2]);
        System.out.println("==============");

        // for문을 사용하여 위의 작업을 한번에 처리 가능
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }

        // arr3에 값을 차례로 itar, iter 방식을 통해 5,6,7 값을 할당하고, 할당한 값을 iter, itar 방식으로 확인
        int value = 5;
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = value;
            value++;
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }

        // 주소값 비교
        System.out.println("===================");
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);

        // 각 배열의 참조변수에 저장된 주소값은 서로 다르므로, 모두 false를 출력
        System.out.println("===================");
        System.out.println(arr1 == arr2);
        System.out.println(arr2 == arr3);
        System.out.println(arr3 == arr1);

        System.out.println("======= 주소값 복사하여 다른 참조변수에 할당=========");
        arr2 = arr3;
        System.out.println("========주소값 비교===============");
        // 참조변수 arr3에 저장된 배열의 주소값이 arr2에도 저장되어 arr2와 arr3은 동일한 배열을 참조
        System.out.println(arr2 == arr3);

        System.out.println("============");
        for (int i : arr2) {
            System.out.println(i);
        }
        System.out.println("============");
        for (int i = 0; i < arr2.length; i++) {
            int i1 = arr2[i];
            System.out.println(i1);
        }
    }
}
