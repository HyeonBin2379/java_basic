package javabasic_02.day11.sec07.exam01;

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class PromotionExample {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

		// 상속관계이므로, b 객체변수에 저장된 주소값은 부모인 A타입 참조변수 a1에 저장 가능
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;

		// 상속관계이므로, 참조변수 d에 저장된 주소값은 부모인 B타입 참조변수 b1에 저장 가능
		B b1 = d;
		// B와 C는 상속관계가 아니므로, B 타입 참조변수에는 참조변수 c의 주소값을 저장 불가
//		B b2 = c;
		C c1 = e;

		// 부모 타입 참조변수에 자식 타입 객체를 저장할 때만 자동 타입 변환 가능
//		C c2 = d;
	}
}