public class Stack {
    private Object[] arr;
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(Object x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        arr[++top] = x;
    }

    public Object pop() {

        if(isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }
        return arr[top--];
    }

    public int getSize() { return top + 1; }
    public Boolean isEmpty() { return top == -1; }
    public Boolean isFull() { return top == capacity -1; }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i] + ", ");
        }
    }
}


