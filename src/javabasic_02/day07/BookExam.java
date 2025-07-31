package javabasic_02.day07;

// 실행클래스
public class BookExam {

    public static void main(String[] args) {
        // 1. 책 정보를 저장할 수 있는 Book 타입의 인스턴스 객체 생성
        Book book1 = new Book();

        // 2. 책 한 권의 각 속성(멤버 변수)별 데이터 저장
        book1.price = 10000;
        book1.title = "자바의 정석";
        book1.company = "KK";
        book1.isbn = "123456";
        book1.author = "남궁성";
        book1.page = 500;

        // 3. book1의 각 속성 출력
        System.out.printf("%s의 가격은 %d원이고, 저자는 %s입니다.\n", book1.title, book1.price, book1.author);
    }
}
