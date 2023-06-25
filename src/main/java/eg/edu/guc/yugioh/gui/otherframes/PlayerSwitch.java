package eg.edu.guc.yugioh.gui.otherframes;

import eg.edu.guc.yugioh.gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

public class PlayerSwitch extends JFrame {
    JPanel switchPanel = new JPanel();
    JLabel switchMsg = new JLabel(new ImageIcon("images/Switch Logo 2.jpg"));
    boolean hasSwapped = false;

    public PlayerSwitch() {
        super("Player switching...");
        setSize(1367, 796);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(false);
        setResizable(false);

        setLayout(new GridLayout(0, 1));
        add(switchMsg);


        validate();
    }

    public void askForSwitching() {

        int align_x = GUI.getBoardFrame().getX();
        int align_y = GUI.getBoardFrame().getY();

        setLocation(align_x, align_y + 10);

        if(!hasSwapped) {
            setVisible(true);
            hasSwapped = true;
        }
        else {
            setVisible(false);
        }
    }

}
