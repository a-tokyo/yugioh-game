package src.yugioh.gui.boardframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class SwitchMonsterModeButton extends JButton implements ActionListener{

	public SwitchMonsterModeButton() {
		super("MUDAR MODO CARTA",new ImageIcon("images/SwitchMonsterMode.jpg"));

		setPreferredSize(new Dimension(300,190));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		//setFont(new Font("", Font.ITALIC, 18));
		setFont(new Font("", Font.ITALIC, 20));
		//setForeground(java.awt.Color.WHITE);
		setForeground(Color.ORANGE);
		setBackground(Color.BLACK);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		GUI.getBoardFrame().setToSwitch(true);
		new ConfirmFrame("\n" +
				"Selecione um monstro para alternar entre ATK e DEF");
	}
}
