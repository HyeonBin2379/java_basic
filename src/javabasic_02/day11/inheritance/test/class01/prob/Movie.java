package javabasic_02.day11.inheritance.test.class01.prob;

public class Movie {

    private String title;
    private String genre;

    public void play() {
        System.out.printf("%s(%s) 상영중입니다.\n", title, genre);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
