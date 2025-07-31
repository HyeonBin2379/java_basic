package javabasic_02.day07;

public class MemberTest {

    public static void main(String[] args) {
        Member ss_health1 = new Member();
        ss_health1.name = "홍길동";
        ss_health1.age = 30;
        ss_health1.phoneNumber = "010-1111-1111";
        ss_health1.email = "fc@naver.com";
        ss_health1.address = "서울";
        ss_health1.weight = 57.6;

        Member ss_health2 = new Member();
        ss_health2.name = "김진영";
        ss_health2.age = 32;
        ss_health2.phoneNumber = "010-1111-2222";
        ss_health2.email = "gm@naver.com";
        ss_health2.address = "서울";
        ss_health2.weight = 60.8;

        // 삼성지점 sshealth 헬스센터
        Member[] members = new Member[2];
        members[0] = ss_health1;
        members[1] = ss_health2;

        // 삼성 지점 회원 명단 출력
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].name);
        }
    }
}
