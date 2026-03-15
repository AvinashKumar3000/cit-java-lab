Here are **simple lab notes** you can write easily in your **college record**.

---

# Experiment

**Applet Life Cycle and Drawing Shapes using Graphics Class**

---

# 1. Aim

To study the **life cycle of a Java Applet** and **draw shapes using the Graphics class**.

---

# 2. Theory

## Java Applet

A **Java Applet** is a small Java program that runs inside a **browser or applet viewer**.
It is mainly used to create **graphical applications**.

Applet class is available in:

```
java.applet.Applet
```

Basic structure:

```java
import java.applet.*;
import java.awt.*;

public class MyApplet extends Applet
{
}
```

---

# 3. Applet Life Cycle

An Applet has **five important methods**.

### 1. init()

- Called **once** when the applet starts.
- Used for **initialization**.

```
public void init()
```

---

### 2. start()

- Called after `init()`.
- Runs when the applet becomes active.

```
public void start()
```

---

### 3. paint(Graphics g)

- Used to **display output**.
- Used to **draw shapes and text**.

```
public void paint(Graphics g)
```

---

### 4. stop()

- Called when the user leaves the page.

```
public void stop()
```

---

### 5. destroy()

- Called when the applet is removed from memory.

```
public void destroy()
```

---

# 4. Graphics Class

The **Graphics class** is used for drawing shapes.

Package:

```
java.awt.Graphics
```

Common methods:

| Method       | Purpose          |
| ------------ | ---------------- |
| drawLine()   | Draw line        |
| drawRect()   | Draw rectangle   |
| drawOval()   | Draw oval        |
| drawString() | Display text     |
| fillRect()   | Filled rectangle |
| fillOval()   | Filled oval      |

---

# 5. Program

```java
import java.applet.*;
import java.awt.*;

public class ShapesApplet extends Applet {

    @override
    public void init() {
        System.out.println("Applet Initialized");
    }
    @override
    public void start() {
        System.out.println("Applet Started");
    }
    @override
    public void stop() {
        System.out.println("Applet Stopped");
    }
    @override
    public void destroy() {
        System.out.println("Applet Destroyed");
    }
    @override
    public void paint(Graphics g) {
        g.drawString("Drawing Shapes", 20, 30);
        g.drawLine(50, 60, 200, 60);
        g.drawRect(50, 80, 100, 60);
        g.drawOval(200, 80, 100, 60);
        g.fillRect(50, 170, 100, 60);
        g.fillOval(200, 170, 100, 60);
    }
}
```

---

# 6. HTML File

Create a file **ShapesApplet.html**

```html
<html>
  <body>
    <applet code="ShapesApplet.class" width="400" height="300"> </applet>
  </body>
</html>
```

---

# 7. How to Run the Program

### Step 1: Compile the program

```
javac ShapesApplet.java
```

---

### Step 2: Run the applet

```
appletviewer ShapesApplet.html
```

---

# 8. Output

The applet window displays:

- Line
- Rectangle
- Oval
- Filled Rectangle
- Filled Oval
- Text message

---

# 9. Result

Thus, the **Applet life cycle was studied** and **shapes were drawn using the Graphics class successfully**.
