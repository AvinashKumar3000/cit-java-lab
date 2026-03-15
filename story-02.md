# The Story of Java and Applets — Part 2

## **The Fall of Applets, and What Replaced Them**

---

### The Year is 2007.

The iPhone launches. The web is evolving at breakneck speed. And Java Applets — once the coolest thing on the internet — are slowly dying. This is the story of why.

---

## Chapter 8: The Cracks Start Showing

Applets had a fatal flaw from the very beginning: **they needed a plugin**.

To run a Java Applet in your browser, your computer needed the **Java Runtime Environment (JRE)** installed, and the browser needed the **Java Plugin** enabled. This sounds simple, but it created a nightmare:

- Users visited a webpage and saw: *"This page requires the Java plugin. Click here to install."*
- Most users **closed the tab immediately**
- Different Java versions caused **compatibility hell** — an applet built for Java 5 might break on Java 6
- Every few months, Java needed a **security update**, and if users didn't update, their browsers became vulnerable

Compare this to HTML. A plain HTML page just **works**. No plugin. No installation. No "click here to download." It just renders.

The plugin model was applets' biggest weakness.

---

## Chapter 9: Security — The Real Killer

Here is what truly killed Java Applets: **security vulnerabilities**.

Applets ran inside a "sandbox" — a restricted environment that prevented them from accessing your files or damaging your computer. In theory, this was safe. In practice, hackers found ways to **escape the sandbox**.

Between 2010 and 2013, the Java browser plugin became one of the **most exploited pieces of software** on the internet. Hackers could:

- Trick you into visiting a webpage with a malicious applet
- The applet would break out of the sandbox
- Install malware on your computer — without you clicking anything

It got so bad that the **US Department of Homeland Security** issued an official warning in January 2013:

> *"Disable Java in your browser immediately."*

Apple **blocked Java** from Safari by default. Google Chrome started **blocking plugins** entirely. Firefox followed. One by one, every major browser built walls against Java Applets.

The technology that was supposed to make the web interactive was now considered **dangerous**.

---

## Chapter 10: The Competitors That Won

While applets were struggling, two technologies rose to replace them:

### Adobe Flash (1996–2020)

Flash did what applets did — animations, games, interactive content — but it was **faster to develop**, looked better, and was easier to install. YouTube originally ran entirely on Flash. Almost every browser game in the 2000s was Flash.

But Flash had the same plugin problem. When smartphones arrived, Steve Jobs famously **refused to put Flash on the iPhone** in 2010, writing an open letter titled *"Thoughts on Flash"*. He argued that open web standards were the future. Flash eventually died too — Adobe officially killed it on **December 31, 2020**.

### HTML5 + CSS3 + JavaScript (2014–Today)

This is the real winner. **HTML5** introduced:

