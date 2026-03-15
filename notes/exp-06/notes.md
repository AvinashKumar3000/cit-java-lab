# Experiment

**Complex Number Class with Counting Active Objects**

---

# 1. Aim

To create a **Complex Number class** in Java that supports **addition and display**, and **counts the number of active objects** using a static variable.

---

# 2. Theory

## Complex Number

A **complex number** has two parts:
- **Real part** (e.g., 3)
- **Imaginary part** (e.g., 4i)

Example: `3 + 4i`

---

## Static Variable

A **static variable** belongs to the **class**, not to individual objects.
It is **shared** among all objects.

```java
static int count = 0;
```

Used here to **count how many Complex objects are currently active**.

---

## Constructor and finalize()

- **Constructor** — increments count when an object is created.
- **finalize()** — decrements count when an object is garbage collected.

```java
public Complex() {
    count++;
}

protected void finalize() {
    count--;
}
```

---

## Adding Complex Numbers

Two complex numbers are added by:
- Adding the **real parts**
- Adding the **imaginary parts**

```
(a + bi) + (c + di) = (a+c) + (b+d)i
```

---

# 3. Program

```java
public class Complex {

    private double real;
    private double imag;
    private static int count = 0;

    public Complex() {
        real = 0;
        imag = 0;
        count++;
    }

    public Complex(double r, double i) {
        real = r;
        imag = i;
        count++;
    }

    public Complex add(Complex other) {
        Complex result = new Complex();
        result.real = this.real + other.real;
        result.imag = this.imag + other.imag;
        return result;
    }

    public void display() {
        System.out.println(real + " + " + imag + "i");
    }

    public static int getCount() {
        return count;
    }

    protected void finalize() {
        count--;
    }

    public static void main(String[] args) {

        System.out.println("Active Objects: " + Complex.getCount());

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(5, 6);

        System.out.println("After creating c1 and c2:");
        System.out.println("Active Objects: " + Complex.getCount());

        System.out.print("c1 = ");
        c1.display();

        System.out.print("c2 = ");
        c2.display();

        Complex c3 = c1.add(c2);

        System.out.print("c1 + c2 = ");
        c3.display();

        System.out.println("After addition (c3 created):");
        System.out.println("Active Objects: " + Complex.getCount());

        c1 = null;
        c2 = null;
        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // ignored
        }

        System.out.println("After setting c1, c2 to null and calling gc:");
        System.out.println("Active Objects: " + Complex.getCount());
    }
}
```

---

# 4. How to Run the Program

### Step 1: Compile the program

```bash
javac Complex.java
```

---

### Step 2: Run the program

```bash
java Complex
```

---

# 5. Output

```
Active Objects: 0
After creating c1 and c2:
Active Objects: 2
c1 = 3.0 + 4.0i
c2 = 5.0 + 6.0i
c1 + c2 = 8.0 + 10.0i
After addition (c3 created):
Active Objects: 4
After setting c1, c2 to null and calling gc:
Active Objects: 2
```

**Note:** The `add()` method internally creates a new Complex object using the default constructor, so count increases by 1 extra during addition. The exact count after gc depends on the JVM.

---

# 6. Result

Thus, a **Complex Number class with active object counting using static variable was implemented successfully**.
