package src.yugioh.gui.boardframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.yugioh.cards.Card;
import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class EndTurnButton extends JButton implements ActionListener{
	
	public EndTurnButton(){
		super("Fim do Turno",new ImageIcon("images/EndTurn.jpg"));
		setPreferredSize(new Dimension(300,190));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setFont(new Font("", Font.ITALIC, 20));
		//setForeground(java.awt.Color.WHITE);
		setForeground(Color.ORANGE);
		setBackground(Color.BLACK);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		Card.getBoard().getActivePlayer().endTurn();
		GUI.getBoardFrame().getFieldPanel().getActivePlayerPanel().getPlayerNamePanel().updateAll();
		GUI.getBoardFrame().getFieldPanel().getOpponentPlayerPanel().getPlayerNamePanel().updateAll();
		GUI.getBoardFrame().getWestImagesPanel().swap();
		GUI.getBoardFrame().updateBoardFrame();
		GUI.getBoardFrame().resetHandlers(); // added
		GUI.getBoardFrame().getActiveHandPanel().repaint();
	}
	
}
