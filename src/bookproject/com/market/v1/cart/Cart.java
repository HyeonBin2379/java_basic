package bookproject.com.market.v1.cart;

import bookproject.com.market.v1.bookitem.Book;
import bookproject.com.market.v1.bookitem.Item;
import bookproject.com.market.v1.common.BookMarketText;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static bookproject.com.market.v1.common.BookMarketText.*;

public class Cart implements CartInterface {

    private final List<CartItem> mCartItem;

    public Cart() {
        this.mCartItem = new ArrayList<>();
    }

    @Override
    public void printBookList(List<Book> bookList) {
        bookList.stream()
                .sorted(Comparator.comparing(Item::getBookId))
                .forEach(System.out::println);
    }

    @Override
    public boolean isCartInBook(String id) {
        return this.indexOf(this.getCartItem(id)) != -1;
    }

    @Override
    public void insertBook(Book book) {
        if (!this.isCartInBook(book.getBookId())) {
            CartItem newCartItem = new CartItem(book);
            mCartItem.add(newCartItem);
        } else {
            // 이미 장바구니에 담은 도서라면 수량만 증가
            CartItem cartItem = this.getCartItem(book.getBookId());
            int index = mCartItem.indexOf(cartItem);

            cartItem.setQuantity(cartItem.getQuantity()+1);
            updateCart(index, cartItem);
        }
    }

    @Override
    public void removeCart(int numId) {
        mCartItem.remove(numId);
    }

    @Override
    public void deleteBook() {
        mCartItem.clear();
    }

    public int indexOf(CartItem cartItem) {
        return mCartItem.indexOf(cartItem);
    }

    public CartItem getCartItem(String bookID) {
        return mCartItem.stream()
                .filter(cartItem -> bookID.equals(cartItem.getBookID()))
                .findAny()
                .orElse(null);
    }

    public void updateCart(int index, CartItem cartItem) {
        // 장바구니 항목의 갱신된 수량이 0개면 삭제
        if (cartItem.getQuantity() == 0) {
            mCartItem.remove(index);
            return;
        }
        mCartItem.set(index, cartItem);
    }

    public void printCart() {
        System.out.printf(CART_LAYOUT.getText(), rendering());
    }
    private String rendering() {
        StringBuilder sb = new StringBuilder();
        mCartItem.stream()
                .sorted(Comparator.comparing(CartItem::getBookID))
                .forEach(cartItem -> sb.append(BookMarketText.getCartInfo(cartItem)));
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
