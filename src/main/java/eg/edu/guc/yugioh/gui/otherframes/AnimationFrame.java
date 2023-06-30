package eg.edu.guc.yugioh.gui.otherframes;

import eg.edu.guc.yugioh.gui.GUI;

import javax.swing.*;
import java.awt.*;

public class AnimationFrame extends JFrame {
    JPanel switchPanel = new JPanel();
    JLabel switchMsg = new JLabel(new ImageIcon("images/yugiAction.gif"));
    boolean hasSwapped = false;

    public AnimationFrame() {
        super("Animation");
        setSize(1367, 792);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(false);
        setResizable(false);

        setLayout(new GridLayout(0, 1));
        add(switchMsg);


        validate();
    }

    public void AnimationAsk() {

        int align_x = GUI.getBoardFrame().getX();
        int align_y = GUI.getBoardFrame().getY();

        if(!hasSwapped) {
            setVisible(true);
            hasSwapped = true;
        }
        else {
            setVisible(false);
        }
    }

}