package src.yugioh.gui.boardframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.yugioh.board.player.Phase;
import src.yugioh.cards.Card;
import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class NextPhaseButton extends JButton implements ActionListener{

	public NextPhaseButton(){
		super("Proxima Fase", new ImageIcon("images/NextPhase.jpg"));
		setPreferredSize(new Dimension(300,190));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		//setFont(new Font("", Font.ITALIC, 18));
		//setForeground(java.awt.Color.WHITE);
		addActionListener(this);
		setFont(new Font("", Font.ITALIC, 20));
		setForeground(Color.ORANGE);
		setBackground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent e) {
		if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2))
			GUI.getBoardFrame().getEastButtonsPanel().getEndTurnButton().doClick();
		else{
			Card.getBoard().getActivePlayer().endPhase();
			GUI.getBoardFrame().getFieldPanel().getActivePlayerPanel().getPlayerNamePanel().updatePhase();
			GUI.getBoardFrame().getFieldPanel().getOpponentPlayerPanel().getPlayerNamePanel().updatePhase();
		}
	}
}