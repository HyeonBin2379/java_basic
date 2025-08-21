package bookproject.com.market.v1.cart;

import bookproject.com.market.v1.bookitem.Book;
import bookproject.com.market.v1.common.BookMarketText;

import java.util.ArrayList;
import java.util.List;

import static bookproject.com.market.v1.common.BookMarketText.*;

public class Cart implements CartInterface {

    private final List<CartItem> mCartItem;

    public Cart() {
        this.mCartItem = new ArrayList<>();
    }

    @Override
    public void printBookList(List<Book> bookList) {
        bookList.forEach(System.out::println);
    }

    @Override
    public boolean isCartInBook(String id) {
        return this.indexOf(id) != -1;
    }

    @Override
    public void insertBook(Book book) {
        mCartItem.add(new CartItem(book));
    }

    @Override
    public void removeCart(int numId) {
        CartItem cartItem = mCartItem.get(numId);

        removeCart(cartItem);
    }

    @Override
    public void deleteBook() {
        mCartItem.clear();
    }

    public void removeCart(CartItem cartItem) {
        mCartItem.remove(cartItem);
    }

    public CartItem getCartItem(String bookID) {
        return mCartItem.get(indexOf(bookID));
    }

    public int indexOf(String bookID) {
        return mCartItem.stream()
                .filter(cartItem -> bookID.equals(cartItem.getBookID()))
                .findFirst()
                .map(mCartItem::indexOf)
                .orElse(-1);
    }

    public void printCart() {
        System.out.printf(CART_LAYOUT.getText(), rendering());
    }
    private String rendering() {
        StringBuilder sb = new StringBuilder();
        mCartItem.forEach(cartItem -> sb.append(BookMarketText.getItem(cartItem)));
        return sb.toString();
    }

    public boolean isCartEmpty() {
        return mCartItem.isEmpty();
    }

    public int calculateTotalPrice() {
        return mCartItem.stream()
                .mapToInt(CartItem::getTotalPrice)
                .sum();
    }
}
