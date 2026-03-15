# The Story of Java and Applets — Part 1

## **The Birth of a Language That Changed Everything**

---

### The Year is 1991.

The internet barely exists. Most people have never seen a web browser. Computers run boring text-based programs. And a small team of engineers at **Sun Microsystems** in California is about to accidentally create one of the most important programming languages in history.

---

## Chapter 1: The Green Project

It all started with a **TV remote**.

James Gosling, Mike Sheridan, and Patrick Naughton were working on a secret project called **"The Green Project"**. Sun Microsystems wanted to build smart devices — interactive televisions, set-top boxes, the kind of gadgets we take for granted today.

They needed a programming language that could run on **any device**, regardless of its hardware. C and C++ were too dangerous — one small mistake and the whole device crashes. They needed something **safe, portable, and simple**.

So James Gosling sat down and started writing a new language. He called it **"Oak"** — named after the oak tree he could see outside his office window.

> *"We wanted a language that was simple, reliable, and could run anywhere."*
> — James Gosling

---

## Chapter 2: Oak Becomes Java

There was a problem. The name "Oak" was already trademarked by another company.

The team sat in a coffee shop, brainstorming new names. They were drinking **Java coffee** — a strong Indonesian coffee. Someone said, *"How about Java?"*

And just like that, **Java** got its name from a coffee bean.

That's why the Java logo is a **steaming cup of coffee**. Not a programming symbol. Not a circuit board. A coffee cup. Because great software sometimes begins in a coffee shop.

---

## Chapter 3: "Write Once, Run Anywhere"

The smart TV project flopped. Nobody wanted interactive television in 1993. The Green Project looked like a failure.

But then something unexpected happened — **the World Wide Web exploded**.

In 1993, the Mosaic web browser launched, and suddenly millions of people were going online. Web pages were **static and boring** — just text and images. No animations, no interactivity, no games. The web felt like reading a newspaper.

The Java team realized something: *their language was perfect for the web*.

Java's biggest feature was the **Java Virtual Machine (JVM)**. You write code once, compile it into **bytecode**, and it runs on any computer that has a JVM — Windows, Mac, Linux, anything. The slogan became:

> **"Write Once, Run Anywhere"**

This was revolutionary. In the 1990s, if you wrote a program for Windows, it wouldn't run on Mac. Period. Java broke that wall.

---

## Chapter 4: The Applet is Born

Now here's where our lab experiments come in.

The Java team thought: *what if we could run small Java programs directly inside a web browser?* Not full applications — small, lightweight programs embedded in a webpage. They called these **"Applets"** (small applications).

The idea was magical:
- You visit a webpage
- The browser downloads a tiny Java program
- It runs **inside the browser** in a safe sandbox
- You see animations, games, interactive charts — things the web had never seen before

In **1995**, Sun Microsystems officially released **Java 1.0** along with a browser called **HotJava** that could run Java Applets.

The tech world went crazy.

---

## Chapter 5: The Golden Age of Applets (1995–2005)

Java Applets were **everywhere**. Here's what people built with them:

**Games** — Simple browser games like chess, tic-tac-toe, and puzzle games ran as applets. Before Flash, before HTML5, applets were *the* way to play games in a browser.

**Animations** — Spinning 3D logos, bouncing balls, interactive art. Websites that used applets looked *futuristic* compared to plain HTML pages.

**Scientific Tools** — Universities used applets for interactive physics simulations, chemistry molecule viewers, and math graphing tools. Students could *play* with equations.

**Banking & Enterprise** — Banks used applets for secure online transactions. Companies built entire internal applications as applets.

**Chat Applications** — Some of the earliest web-based chat rooms were Java Applets running in the browser.

### How Applets Actually Worked

This is exactly what we study in our lab:

```
Browser loads HTML page
    ↓
HTML has <applet> tag pointing to a .class file
    ↓
Browser's JVM plugin downloads the bytecode
    ↓
Applet runs inside the browser in a "sandbox"
    ↓
User sees interactive content on the webpage
```

The **applet lifecycle** we study — `init()`, `start()`, `paint()`, `stop()`, `destroy()` — these methods controlled the entire flow. The browser called them automatically:

| When? | Method Called |
|-------|-------------|
| Page loads | `init()` → `start()` → `paint()` |
| User switches tab | `stop()` |
| User comes back | `start()` → `paint()` |
| User closes page | `stop()` → `destroy()` |

This was elegant design. The browser managed the applet's life, and the programmer just filled in the methods.

---

## Chapter 6: The AWT — Java's First GUI Toolkit

To build interactive applets, you needed **buttons, text fields, checkboxes** — GUI components. Java provided these through the **Abstract Window Toolkit (AWT)**.

AWT was Java's **first attempt** at a graphical user interface library. It wrapped the native OS components:

- On Windows, an AWT Button looked like a Windows button
- On Mac, it looked like a Mac button
- On Linux, it looked like a Linux button

This was both a strength and a weakness. It looked "native" everywhere, but it also looked **different** everywhere.

The components we use in our experiments — `Label`, `TextField`, `Button`, `Checkbox`, `Choice` — these are all **AWT components** from `java.awt.*`.

The **event handling system** (`ActionListener`, `ItemListener`, `ActionEvent`, `ItemEvent`) was how Java connected the user's actions to your code. Click a button? Java fires an `ActionEvent`. Select a checkbox? Java fires an `ItemEvent`. Your code just had to **listen**.

```
User clicks button
    ↓
Java creates ActionEvent object
    ↓
Calls your actionPerformed() method
    ↓
Your code runs
```

This **event-driven programming model** is still the foundation of almost every GUI framework today — Android, React, SwiftUI. They all work the same way. Learning AWT in 2026 teaches you a pattern that's everywhere.

---

## Chapter 7: Java Grows Up

Java didn't stop at applets. It grew into something much bigger:

- **Java 1.1 (1997)** — Inner classes, JDBC for databases
- **Java 1.2 (1998)** — Swing (better GUI), Collections framework. Sun started calling it **"Java 2"**
- **Java 1.3–1.4 (2000–2002)** — Performance improvements
- **Java 5 (2004)** — Generics, annotations, enhanced for-loop
- **Java 6 (2006)** — Scripting support, performance
- **Java 7 (2011)** — Try-with-resources, diamond operator
- **Java 8 (2014)** — **Lambda expressions, Streams, functional programming** — the biggest update in Java's history

Java 8 is what most colleges teach today, and for good reason. It introduced a completely modern way of writing Java while keeping backward compatibility with everything that came before — including applets.

---

*Continue to Part 2: The Fall of Applets, and What Replaced Them...*
