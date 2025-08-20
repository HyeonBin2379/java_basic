package bookproject.com.market.v1.cart;

import bookproject.com.market.v1.bookitem.Book;
import java.util.ArrayList;
import java.util.List;

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
        System.out.printf(FORMAT, rendering());
    }
    private String rendering() {
        StringBuilder sb = new StringBuilder();
        mCartItem.forEach(cartItem -> sb.append("    ").append(cartItem).append("\n"));
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
