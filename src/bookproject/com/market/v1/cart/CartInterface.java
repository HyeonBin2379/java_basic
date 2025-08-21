package bookproject.com.market.v1.cart;

import bookproject.com.market.v1.bookitem.Book;
import java.util.List;

public interface CartInterface {

    void printBookList(List<Book> p);
    boolean isCartInBook(String id);
    void insertBook(Book book);
    void removeCart(int numId);
    void deleteBook();
}
