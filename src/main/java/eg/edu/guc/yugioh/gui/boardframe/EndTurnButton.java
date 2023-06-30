package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.otherframes.PlayerSwitch;

@SuppressWarnings("serial")
public class EndTurnButton extends JButton implements ActionListener{
	
	public EndTurnButton(){
		super("End Turn",new ImageIcon("images/EndTurn.jpg"));
		setPreferredSize(new Dimension(300,165));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("", Font.ITALIC| Font.BOLD, 40));
		setForeground(java.awt.Color.WHITE);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		PlayerSwitch ps = new PlayerSwitch();
		Card.getBoard().getActivePlayer().endTurn();
		GUI.getBoardFrame().getFieldPanel().getActivePlayerPanel().getPlayerNamePanel().updateAll();
		GUI.getBoardFrame().getFieldPanel().getOpponentPlayerPanel().getPlayerNamePanel().updateAll();
		GUI.getBoardFrame().getWestImagesPanel().getCurrentCountPhase().updateCount();
		// Do the PlayerSwitch frame appear here
		ps.askForSwitching();

		GUI.getBoardFrame().getWestImagesPanel().swap();
		// PlayerSwitch frame appears here
		GUI.getBoardFrame().updateBoardFrame();
		GUI.getBoardFrame().resetHandlers(); // added
		GUI.getBoardFrame().getActiveHandPanel().repaint();
	}
	
}
