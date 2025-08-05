package javabasic_02.day10.morningtest.answer;

public class PrinterStatic {

    public static void println(int value) {
        System.out.println(value);
    }

    public static void println(boolean value) {
        System.out.println(value);
    }

    public static void println(double value) {
        System.out.println(value);
    }

    public static void println(String value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        PrinterStatic.println(10);
        PrinterStatic.println(true);
        PrinterStatic.println(5.7);
        PrinterStatic.println("홍길동");
    }
}
