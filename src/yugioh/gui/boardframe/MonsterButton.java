package src.yugioh.gui.boardframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import src.yugioh.board.player.Phase;
import src.yugioh.cards.Card;
import src.yugioh.cards.Location;
import src.yugioh.cards.MonsterCard;
import src.yugioh.exceptions.IllegalSpellTargetException;
import src.yugioh.exceptions.WrongPhaseException;
import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class MonsterButton extends CardButton implements ActionListener{

	private MonsterCard monster;
	public MonsterButton() {
		super(Attack);
		addActionListener(null);
	}

	public MonsterButton(MonsterCard monster) {
		super(Attack);
		ImageIcon icon = new ImageIcon("images/"+monster.getName()+".jpg");
		if(icon!=null){
			setIcon(icon);
		}
		this.monster = monster;
		setToolTipText(monster.getName()+"\n ATK: "+monster.getAttackPoints()+"\n DEF: "+monster.getDefensePoints()+"\n Level: "+monster.getLevel());
		addActionListener(this);
		validate();
	}

	public void toDefence(){
		setIcon(Defence);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(monster.getLocation() == Location.FIELD){
			if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.BATTLE){
				battlePhaseActions();
				return;
			}else{
				if(GUI.getBoardFrame().isToSwitch()){
					switchMonsterModeAction();
				}
			}
			if(GUI.getBoardFrame().getMonsterToSummon()!=null){
				sacrificesAction();
			}
			if(GUI.getBoardFrame().getSpellToActivate() != null){
				spellActivationWithTargetAction();
			}
			GUI.getBoardFrame().updateBoardFrame();
		}
		if(monster.getLocation()==Location.HAND && Card.getBoard().getActivePlayer().getField().getHand().contains(monster)){ // condition added
			new HandOptionsFrame(true,monster);
		}
	}

	private void switchMonsterModeAction() {
		Card.getBoard().getActivePlayer().switchMonsterMode(monster);
		GUI.getBoardFrame().setToSwitch(false);
	}

	private void spellActivationWithTargetAction() {
		try{
			Card.getBoard().getActivePlayer().activateSpell(GUI.getBoardFrame().getSpellToActivate(), monster);
			GUI.getBoardFrame().setSpellToActivate(null);
		}catch(IllegalSpellTargetException e){
			GUI.errorFrame(e);
		}
	}

	private void sacrificesAction() {
		if(GUI.getBoardFrame().getSacrificesCount() >0){
			if(!GUI.getBoardFrame().getSacrificedMonsters().contains(monster)){
				GUI.getBoardFrame().getSacrificedMonsters().add(monster);
				GUI.getBoardFrame().decrementSacrificesCount();
			} // bug needed brackets 
		}

		if(GUI.getBoardFrame().getSacrificesCount() == 0){
			try{
				if(GUI.getBoardFrame().isSacrificeAttack())
					Card.getBoard().getActivePlayer().summonMonster(GUI.getBoardFrame().getMonsterToSummon(),GUI.getBoardFrame().getSacrificedMonsters());
				else 
					Card.getBoard().getActivePlayer().setMonster(GUI.getBoardFrame().getMonsterToSummon(),GUI.getBoardFrame().getSacrificedMonsters());
				GUI.getBoardFrame().setMonsterToSummon(null);
			}catch(Exception e){
				GUI.errorFrame(e);
			}
			finally{ // added the finally
				GUI.getBoardFrame().setSacrificedMonsters(new ArrayList<MonsterCard>());
			}
		}
	}

	private void battlePhaseActions() {
		//bug start fix
		if(GUI.getBoardFrame().getSpellToActivate()!=null){
			GUI.getBoardFrame().setSpellToActivate(null);
			GUI.errorFrame(new WrongPhaseException());
		}
		//bug end fix
		if(GUI.getBoardFrame().getAttackingMonster()!=null){
			Card.getBoard().getActivePlayer().declareAttack(GUI.getBoardFrame().getAttackingMonster(), monster);
			GUI.getBoardFrame().setAttackingMonster(null);
		}
		else{
			try{
				if(!Card.getBoard().getActivePlayer().declareAttack(monster) ){ // attacks life if possible
					if(Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(monster)){
					new ConfirmFrame("Por favor, escolha um monstro para atacar");
					GUI.getBoardFrame().setAttackingMonster(monster);
					}
				}
			}catch(Exception e){
				GUI.getBoardFrame().resetHandlers();
				GUI.errorFrame(e);
			}
		}
		GUI.getBoardFrame().updateBoardFrame();
	}
}