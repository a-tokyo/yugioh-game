package eg.edu.guc.yugioh.gui.otherframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSwitch extends JFrame implements ActionListener {
    JPanel switchPanel = new JPanel();
    JButton switchButton = new JButton("Swapped done!");
    JLabel switchMsg = new JLabel(new ImageIcon("images/Switch Logo.jpg"));
    boolean hasSwapped = false;

    public PlayerSwitch() {
        super("Player switching...");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(926,678);
        setLocation(dim.width/8-this.getSize().width/8, dim.height/8-this.getSize().height/8);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(false);
        setResizable(false);
        setContentPane(switchMsg);

        switchButton.addActionListener(this);
        switchPanel.setLayout(new GridLayout(0, 1));
        //add(switchPanel, BorderLayout.CENTER);
        switchPanel.setVisible(true);
        switchPanel.add(switchButton);

        add(switchPanel);
        validate();
    }

    public void askForSwitching() {
        if(!hasSwapped) {
            setVisible(true);
            hasSwapped = true;

            for(int i=0; i<50000; i+=1) {}

            setVisible(false);
        }
        else {
            setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //askForSwitching();
    }
}
