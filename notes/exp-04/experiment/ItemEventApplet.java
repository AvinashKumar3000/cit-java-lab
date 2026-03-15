import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ItemEventApplet extends Applet implements ItemListener {

    Checkbox cb1, cb2, cb3;
    Choice colorChoice;
    Label resultLabel;

    @Override
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

    @Override
    public void itemStateChanged(ItemEvent e) {

        String msg = "";

        if (cb1.getState()) msg += "Java ";
        if (cb2.getState()) msg += "Python ";
        if (cb3.getState()) msg += "C++ ";

        msg += "| Color: " + colorChoice.getSelectedItem();

        resultLabel.setText(msg);
    }
}
