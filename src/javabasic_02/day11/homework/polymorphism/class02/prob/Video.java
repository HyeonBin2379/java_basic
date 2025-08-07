package javabasic_02.day11.homework.polymorphism.class02.prob;

public class Video extends Content {

    private String genre;

    public Video(String title, String genre) {
        super(title);
        this.genre = genre;
    }

    @Override
    public void totalPrice() {
        switch (genre) {
            case "new":
                this.setPrice(2000);
                break;
            case "comic":
                this.setPrice(1500);
                break;
            case "child":
                this.setPrice(1000);
                break;
            default:
                this.setPrice(500);
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
