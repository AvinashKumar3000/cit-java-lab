# Experiment

**AWT Checkbox, Choice and ItemEvent Handling**

---

# 1. Aim

To create a **Java Applet using AWT Checkbox and Choice components** and handle **selection changes using ItemEvent**.

---

# 2. Theory

## Checkbox

A **Checkbox** is a component that can be **checked or unchecked**.

```java
Checkbox cb = new Checkbox("Java");
```

Multiple checkboxes can be selected at the same time.

---

## CheckboxGroup (Radio Button)

A **CheckboxGroup** makes checkboxes work like **radio buttons**.
Only **one checkbox** can be selected at a time.

```java
CheckboxGroup cg = new CheckboxGroup();
Checkbox r1 = new Checkbox("Male", cg, true);
Checkbox r2 = new Checkbox("Female", cg, false);
```

---

## Choice (Drop-down)

A **Choice** component creates a **drop-down list**.

```java
Choice c = new Choice();
c.add("Red");
c.add("Green");
c.add("Blue");
```

---

## ItemEvent

An **ItemEvent** is generated when a user **selects or deselects** a Checkbox or Choice item.

To handle this event:

```java
implements ItemListener
```

Method used:

```java
public void itemStateChanged(ItemEvent e)
```

Package:

```text
java.awt.event.*
```

---

# 3. Program

```java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ItemEventApplet extends Applet implements ItemListener {

    Checkbox cb1, cb2, cb3;
    Choice colorChoice;
    Label resultLabel;

    public void init() {

        cb1 = new Checkbox("Java");
        cb2 = new Checkbox("Python");
        cb3 = new Checkbox("C++");

        colorChoice = new Choice();
        colorChoice.add("Red");
        colorChoice.add("Green");
        colorChoice.add("Blue");

        resultLabel = new Label("Select an option");

        add(cb1);
        add(cb2);
        add(cb3);
        add(colorChoice);
        add(resultLabel);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        colorChoice.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {

        String msg = "";

        if (cb1.getState()) msg += "Java ";
        if (cb2.getState()) msg += "Python ";
        if (cb3.getState()) msg += "C++ ";

        msg += "| Color: " + colorChoice.getSelectedItem();

        resultLabel.setText(msg);
    }
}
```

---

# 4. HTML File

Create **ItemEventApplet.html**

```html
<html>
<body>

<applet code="ItemEventApplet.class" width="400" height="200">
</applet>

</body>
</html>
```

---

# 5. How to Run the Program

### Step 1: Compile the program

```bash
javac ItemEventApplet.java
```

---

### Step 2: Run the applet

```bash
appletviewer ItemEventApplet.html
```

---

# 6. Output

The applet window shows:

* Three **Checkboxes** (Java, Python, C++)
* A **Choice drop-down** (Red, Green, Blue)
* A **Label** displaying the selected options

When any checkbox or choice item is changed, the label updates to show:

```
Java C++ | Color: Green
```

---

# 7. Result

Thus, the **AWT Checkbox, Choice components and ItemEvent handling were implemented successfully**.
