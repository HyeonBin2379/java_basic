package bookproject;

import java.util.List;

public interface CartInterface {

    void printBookList(List<Book> p);
    boolean isCartInBook(String id);
    void insertBook(Book book);
    void removeCart(int numId);
    void deleteBook();
}
