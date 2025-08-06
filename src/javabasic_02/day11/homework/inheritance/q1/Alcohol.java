package javabasic_02.day11.homework.inheritance.q1;

public class Alcohol extends Drink{

    private double alcper;

    public Alcohol(String name, int price, int count, double alcper) {
        super(name, price, count);
        this.alcper = alcper;
    }

    public static void printTitle() {
        System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\n", "상품명(도수[%])", "단가", "수량", "금액");
    }

    @Override
    public void printData() {
        System.out.printf("%-12s\t%-5s\t%-5s\t%-5s\n",
                String.format("%s(%.1f)", this.getName(), alcper), this.getPrice(), this.getCount(), this.getTotalPrice());
    }
}
