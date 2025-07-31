package javabasic_02.day07;

public class MovieTest {

    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.title = "아바타";
        movie1.startDate = "2022.12.14";
        movie1.protagonist = "제이크 설리";
        movie1.genre = "장르";
        movie1.runningTime = 192;
        movie1.level = 12;

        System.out.println("영화제목 " + movie1.title);
    }
}
