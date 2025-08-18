package bookproject;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {

    private final List<CartItem> mCartItem;

    public Cart() {
        this.mCartItem = new ArrayList<>();
    }

    @Override
    public void printBookList(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
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
    public void removeCart(CartItem cartItem) {
        mCartItem.remove(cartItem);
    }

    @Override
    public void deleteBook() {
        mCartItem.clear();
    }

    public CartItem getCartItem(int index) {
        return mCartItem.get(index);
    }
    public CartItem getCartItem(String bookID) {
        return mCartItem.get(indexOf(bookID));
    }

    public int indexOf(String bookID) {
        for (int i = 0; i < mCartItem.size(); i++) {
            CartItem cartItem = mCartItem.get(i);
            if (bookID.equals(cartItem.getBookID())) {
                return i;
            }
        }
        return -1;
    }

    public void printCart() {
        System.out.printf(FORMAT, rendering());
    }
    private String rendering() {
        StringBuilder sb = new StringBuilder();
        for (CartItem cartItem : mCartItem) {
            sb.append("    ").append(cartItem).append("\n");
        }
        return sb.toString();
    }

    public boolean isCartEmpty() {
        return mCartItem.isEmpty();
    }
}
