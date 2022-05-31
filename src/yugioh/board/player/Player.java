package src.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import src.yugioh.cards.Card;
import src.yugioh.cards.Mode;
import src.yugioh.cards.MonsterCard;
import src.yugioh.cards.spells.SpellCard;
import src.yugioh.exceptions.IllegalSpellTargetException;
import src.yugioh.exceptions.MultipleMonsterAdditionException;
import src.yugioh.exceptions.UnexpectedFormatException;

public class Player implements Duelist {

	private final String name;
	private int lifePoints;
	public Field field;
	private boolean addedMonsterThisTurn;

	public Player(String name) throws IOException, UnexpectedFormatException {

		this.name = name;
		this.lifePoints = 4000;
		this.field = new Field();
		addedMonsterThisTurn = false;

	}

	@Override
	public boolean summonMonster(MonsterCard monster) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		if (addedMonsterThisTurn)
			throw new MultipleMonsterAdditionException();

		boolean monsterAdded = this.field.addMonsterToField(monster,
				Mode.ATTACK, false);

		if (!monsterAdded)
			return false;

		addedMonsterThisTurn = true;

		return true;

	}

	@Override
	public boolean summonMonster(MonsterCard monster,
			ArrayList<MonsterCard> sacrifices) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		if (addedMonsterThisTurn)
			throw new MultipleMonsterAdditionException();

		boolean monsterAdded = this.field.addMonsterToField(monster,
				Mode.ATTACK, sacrifices);

		if (!monsterAdded)
			return false;

		addedMonsterThisTurn = true;

		return true;

	}

	@Override
	public boolean setMonster(MonsterCard monster) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		if (addedMonsterThisTurn)
			throw new MultipleMonsterAdditionException();

		boolean monsterAdded = this.field.addMonsterToField(monster,
				Mode.DEFENSE, true);

		if (!monsterAdded)
			return false;

		addedMonsterThisTurn = true;

		return true;

	}

	@Override
	public boolean setMonster(MonsterCard monster,
			ArrayList<MonsterCard> sacrifices) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		if (addedMonsterThisTurn)
			throw new MultipleMonsterAdditionException();

		boolean monsterAdded = this.field.addMonsterToField(monster,
				Mode.DEFENSE, sacrifices);

		if (!monsterAdded)
			return false;

		addedMonsterThisTurn = true;

		return true;

	}

	@Override
	public boolean setSpell(SpellCard spell) throws IllegalSpellTargetException {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		boolean spellAdded = this.field.addSpellToField(spell, null, true);

		return spellAdded;

	}

	@Override
	public boolean activateSpell(SpellCard spell, MonsterCard monster) throws IllegalSpellTargetException {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		boolean spellActivated;

		if (this.field.getSpellArea().contains(spell))
			spellActivated = this.field.activateSetSpell(spell, monster);
		else
			spellActivated = this.field.addSpellToField(spell, monster, false);

		return spellActivated;

	}

	@Override
	public boolean declareAttack(MonsterCard monster) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		boolean monsterAttacked = this.field.declareAttack(monster, null);

		return monsterAttacked;

	}

	@Override
	public boolean declareAttack(MonsterCard activeMonster,
			MonsterCard opponentMonster) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		boolean monsterAttacked = this.field.declareAttack(activeMonster,
				opponentMonster);

		return monsterAttacked;

	}

	@Override
	public void endPhase() {

		if (Card.getBoard().isGameOver())
			return;

		if (this != Card.getBoard().getActivePlayer())
			return;

		this.getField().endPhase();

	}

	@Override
	public boolean endTurn() {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		addedMonsterThisTurn = false;
		this.getField().endTurn();

		return true;

	}

	@Override
	public boolean switchMonsterMode(MonsterCard monster) {

		if (Card.getBoard().isGameOver())
			return false;

		if (this != Card.getBoard().getActivePlayer())
			return false;

		boolean monsterSwitched = this.field.switchMonsterMode(monster);

		return monsterSwitched;

	}

//	@Override
//	public void addCardToHand() {
//
//		this.field.addNCardsToHand(1);
//
//	}

//	@Override
//	public void addNCardsToHand(int n) {
//
//		this.field.addNCardsToHand(n);
//
//	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	public Field getField() {
		return field;
	}

}
