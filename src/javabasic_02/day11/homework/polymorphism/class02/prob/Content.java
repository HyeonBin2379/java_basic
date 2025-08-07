package javabasic_02.day11.homework.polymorphism.class02.prob;

public abstract class Content {

    private String title;
    private int price;

    public Content() {
    }

    public Content(String title) {
        this.title = title;
    }

    public abstract void totalPrice();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void show() {
        System.out.printf("%s 비디오의 가격은  %d원 입니다.\n", title, price);
    }
}
