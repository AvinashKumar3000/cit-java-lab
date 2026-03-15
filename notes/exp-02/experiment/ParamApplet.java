import java.applet.*;
import java.awt.*;

public class ParamApplet extends Applet {

    String message;

    @Override
    public void init() {
        message = getParameter("msg");
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 50, 50);
    }
}