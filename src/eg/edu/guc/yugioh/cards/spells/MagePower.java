package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.IllegalSpellTargetException;

public class MagePower extends SpellCard {

	public MagePower(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) throws IllegalSpellTargetException {
		if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().contains(monster))
			throw new IllegalSpellTargetException();
		
		int spellCardsCount = CardDestruction.getBoard().getActivePlayer()
				.getField().getSpellArea().size();
		
		monster.setAttackPoints(monster.getAttackPoints()
				+ (500 * spellCardsCount));
		
		monster.setDefensePoints(monster.getDefensePoints()
				+ (500 * spellCardsCount));

	}

}
