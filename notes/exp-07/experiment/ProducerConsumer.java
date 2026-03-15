class SharedQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public SharedQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = 0;
        count = 0;
    }

    public synchronized void put(int value) {
        while (count == capacity) {
            try {
                System.out.println("Queue Full - Producer waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        count++;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int get() {
        while (count == 0) {
            try {
                System.out.println("Queue Empty - Consumer waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        count--;
        System.out.println("Consumed: " + value);
        notify();
        return value;
    }
}

class Producer implements Runnable {

    SharedQueue queue;

    Producer(SharedQueue q) {
        queue = q;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.put(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class Consumer implements Runnable {

    SharedQueue queue;

    Consumer(SharedQueue q) {
        queue = q;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.get();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        SharedQueue queue = new SharedQueue(3);

        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
    }
}
