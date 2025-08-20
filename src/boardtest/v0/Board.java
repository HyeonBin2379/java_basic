package boardtest.v0;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Board {

    private int bno;            // 글번호
    private String btitle;      // 글제목
    private String bcontent;    // 글내용
    private String bwriter;     // 글쓴이
    private Date bdate;

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

        return String.format("%d\t\t%s\t\t%s\t\t%s\n", bno, bwriter, formatter.format(bdate), btitle);
    }
}
