package javabasic_02.day11.shape;

public class ShapeMain {

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[4];
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle();
        }

        Circle[] circles = new Circle[3];
        for (int i = 0; i < 3; i++) {
            circles[i] = new Circle();
        }

        Triangle[] triangles = new Triangle[5];
        for (int i = 0; i < 5; i++) {
            triangles[i] = new Triangle();
        }

        // 1개의 자료형 Shape으로 관리하여 가독성과 유지보수성을 개선할 수 있음.
        // 자식 클래스에만 있는 메서드를 실행한다면, 업캐스팅한 객체를 다시 다운캐스팅해야 함.
        Shape[] shapes = new Shape[4];
        shapes[0] = rectangles[0];
        shapes[1] = rectangles[1];
        shapes[2] = triangles[2];
        shapes[3] = circles[2];

        Circle circle = (Circle) shapes[3];     // 다운캐스팅

//        Shape[][] shapes = new Shape[3][];
//        shapes[0] = rectangles;
//        shapes[1] = circles;
//        shapes[2] = triangles;
//
//        for (Shape[] shape : shapes) {
//            for (Shape s : shape) {
//                s.print();
//            }
//            System.out.println();
//        }
    }
}
