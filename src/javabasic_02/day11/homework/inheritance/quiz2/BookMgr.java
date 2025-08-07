package javabasic_02.day11.homework.inheritance.quiz2;

public class BookMgr {

	private Book[] booklist;
	
	public BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}
	
	public void printBooklist(){
        for (Book book : booklist) {
            System.out.println(book.getTitle());
        }
	}
	
	public void printTotalPrice(){
		int totalPrice = 0;
		for (Book book : booklist) {
			totalPrice += book.getPrice();
		}
		System.out.println("전체 책 가격의 합 : " + totalPrice);
	}
}
