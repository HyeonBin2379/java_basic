package javabasic_02.day09.oop;

public class Student {

    // Student 클래스의 멤버 필드
    private String stu_name;
    private Integer stu_age;
    private String address;
    private String stu_ssn;
    private String gender;

    private Integer[] scores;

    // 생성자를 통해 학생 객체의 필드를 초기화
    // 기본 생성자: 별도의 생성자를 기술하지 않으면 컴파일러가 자동 생성
    Student() {
    }

    // 생성자 오버로딩을 통해 멤버 필드 초기화 가능
    Student(String stu_name, String stu_ssn) {
        this.stu_name = stu_name;
        this.stu_ssn = stu_ssn;
    }

    Student(String stu_name, Integer stu_age, String address, String stu_ssn) {
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.address = address;
        this.stu_ssn = stu_ssn;
    }

    // this: 현재 인스턴스의 주소값을 가리키는 키워드
    public String getStu_name() {
        return stu_name;    // return this.stu_name을 축약
    }

    public Integer getStu_age() {
        return stu_age;
    }

    public String getAddress() {
        return address;
    }

    public String getStu_ssn() {
        return stu_ssn;
    }

    public String getGender() {
        return gender;
    }

    // 인자값을 사용하여 성별, 과목별 점수의 값을 초기화
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setScores(Integer[] scores) {
        this.scores = scores;
    }

    public void printStudentInfo() {
        System.out.printf("%s의 정보 출력", stu_name);
        System.out.println("stu_ssn = " + stu_ssn);
        System.out.println("stu_name = " + stu_name);
        System.out.println("stu_age = " + stu_age);
        System.out.println("address = " + address);
    }

    public void printScores() {
        int kor = scores[0];
        int eng = scores[1];
        int math = scores[2];

        System.out.printf("%s의 국어, 영어, 수학 점수 출력\n", stu_name);
        System.out.println("kor = " + kor);
        System.out.println("eng = " + eng);
        System.out.println("math = " + math);
    }

    public void printTotalScoreAndAverage() {
        int totalScore = 0;
        for (Integer score : scores) {
            totalScore += score;
        }
        double average = (double) totalScore / scores.length;

        System.out.printf("%s의 총점과 평균 출력\n", stu_name);
        System.out.printf("totalScore = %d\n", totalScore);
        System.out.printf("average = %.1f\n", average);
    }

    // Object 클래스의 toString() 메서드를 Student 클래스에 맞게 오버라이딩(재정의)
    @Override
    public String toString() {
        return "Student{" +
                "stu_name='" + stu_name + '\'' +
                ", stu_age=" + stu_age +
                ", address='" + address + '\'' +
                ", stu_ssn='" + stu_ssn + '\'' +
                '}';
    }
}
