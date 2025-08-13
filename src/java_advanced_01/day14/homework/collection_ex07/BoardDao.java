package java_advanced_01.day14.homework.collection_ex07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    private List<Board> boardList = new ArrayList<>();

    public BoardDao() {
        add(new Board("제목1", "내용1"));
        add(new Board("제목2", "내용2"));
        add(new Board("제목3", "내용3"));
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void add(Board board) {
        boardList.add(board);
    }
}
