package javabasic_02.day07;

public class ObjectArrayExam {

    public static void main(String[] args) {
        // 1. Movie 클래스 타입으로 영화 3편을 movieList 배열에 저장
        Movie movie1 = new Movie();
        movie1.title = "영화A";

        Movie movie2 = new Movie();
        movie2.title = "영화B";

        Movie movie3 = new Movie();
        movie3.title = "영화C";


        Movie[] movieList = new Movie[3];
        movieList[0] = movie1;
        movieList[1] = movie2;
        movieList[2] = movie3;

        System.out.println("-----------각 배열의 인덱스를 참조 출력-----------");
        System.out.println("01 영화제목 " + movieList[0]);
        System.out.println("02 영화제목 " + movieList[1]);
        System.out.println("03 영화제목 " + movieList[2]);

        System.out.println("-----------iter 참조 출력-----------");
        // 2. 저장한 영화 제목을 iter 방법으로 출력
        int i = 0;
        for (Movie movie : movieList) {
            System.out.println(++i + "번째 " + movie.title);
        }
        System.out.println("-----------itar 참조 출력-----------");
        for (i = 0; i < movieList.length; i++) {
            Movie movie = movieList[i];
            System.out.println((i+1) + "번째 " + movie.title);
        }
    }
}
