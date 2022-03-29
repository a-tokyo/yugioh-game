package src.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class SwitchMonsterModeButton extends JButton implements ActionListener{

	public SwitchMonsterModeButton() {
		super("Switch Mode",new ImageIcon("images/SwitchMonsterMode.jpg"));
		setPreferredSize(new Dimension(300,165));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("", Font.ITALIC, 18));
		setForeground(java.awt.Color.WHITE);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		GUI.getBoardFrame().setToSwitch(true);
		new ConfirmFrame("Please select a monster to switch its mode");
	}
}
