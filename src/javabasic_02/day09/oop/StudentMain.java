package javabasic_02.day09.oop;

import java.util.Scanner;

// 학생 인스턴스 생성을 위한 실행 클래스
public class StudentMain {

    // main 메서드 호출 시, 스택영역의 메모리를 main 메서드와 그 내부의 지역변수에 할당
    // 실제 프로그램 개발 시, 메모리의 스택 영역에서 객체의 기능을 수행, 객체 멤버의 데이터는 DB에 저장하고 DTO 객체를 통해 사용
    public static void main(String[] args) {
        // Student 객체를 기본생성자로 생성할 시, 힙 영역의 메모리를 Student의 멤버에 할당
        // 생성된 객체의 주소는 참조변수 student1에 저장
        Student student1 = new Student();

        // Student 객체를 인자가 있는 생성자로 생성할 시, 기본 생성자로 만들어진 표준 객체를 힙 영역 내부에서 복제,
        // 할당된 객체의 멤버 필드는 생성자의 인자값으로 초기화
        Student student2 = new Student("student2", "12345");
        Student student3 = new Student("student3", 27, "경기도 의정부시", "1234567");
        Student student4 = new Student("student4", 25, "서울시 강남구", "12345678");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        // getter 메서드: private인 멤버 필드 자체를 변경하지 않고도 해당 값에 접근 가능
        System.out.println(student4.getStu_name());
        System.out.println(student4.getAddress());

        // getter는 접근제한자가 private인 멤버 변수의 값을 변수 등에 저장하여 재가공할 때 활용 가능
        String address = student4.getAddress();
        System.out.println(address + "에 살고 있습니다.");

        // 접근제한자가 default이면 동일 패키지 내 다른 클래스에서도 해당 멤버 필드에 접근 가능
        student4.setGender("남자");
        student1.setGender("남자");
        System.out.println(student4.getGender());
        System.out.println(student1.getGender());

        // 학생의 정보(학번, 이름, 나이, 주소)를 출력
        student3.printStudentInfo();
        System.out.println();

        // 학생의 국어, 영어, 수학 점수 확인 가능
        student3.setScores(new Integer[]{80, 90, 75});
        student3.printScores();
        System.out.println();

        // 학생의 총점과 평균 확인 가능
        student3.printTotalScoreAndAverage();
        System.out.println();
    }
}
