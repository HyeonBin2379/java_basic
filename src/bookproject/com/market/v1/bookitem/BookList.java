package bookproject.com.market.v1.bookitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookList {

    private final List<Book> bookList;

    public BookList(List<String> tuples) {
        this.bookList = new ArrayList<>();
        createBookList(tuples);
    }

    public void createBookList(List<String> tuples) {
        tuples.stream()
                .map(tuple -> Arrays.asList(tuple.split(" \\| ")))
                .filter(attributes -> !this.contains(attributes.get(0)))
                .forEach(this::insertBook);
    }

    public boolean contains(String bookID) {
        return bookList.stream()
                .map(Book::getBookId)
                .anyMatch(id -> id.equals(bookID));
    }


    public void insertBook(List<String> attributes) {
        Book newBook = new Book(attributes.get(0), attributes.get(1), Integer.parseInt(attributes.get(2)));

        newBook.setAuthor(attributes.get(3));
        newBook.setDescription(attributes.get(4));
        newBook.setCategory(attributes.get(5));
        newBook.setReleaseDate(attributes.get(6));

        bookList.add(newBook);
    }

    public Book findByBookId(String bookId) {
        return bookList.stream()
                .filter(book -> bookId.equals(book.getBookId()))
                .findAny()
                .orElse(null);
    }

    public void print() {
        bookList.forEach(System.out::println);
    }
}
