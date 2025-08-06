package javabasic_02.day11.inheritance.test.class03.prob;

public class Emp {

    private String id;
    private String name;
    private int baseSalary;

    public double getSalary(double bonus) {
        return baseSalary + baseSalary*bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalry(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s(%s) 사원의 기본급은 %d원 입니다.", name, id, baseSalary);
    }
}
