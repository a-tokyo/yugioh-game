package src.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.yugioh.cards.Card;

@SuppressWarnings("serial")
public class DeckButton extends JButton {
	private static ImageIcon deck = new ImageIcon("images/AttackMode.png");
	private boolean active;

	public DeckButton(boolean active) {
		super(deck);
		this.active = active;
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("", Font.ITALIC, 18));
		setForeground(java.awt.Color.WHITE);
		setPreferredSize(new Dimension(CardButton.getDimension('W'),150));
		updateDeck();
		validate();
	}

	public void updateDeck(){
		if(active)
			setText(""+Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		else 
			setText(""+Card.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	}
}