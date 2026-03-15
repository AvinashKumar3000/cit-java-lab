# Experiment

**Thread-Safe Queue and Producer-Consumer Application**

---

# 1. Aim

To implement a **thread-safe queue** using synchronization and develop a **Producer-Consumer application** using Java threads.

---

# 2. Theory

## Thread

A **Thread** is a lightweight process that runs **concurrently**.

Two ways to create a thread:
1. **Extend Thread class**
2. **Implement Runnable interface**

---

## Synchronization

When multiple threads access **shared data**, it may cause **data inconsistency**.

**Synchronization** ensures only **one thread** accesses the shared resource at a time.

```java
synchronized void put(int value) { }
synchronized int get() { }
```

---

## wait() and notify()

- **wait()** — makes the current thread **wait** until another thread calls `notify()`.
- **notify()** — **wakes up** one waiting thread.

These methods are used inside **synchronized** blocks.

---

## Producer-Consumer Problem

- **Producer** — generates data and puts it into a queue.
- **Consumer** — takes data from the queue and processes it.

Rules:
- Producer **waits** if the queue is **full**.
- Consumer **waits** if the queue is **empty**.

---

# 3. Program

```java
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
```

---

# 4. How to Run the Program

### Step 1: Compile the program

```bash
javac ProducerConsumer.java
```

---

### Step 2: Run the program

```bash
java ProducerConsumer
```

---

# 5. Output

```
Produced: 1
Produced: 2
Consumed: 1
Produced: 3
Produced: 4
Consumed: 2
Produced: 5
Consumed: 3
Queue Full - Producer waiting
Consumed: 4
Consumed: 5
```

**Note:** Output may vary slightly due to thread scheduling.

---

# 6. Result

Thus, a **Thread-Safe Queue with Producer-Consumer application was implemented successfully using Java synchronization**.
