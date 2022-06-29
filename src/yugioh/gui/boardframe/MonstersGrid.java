package src.yugioh.gui.boardframe;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import src.yugioh.cards.Card;
import src.yugioh.cards.Mode;
import src.yugioh.cards.MonsterCard;

@SuppressWarnings("serial")
public class MonstersGrid extends JPanel {
	private MonsterButton [] monsterButtons;
	private ArrayList<MonsterCard> monstersArea= new ArrayList<MonsterCard>();
	private boolean active;
	public MonstersGrid(boolean active) {
		setLayout(new GridLayout(1, 5));
		monsterButtons = new MonsterButton [5]; 
		this.active=active;
			for(int i = 0; i<5 ; i++){
			monsterButtons[i]= new MonsterButton();
			add(monsterButtons[i]);     
		}

		setPreferredSize(new Dimension(475,150));
		validate();
	}
	
	public void updateMonstersArea() {
		removeAll();
		if(active){
			monstersArea = Card.getBoard().getActivePlayer().getField().getMonstersArea();
		}else{
			monstersArea = Card.getBoard().getOpponentPlayer().getField().getMonstersArea();
		}
		for (int i = 0; i < 5; i++) {
			if(i<monstersArea.size()){
				MonsterCard addedMonster = monstersArea.get(i);
				monsterButtons[i] = new MonsterButton(addedMonster);
				if(addedMonster.getMode()==Mode.DEFENSE)
					monsterButtons[i].toDefence();
				if(addedMonster.isHidden() && !active)
					monsterButtons[i].setToolTipText(null);
				add(monsterButtons[i]);
			}
			else add(new MonsterButton());
		}
		repaint();
		validate();
	}
	
	public MonsterButton[] getMonsterButtons() {
		return monsterButtons;
	}
	public void setMonsterButtons(MonsterButton[] monsterButtons) {
		this.monsterButtons = monsterButtons;
	}
}