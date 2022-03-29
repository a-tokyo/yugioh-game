package src.yugioh.cards.spells;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;
import src.yugioh.exceptions.IllegalSpellTargetException;

public class ChangeOfHeart extends SpellCard {

	public ChangeOfHeart(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) throws IllegalSpellTargetException {

		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(monster))
			throw new IllegalSpellTargetException();
		Card.getBoard().getOpponentPlayer().getField().getMonstersArea()
				.remove(monster);

		monster.setHidden(false);

		Card.getBoard().getActivePlayer().getField().getMonstersArea()
				.add(monster);

	}

}
