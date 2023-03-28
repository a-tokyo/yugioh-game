package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.cards.Card;

@SuppressWarnings("serial")
public class PlayerNamePanel extends JPanel {
	private JLabel playerNameLabel = new JLabel();
	private JLabel lifePointsLabel = new JLabel();
	private JLabel currentPhaseLabel = new JLabel();
	private boolean active;

	public PlayerNamePanel(boolean active) {
		this.active = active;
		setLayout(new BorderLayout());
		setOpaque(false);
		setPreferredSize(new Dimension(100,200));
		addPanels();
		validate();
	}

	private void addPanels() {
		add(currentPhaseLabel,BorderLayout.SOUTH);
		add(lifePointsLabel,BorderLayout.CENTER);
		add(playerNameLabel, BorderLayout.NORTH);
		lifePointsLabel.setPreferredSize(new Dimension(30,35));
		lifePointsLabel.setFont(new Font("Cambria",Font.ITALIC,20));
		lifePointsLabel.setForeground(Color.ORANGE);
		playerNameLabel.setPreferredSize(new Dimension(30,35));
		playerNameLabel.setFont(new Font("Cambria",Font.ITALIC,20));
		playerNameLabel.setForeground(Color.ORANGE);
		currentPhaseLabel.setPreferredSize(new Dimension(30,35));
		currentPhaseLabel.setFont(new Font("Cambria",Font.ITALIC,20));
		currentPhaseLabel.setForeground(Color.ORANGE);
		updateAll();
	}

	public JLabel getplayerNameLabel() {
		return playerNameLabel;
	}


	public JLabel getlifePointsLabel() {
		return lifePointsLabel;
	}


	public JLabel getCurrentPhaseLabel() {
		return currentPhaseLabel;
	}
	
	public void updateAll(){
		updatePhase();
		updatePlayerName();
		updateLifePoints();
	}
	
	public void updatePhase(){
		Phase current = Card.getBoard().getActivePlayer().getField().getPhase();
		if(current.equals(Phase.MAIN1))
			currentPhaseLabel.setText("Main 1");
		if(current.equals(Phase.MAIN2))
			currentPhaseLabel.setText("Main 2");
		if(current.equals(Phase.BATTLE))
			currentPhaseLabel.setText("Battle");
		if(!active){
			currentPhaseLabel.setText("Inactive");
		}
	}
	
	public void updatePlayerName(){
		if(active)
		playerNameLabel.setText(Card.getBoard().getActivePlayer().getName());
		else playerNameLabel.setText(Card.getBoard().getOpponentPlayer().getName());
	}
	
	public void updateLifePoints(){
		if(active)
			lifePointsLabel.setText(""+Card.getBoard().getActivePlayer().getLifePoints());
		else lifePointsLabel.setText(""+Card.getBoard().getOpponentPlayer().getLifePoints());
	}
}