package javabasic_02.day11.homework.inheritance.quiz1.q2;

public class StudentMain {

	public static void main(String args[]){
		Student stu = new Student("장동건", "jspprogram", 500000);
		stu.calcReturnFee();
		stu.print();
	}
}  