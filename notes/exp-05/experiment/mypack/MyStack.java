package mypack;

/**
 * A simple Stack implementation using an array.
 * Follows LIFO (Last In First Out) order.
 * @author Student
 * @version 1.0
 */
public class MyStack {

    private int[] arr;
    private int top;
    private int capacity;

    /**
     * Creates a Stack with given capacity.
     * @param size the maximum size of the stack
     */
    public MyStack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    /**
     * Pushes an element onto the stack.
     * @param value the element to push
     */
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
    }

    /**
     * Removes and returns the top element.
     * @return the top element
     */
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    /**
     * Returns the top element without removing it.
     * @return the top element
     */
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }
}
