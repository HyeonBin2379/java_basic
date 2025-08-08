package javabasic_02.day12.afternoon.homework.interface02;

public class TVFactory extends Factory implements IWorkingTogether {

    public TVFactory(String name, int openHour, int closedHour) {
        super(name, openHour, closedHour);
    }

    @Override
    public int makeProducts(char skill) {
        switch (skill) {
            case 'A':
                return 8*getWorkingTime();
            case 'B':
                return 5*getWorkingTime();
            case 'C':
                return 3*getWorkingTime();
            default:
                return getWorkingTime();
        }
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return ((Factory) partner).makeProducts('C');
    }
}
