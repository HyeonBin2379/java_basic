package javabasic_02.day11.inheritance.test.class02.prob;

public class Employee {

    private String name;
    private int age;
    private String dept;

    public void print() {
        System.out.printf("이  름 : %s   나 이 : %d   부   서 : %s\n", name, age, dept);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
