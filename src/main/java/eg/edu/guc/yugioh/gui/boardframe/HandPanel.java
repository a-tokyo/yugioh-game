package eg.edu.guc.yugioh.gui.boardframe;

import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.*;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class HandPanel extends JPanel {
	private ArrayList<CardButton> handList ;
	private ArrayList<Card> hand;
	private boolean active;

	public HandPanel(boolean active) {
		this.active = active;
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1300,CardButton.getDimension('H')));
		setOpaque(false);
		updateHand();
		validate();
	}

	public void updateHand() {
		removeAll();
		handList = new ArrayList<CardButton>();
		if(active){
			hand = Card.getBoard().getActivePlayer().getField().getHand();
			for(int i =0; i< hand.size(); i++){
				if(hand.get(i) instanceof MonsterCard){
					handList.add(new MonsterButton((MonsterCard)hand.get(i)));
				}
				if(hand.get(i) instanceof SpellCard){
					handList.add(new SpellButton((SpellCard)hand.get(i)));
				}
			add(handList.get(i));
			}
		}
		else {
			hand = Card.getBoard().getOpponentPlayer().getField().getHand();
			for(int i =0; i< hand.size(); i++){
				handList.add(new MonsterButton());
				add(handList.get(i));
			}
		}
	}
}