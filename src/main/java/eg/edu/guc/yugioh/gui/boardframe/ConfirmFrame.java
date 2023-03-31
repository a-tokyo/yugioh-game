package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ConfirmFrame extends JFrame implements ActionListener{
	
	public ConfirmFrame(String message) {
		super("Confirm Action");
		JButton button = new JButton("Confirm");
		JLabel messageLabel = new JLabel(message);
		setLayout(new GridBagLayout());
		setSize(350, 110);
		setResizable(false);
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2-20);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		add(messageLabel , c);
		c.gridy =1;
		c.insets.top =10;
		add(button , c);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}