package bookproject.com.market.v1.main;

import bookproject.com.market.v1.bookitem.BookManager;
import java.util.Arrays;
import java.util.List;

public class BookMarketMain {

    public static void main(String[] args) {
        BookManager bookManager = BookManager.getInstance();
        Welcome welcome = new Welcome(bookManager);
        welcome.run();
    }
}
