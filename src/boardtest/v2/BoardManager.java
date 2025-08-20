package boardtest.v2;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoardManager {

    private Map<String, Board> boardMap = new LinkedHashMap<>();

    // 싱글톤 패턴을 적용하여 관리자 계정은 1개만 존재
    // 관리자 계정은 게시글 저장소를 관리
    private static final BoardManager boardManagerSingleton = new BoardManager();

    private BoardManager() {}

    public Map<String, Board> getBoardMap() {
        return boardMap;
    }

    public void setBoardMap(Map<String, Board> boardMap) {
        this.boardMap = boardMap;
    }

    public static BoardManager getInstance() {
        return boardManagerSingleton;
    }
}
