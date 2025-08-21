package bookproject.com.market.v1.bookitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookManager {
    private static final BookManager BOOK_MANAGER_SINGLETON = new BookManager();
    private final Map<String, Book> bookMap = new HashMap<>();

    private BookManager() {
    }

    public static BookManager getInstance() {
        return BOOK_MANAGER_SINGLETON;
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookMap.values());
    }

    public Book getBook(String bookId) {
        return bookMap.getOrDefault(bookId, null);
    }

    public void setBookData(List<String> tuples) {
        tuples.stream()
                .map(tuple -> Arrays.asList(tuple.split(" \\| ")))
                .filter(attributes -> !bookMap.containsKey(attributes.get(0)))
                .forEach(this::insertBook);
    }

    public void insertBook(List<String> attributes) {
        Book newBook = new Book();

        newBook.setBookId(attributes.get(0));
        newBook.setName(attributes.get(1));
        newBook.setUnitPrice(Integer.getInteger(attributes.get(2)));
        newBook.setAuthor(attributes.get(3));
        newBook.setDescription(attributes.get(4));
        newBook.setCategory(attributes.get(5));
        newBook.setReleaseDate(attributes.get(6));

        bookMap.put(newBook.getBookId(), newBook);
    }
}
