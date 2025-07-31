package javabasic_02.day07;

public class Aladin {

    public static void main(String[] args) {
        Book book1 = new Book();
        System.out.println(book1);
        book1.title = "전지적독자시점";
        book1.author = "싱숑";
        book1.company = "비채";
        book1.price = 13500;

        Book book2 = new Book();
        book2.title = "견우와선녀";
        book2.author = "안수민";
        book2.company = "아르테팝";
        book2.price = 18800;

        Book[] fantasy = new Book[2];
        fantasy[0] = book1;
        fantasy[1] = book2;

        System.out.println(fantasy[1].title);
        System.out.println(fantasy[1].author);
        System.out.println(fantasy[1].price);

//        System.out.println(book.title);
//        System.out.println(book.author);
//        System.out.println(book.company);
//        System.out.println(book.price);
    }
}