- `<canvas>` — draw 2D graphics directly in the browser (exactly what `paint(Graphics g)` did in applets)
- `<video>` and `<audio>` — media playback without plugins
- **WebGL** — 3D graphics in the browser
- **Web Workers** — background threads (like Java's threading)
- **WebSockets** — real-time communication

JavaScript frameworks like **React, Angular, and Vue.js** now build complex interactive applications entirely in the browser — no plugins, no downloads, no security warnings.

Everything applets dreamed of doing, HTML5 + JavaScript does natively.

---

## Chapter 11: The Official Death

Here's the timeline of how Java Applets were officially killed:

| Year | Event |
|------|-------|
| 2013 | Browsers start blocking Java plugin by default |
| 2015 | Chrome drops support for NPAPI plugins (needed for Java) |
| 2016 | Firefox announces NPAPI plugin phase-out |
| 2017 | **Java 9 — Oracle officially deprecates the Applet API** |
| 2018 | **Java 11 — Applet API removed completely** (along with `appletviewer`) |
| 2020 | Microsoft Edge (Chromium-based) has zero plugin support |

The `@Deprecated` annotation was placed on the entire `java.applet.Applet` class in Java 9. By Java 11, it was gone. If you write `import java.applet.*` in Java 17, **it won't compile**.

That's why in our lab, we use **Java 8** — it's the last major version where applets fully work with `appletviewer`.

---

## Chapter 12: So Why Are We Still Studying Applets?

Good question. If applets are dead, why is it in your syllabus?

Here are the real reasons:

### 1. The Concepts Are Alive

The **applet lifecycle** (`init → start → paint → stop → destroy`) is the exact same pattern used in:

- **Android Activities**: `onCreate → onStart → onResume → onPause → onStop → onDestroy`
- **React Components**: `constructor → componentDidMount → render → componentWillUnmount`
- **Flutter Widgets**: `initState → build → dispose`
- **Game Development**: `initialize → update → render → cleanup`

Learn the applet lifecycle once, and you understand every modern framework's lifecycle.

### 2. Event-Driven Programming

The `ActionListener`, `ItemListener` pattern you learn with AWT buttons and checkboxes is the **foundation** of:

- **JavaScript** — `addEventListener('click', function)`
- **Android** — `setOnClickListener()`
- **React** — `onClick={handleClick}`
- **Node.js** — the entire event-driven architecture

You're not learning the button. You're learning the **pattern**.

### 3. GUI Fundamentals

AWT components (Label, TextField, Button, Checkbox, Choice) teach you how graphical interfaces work at the **lowest level**:

- Layout — how components are arranged
- Events — how user actions become code execution
- State — how the UI reflects data changes

Modern frameworks add layers of abstraction on top, but the fundamentals are the same.

### 4. Java Packages, OOP, and Threading

Experiments 5–7 in our lab (packages, complex numbers, producer-consumer) aren't applet-specific at all. These are **core Java concepts** that every Java developer needs:

- **Packages** → code organization (used in every Java project)
- **Static variables** → shared state across objects (used everywhere)
- **Synchronized methods** → thread safety (critical for backend servers, Android apps, databases)

---

## Chapter 13: Where is Java Today?

Java didn't die with applets. It moved to where it was *always* better suited:

### Backend Servers
Java runs the backend of **Netflix, Amazon, Google, LinkedIn, Uber, and Twitter**. The **Spring Boot** framework makes Java one of the most popular choices for building APIs and microservices.

### Android Development
From 2008 to 2019, Java was **the** language for Android apps. Billions of Android phones run Java code. (Kotlin is now preferred, but it runs on the same JVM.)

### Big Data & Cloud
**Apache Hadoop, Apache Spark, Apache Kafka, Elasticsearch** — the biggest data processing tools in the world are written in Java.

### Enterprise Software
Banks, hospitals, airlines, governments — they all run massive Java applications. Java's reliability and backward compatibility make it the choice for systems that **cannot afford to crash**.

### Latest Versions
Java is now on a **6-month release cycle**:

| Version | Year | Highlight |
|---------|------|-----------|
| Java 8 (LTS) | 2014 | Lambdas, Streams — what we use in lab |
| Java 11 (LTS) | 2018 | Applets removed, HTTP Client API |
| Java 17 (LTS) | 2021 | Sealed classes, pattern matching |
| Java 21 (LTS) | 2023 | Virtual threads, record patterns |
| Java 24 | 2025 | Stream gatherers, structured concurrency |

Java 8 is still used by a huge portion of the industry because so many systems were built on it. That's exactly why your college teaches it.

---

## Chapter 14: The Applet's Legacy

Here's the beautiful thing about technology: **nothing truly dies**. It evolves.

Java Applets proved that **running code inside a browser** was possible and desirable. The concept directly influenced:

- **JavaScript** became the browser's native programming language
- **WebAssembly (WASM)** lets you run C, C++, Rust code in browsers — the spiritual successor of applets
- **Progressive Web Apps (PWAs)** are web pages that behave like installed applications
- **Electron** (used by VS Code, Discord, Slack) runs web technologies as desktop apps

The applet died, but its **dream** — interactive, cross-platform, run-anywhere applications — became the entire modern web.

---

## A Quick Summary

| Question | Answer |
|----------|--------|
| Who created Java? | James Gosling at Sun Microsystems (1995) |
| Why was it created? | For portable, safe code on any device |
| What did "Oak" become? | Java (named after coffee) |
| What were Applets? | Small Java programs running in browsers |
| Why were they popular? | First way to make web pages interactive |
| Why were they deprecated? | Plugin dependency + security vulnerabilities |
| When were they removed? | Java 9 (deprecated), Java 11 (removed) |
| What replaced them? | HTML5 + CSS3 + JavaScript |
| Why do we still study them? | Lifecycle, events, GUI, OOP — all concepts are still used |
| Where is Java now? | Servers, Android, big data, enterprise — everywhere except browsers |

---

## Final Thought

> Every technology you study has a chapter that's already written and a chapter that's still being written.
> Applets are a finished chapter. But the patterns they taught — lifecycle management, event handling, cross-platform thinking — those chapters are still being written today, in React, in Android, in every framework you'll use in your career.
> 
> You're not studying a dead technology. You're studying the **roots** of everything that came after.

---

*End of Story*
