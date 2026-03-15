import java.applet.*;
import java.awt.*;

public class ShapesApplet extends Applet {

    @Override
    public void init() {
        System.out.println("Applet Initialized");
    }

    @Override
    public void start() {
        System.out.println("Applet Started");
    }

    @Override
    public void stop() {
        System.out.println("Applet Stopped");
    }

    @Override
    public void destroy() {
        System.out.println("Applet Destroyed");
    }

    @Override
    public void paint(Graphics g) {

        g.drawString("Drawing Shapes Using Graphics Class", 20, 30);

        // Line
        g.drawLine(50, 60, 200, 60);

        // Rectangle
        g.drawRect(50, 80, 100, 60);

        // Oval
        g.drawOval(200, 80, 100, 60);

        // Filled Rectangle
        g.fillRect(50, 170, 100, 60);

        // Filled Oval
        g.fillOval(200, 170, 100, 60);
    }
}