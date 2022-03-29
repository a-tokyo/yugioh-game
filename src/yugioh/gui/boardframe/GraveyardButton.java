package src.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;
@SuppressWarnings("serial")
public class GraveyardButton extends JButton {
	private static ImageIcon graveyard = new ImageIcon("images/Graveyard.png");
	private boolean active ;

	public GraveyardButton(boolean active) {
		super(graveyard);
		this.active=active;
		setPreferredSize(new Dimension(CardButton.getDimension('W'),150));
	}

	public void updateGraveyard(){
		ArrayList<Card> graveyardList ;
		if(active)
			graveyardList = Card.getBoard().getActivePlayer().getField().getGraveyard();
		else graveyardList = Card.getBoard().getOpponentPlayer().getField().getGraveyard();
		if(graveyardList.size()>0){
			Card current = graveyardList.get(graveyardList.size()-1);
			if(current instanceof MonsterCard){
				setIcon(new ImageIcon("images/"+current.getName()+".jpg"));
				setToolTipText(current.getName()+"\n ATK: "+((MonsterCard)current).getAttackPoints()+"\n DEF: "+((MonsterCard)current).getDefensePoints()+"\n Level: "+((MonsterCard)current).getLevel());
			}
			else{ setIcon(new ImageIcon("images/"+current.getName()+".png"));
			setToolTipText(current.getName());
			}
		}
		else setIcon(graveyard);
	}
}
