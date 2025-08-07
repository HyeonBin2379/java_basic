package javabasic_02.day11.sec07.exam02;

public class ChildExample {
	public static void main(String[] args) {
		//자식 객체 생성
		Child child = new Child();
//		child.method1();

		//자동 타입 변환
		Parent parent = child;

		//메소드 호출
		parent.method1();
		System.out.println(parent.name);
//		System.out.println(parent.childName);
//		parent.method2();

		// 자식 타입 객체를 부모 타입으로 형변환할 시 부모 타입에 정의된 멤버 요소만 사용 가능
//		parent.method3();

		// 부모 객체를 자식 타입 참조변수로 참조할 시, 강제타입 변환 필수
		//
		Child child1 = (Child) parent;
//		child1.method3();
		System.out.println(child1.childName);
	}
}