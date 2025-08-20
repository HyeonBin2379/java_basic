package bookproject.com.market.v1.cart;

import bookproject.com.market.v1.bookitem.Book;
import java.util.List;

public interface CartInterface {

    String FORMAT = """
                장바구니 상품 목록 :
                ---------------------------------
                    도서ID    |    수량    |    합계
                %s---------------------------------
                """;

    void printBookList(List<Book> p);
    boolean isCartInBook(String id);
    void insertBook(Book book);
    void removeCart(int numId);
    void deleteBook();
}
