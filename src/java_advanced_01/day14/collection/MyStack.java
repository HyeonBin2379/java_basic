package java_advanced_01.day14.collection;

import java.util.ArrayList;

public class MyStack<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size()-1);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(10);
        ms.push(20);
        ms.push(30);

        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }
}
