package java_advanced_01.day13.homework.ex02;

public class CashPayment extends Payment {

    private String cashReceiptNumber;

    public CashPayment(String shopName, String productName, long productPrice, String cashReceiptNumber) {
        super(shopName, productName, productPrice);
        this.cashReceiptNumber = cashReceiptNumber;
    }

    @Override
    public void pay() throws PayException {
        if (this.productPrice <= 0) {
            throw new PayException("가격이 잘못되었습니다.");
        }
        System.out.println("현금이 정상적으로 지불되었습니다.");
    }

    @Override
    public String toString() {
        return String.format("""
                [ 현금 결제 정보 ]
                상점명 : %s
                상품명 : %s
                상품가격 : %d
                현금영수증번호 : %s""", shopName, productName, productPrice, cashReceiptNumber);
    }
}
