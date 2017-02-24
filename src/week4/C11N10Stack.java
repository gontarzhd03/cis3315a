package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
class MyStack extends ArrayList {

    public MyStack() {
    }
    public MyStack(int initialCapacity) {
        super(initialCapacity);
    }
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    public int getSize() {
        return super.size();
    }
    public Object peek() {
        return super.get(getSize() - 1);
    }
    public Object pop() {
        Object o = super.get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }
    public void push(Object o) {
        super.add(o);
    }
    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}

class C11N10Stack {
    public static void main(String[] args) {
        MyStack st = new MyStack(10);
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 5 set of numbers: ");
        for(int i = 0; i < 5; i++) {
            if(sc.hasNextLine()) {
                st.add(sc.nextLine());
            }
        }
        System.out.println("\nOutput");
        for(int i = st.getSize()-1; i >= 0; i--) {
            System.out.print(st.get(i) + " ");
        }
        System.out.println("");
    }
}
