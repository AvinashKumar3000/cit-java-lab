package mypack;

/**
 * A simple Queue implementation using an array.
 * Follows FIFO (First In First Out) order.
 * @author Student
 * @version 1.0
 */
public class MyQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Creates a Queue with given capacity.
     * @param size the maximum size of the queue
     */
    public MyQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param value the element to add
     */
    public void enqueue(int value) {
        if (rear == capacity - 1) {
            System.out.println("Queue is Full");
            return;
        }
        arr[++rear] = value;
    }

    /**
     * Removes and returns the front element.
     * @return the front element
     */
    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front++];
    }

    /**
     * Returns the front element without removing it.
     * @return the front element
     */
    public int peek() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    /**
     * Checks if the queue is empty.
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return front > rear;
    }
}
