# Experiment

**Applet with Parameters using HTML `<PARAM>` Tag**

---

# 1. Aim

To create a **Java Applet that receives parameters from an HTML file using the `<PARAM>` tag**.

---

# 2. Theory

## Applet Parameters

Parameters are **values passed from an HTML file to a Java Applet**.
They allow the **HTML page to control the applet behavior** without changing the Java program.
Parameters are defined using the **`<PARAM>` tag inside the `<applet>` tag**.

Example:

```html
<param name="message" value="Hello Applet" />
```

---

## getParameter() Method

In Java Applet, parameters are read using the method:

```java
getParameter("parameterName")
```

Example:

```java
String msg = getParameter("message");
```

This method returns the **value passed from the HTML file**.

---

# 3. Program

```java
import java.applet.*;
import java.awt.*;

public class ParamApplet extends Applet {

    String message;

    public void init() {
        message = getParameter("msg");
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 50);
    }
}
```

---

# 4. HTML File

Create **ParamApplet.html**

```html
<html>
  <body>
    <applet code="ParamApplet.class" width="300" height="200">
      <param name="msg" value="Hello from HTML Parameter" />
    </applet>
  </body>
</html>
```

---

# 5. How to Run the Program

### Step 1: Compile the program

```
javac ParamApplet.java
```

---

### Step 2: Run the applet

```
appletviewer ParamApplet.html
```

---

# 6. Output

The applet window displays:

```
Hello from HTML Parameter
```

The text is **passed from the HTML file to the Applet using `<PARAM>` tag**.

---

# 7. Result

Thus, the **Applet with parameters using HTML `<PARAM>` tag was implemented successfully**.
