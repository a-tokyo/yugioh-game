package eg.edu.guc.yugioh.gui.boardframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountPhase extends JPanel {
    private int active;
    private JLabel CountPhase = new JLabel();

    public CountPhase(int active) {
        this.active = active;
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(200,55));
        addPanels();
        validate();
    }

    private void addPanels() {
        add(CountPhase,BorderLayout.WEST);

        CountPhase.setPreferredSize(new Dimension(200,55));
        CountPhase.setFont(new Font("Cambria",Font.ITALIC,50));
        CountPhase.setForeground(Color.WHITE);
        CountPhase.setText(String.valueOf(" Turn " + String.valueOf(this.active/2)));
    }

    public JLabel getCurrentCountPhase() {
        return CountPhase;
    }

    public void updateCount(){
        this.active++;
        CountPhase.setText(" Turn " + String.valueOf(this.active/2));
    }
}