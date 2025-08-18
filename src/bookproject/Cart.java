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

    public CartItem getCartItem(int index) {
        return mCartItem.get(index);
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
        String format = """
                장바구니 상품 목록 :
                ---------------------------------
                    도서ID    |    수량    |    합계
                %s---------------------------------
                """;
        StringBuilder sb = new StringBuilder();
        for (CartItem cartItem : mCartItem) {
            sb.append("    ").append(cartItem).append("\n");
        }
        System.out.printf(format, sb);
    }

    public boolean isCartEmpty() {
        return mCartItem.isEmpty();
    }
}
