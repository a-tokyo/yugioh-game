package eg.edu.guc.yugioh.board.player;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.IllegalSpellTargetException;

public interface Duelist {

	public boolean summonMonster(MonsterCard monster);
	 
	public boolean summonMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices);
	 
	public boolean setMonster(MonsterCard monster);

	public boolean setMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices);
	 
	public boolean setSpell(SpellCard spell) throws IllegalSpellTargetException;
	 
	public boolean activateSpell(SpellCard spell, MonsterCard monster) throws IllegalSpellTargetException;

	public boolean declareAttack(MonsterCard monster);
	 
	public boolean declareAttack(MonsterCard activeMonster, MonsterCard opponentMonster);
	 
	public void addCardToHand();
	 
	public void addNCardsToHand(int n);
	 
	public void endPhase();
	 
	public boolean endTurn();
	 
	public boolean switchMonsterMode(MonsterCard monster);
}
