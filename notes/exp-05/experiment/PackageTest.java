import mypack.*;

public class PackageTest {

    public static void main(String[] args) {

        System.out.println("--- Stack Operations ---");

        MyStack stack = new MyStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println();
        System.out.println("--- Queue Operations ---");

        MyQueue queue = new MyQueue(5);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
