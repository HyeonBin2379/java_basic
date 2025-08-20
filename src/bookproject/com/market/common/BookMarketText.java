package bookproject.com.market.common;

public enum BookMarketText {

    MENU("""
            *******************************************************
                    Welcome to Shopping Mall
                    Welcome to Book Market!
            *******************************************************
             1. 고객 정보 확인하기\t\t4. 바구니에 항목 추가하기
             2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 수정
             3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기
             7. 영수증 표시하기\t\t8. 종료
             9. 관리자 로그인
            *******************************************************"""),
    USER_INFO("""
            현재 고객 정보 :
            이름 %-5s\t연락처 %s
            """),
    ADMIN_INFO("""
            이름 %s   연락처 %s
            아이디 %s   비밀번호 %s
            """),
    BILL_HEADER("""
                -------------배송받을 고객 정보---------------
                고객명 : %s\t\t연락처 : %s
                배송지 : %s\t\t발송일 : %s
                """),
    BILL_FOOTER("""
                \t\t\t주문 총금액 : %d원
                -------------------------------------------
                """);

    private final String text;

    BookMarketText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
