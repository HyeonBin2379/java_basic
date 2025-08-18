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
        mCartItem.remove(cartItem);
    }

    @Override
    public void deleteBook() {
        mCartItem.clear();
    }

    public void printCart() {
        System.out.println("장바구니 상품 목록 :");
        System.out.println("---------------------------------");
        System.out.println("    도서ID \t|    수량\t|   합계");
        for (CartItem cartItem : mCartItem) {
            System.out.println(cartItem);
        }
        System.out.println("---------------------------------");
    }

    public boolean isCartEmpty() {
        return mCartItem.isEmpty();
    }

    public int indexOf(String id) {
        for (int i = 0; i < mCartItem.size(); i++) {
            CartItem cartItem = mCartItem.get(i);
            String bookId = cartItem.getBookID();
            if (bookId.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
