# Experiment

**AWT Components (Label, TextField, Button) with ActionEvent**

---

# 1. Aim

To create a **Java Applet using AWT components (Label, TextField, Button)** and handle **button click using ActionEvent**.

---

# 2. Theory

## AWT Components

**AWT (Abstract Window Toolkit)** is used to create **GUI components in Java**.

Some common AWT components:

| Component | Purpose                         |
| --------- | ------------------------------- |
| Label     | Displays text                   |
| TextField | Takes user input                |
| Button    | Performs an action when clicked |

Package used:

```text
java.awt.*
```

---

## ActionEvent

An **ActionEvent** occurs when a user **clicks a button**.

To handle this event, Java uses:

```text
java.awt.event.*
```

The class must implement:

```text
ActionListener
```

Method used:

```java
public void actionPerformed(ActionEvent e)
```

This method executes when the **button is clicked**.

---

# 3. Program

```java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AWTApplet extends Applet implements ActionListener {

    Label l1;
    TextField t1;
    Button b1;

    public void init() {

        l1 = new Label("Enter Name:");
        t1 = new TextField(20);
        b1 = new Button("Submit");

        add(l1);
        add(t1);
        add(b1);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        showStatus("Hello " + name);
    }
}
```

---

# 4. HTML File

Create **AWTApplet.html**

```html
<html>
<body>

<applet code="AWTApplet.class" width="400" height="200">
</applet>

</body>
</html>
```

---

# 5. How to Run the Program

### Step 1: Compile the program

```bash
javac AWTApplet.java
```

---

### Step 2: Run the applet

```bash
appletviewer AWTApplet.html
```

---

# 6. Output

The applet window shows:

* A **Label** asking for name
* A **TextField** to enter name
* A **Button**

When the button is clicked, it displays:

```
Hello <Entered Name>
```

in the **status bar**.

---

# 7. Result

Thus, the **AWT components (Label, TextField, Button) and ActionEvent handling were implemented successfully**.
