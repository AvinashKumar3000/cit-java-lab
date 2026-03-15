# Experiment

**Develop a Java Package with Stack and Queue Classes (with JavaDoc)**

---

# 1. Aim

To create a **Java Package** containing **Stack and Queue classes** with proper **JavaDoc documentation**.

---

# 2. Theory

## Java Package

A **package** is a group of related classes organized in a folder.

To create a package:

```java
package mypack;
```

To use a package:

```java
import mypack.*;
```

---

## Stack

A **Stack** follows **LIFO (Last In First Out)** order.

Operations:
- **push()** — adds an element on top
- **pop()** — removes the top element
- **peek()** — returns the top element without removing
- **isEmpty()** — checks if stack is empty

---

## Queue

A **Queue** follows **FIFO (First In First Out)** order.

Operations:
- **enqueue()** — adds an element at the rear
- **dequeue()** — removes an element from the front
- **peek()** — returns the front element without removing
- **isEmpty()** — checks if queue is empty

---

## JavaDoc

**JavaDoc** is a tool to generate **HTML documentation** from Java comments.

JavaDoc comment format:

```java
/**
 * Description of the class or method.
 * @param paramName description
 * @return description
 */
```

To generate documentation:

```bash
javadoc -d docs mypack/*.java
```

---

# 3. Program

## Package File: MyStack.java

```java
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
```

---

## Package File: MyQueue.java

```java
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
```

---

## Main File: PackageTest.java

```java
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
```

---

# 4. Folder Structure

```
experiment/
├── mypack/
│   ├── MyStack.java
│   └── MyQueue.java
└── PackageTest.java
```

---

# 5. How to Run the Program

### Step 1: Compile the package classes

```bash
javac mypack/MyStack.java mypack/MyQueue.java
```

---

### Step 2: Compile the test program

```bash
javac PackageTest.java
```

---

### Step 3: Run the program

```bash
java PackageTest
```

---

### Step 4: Generate JavaDoc

```bash
javadoc -d docs mypack/*.java
```

---

# 6. Output

```
--- Stack Operations ---
Top: 30
Pop: 30
Pop: 20

--- Queue Operations ---
Front: 100
Dequeue: 100
Dequeue: 200
```

---

# 7. Result

Thus, a **Java Package with Stack and Queue classes was developed with JavaDoc documentation successfully**.
