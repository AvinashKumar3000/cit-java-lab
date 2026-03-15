import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AWTApplet extends Applet implements ActionListener {

    Label l1;
    TextField t1;
    Button b1;

    @Override
    public void init() {

        l1 = new Label("Enter Name:");
        t1 = new TextField(20);
        b1 = new Button("Submit");

        add(l1);
        add(t1);
        add(b1);

        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        showStatus("Hello " + name);
    }
}
