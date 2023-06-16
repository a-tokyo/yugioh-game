package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class NextPhaseButton extends JButton implements ActionListener{

	public NextPhaseButton(){
		super("Next Phase", new ImageIcon("images/NextPhase.jpg"));
		setPreferredSize(new Dimension(300,165));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("", Font.ITALIC | Font.BOLD, 40));
		setForeground(java.awt.Color.WHITE);
		addActionListener(this);
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