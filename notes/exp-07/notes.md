

# Experiment

**Thread-Safe Queue using Collection and Producer-Consumer Application**

---

# 1. Aim

To implement a **thread-safe queue using Java Collection (Queue)** and develop a **Producer-Consumer application** using synchronization, `wait()` and `notifyAll()`.

---

# 2. Theory

## Thread

A **Thread** is a lightweight process that executes tasks **concurrently**.

Two ways to create a thread:

1. **Extend Thread class**
2. **Implement Runnable interface**

---

## Synchronization

When multiple threads access **shared resources**, it may lead to **data inconsistency**.

**Synchronization** ensures that only **one thread accesses the shared resource at a time**.

```java
synchronized void put(int value) { }
synchronized int get() { }
```

---

## wait() and notifyAll()

* **wait()** → Pauses the thread until another thread notifies it
* **notifyAll()** → Wakes up all waiting threads

These methods must be used inside **synchronized methods/blocks**.

---

## Queue (Collection)

A **Queue** follows **FIFO (First In First Out)** principle.

In this program, Queue is used with LinkedList for dynamic storage.

Advantages:

* No need for manual `front` and `rear`
* Simpler implementation
* Dynamic size handling

---

## Producer-Consumer Problem

* **Producer** → Produces data and adds to queue
* **Consumer** → Consumes data from queue

### Conditions:

* Producer waits if queue is **full**
* Consumer waits if queue is **empty**

---

# 3. Program

```java
import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public SharedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int value) {
        while (queue.size() == capacity) {
            try {
                System.out.println("Queue Full - Producer waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notifyAll();
    }

    public synchronized int get() {
        while (queue.isEmpty()) {
            try {
                System.out.println("Queue Empty - Consumer waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }

        int value = queue.remove();
        System.out.println("Consumed: " + value);

        notifyAll();
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

### Step 1: Compile

```bash
javac ProducerConsumer.java
```

### Step 2: Run

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

**Note:** Output may vary due to thread scheduling.

---

# 6. Result

Thus, a **thread-safe queue using Java Collection (Queue)** was implemented successfully, and the **Producer-Consumer problem was solved using synchronization, wait(), and notifyAll()**.

