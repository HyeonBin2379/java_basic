package boardtest.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data                   // getter, setter, toString, hashCode, equals 자동 지원
@Builder                // 빌더 패턴을 사용한 초기화 가능
@NoArgsConstructor      // 기본 생성자 사용
@AllArgsConstructor     // 생성자를 사용하여 모든 필드 초기화
public class Board {

    private int bno;
    private String bTitle;
    private String bContent;
    private String bWriter;
    private Date bDate;


}
