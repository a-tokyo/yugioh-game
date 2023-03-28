package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class PotOfGreed extends SpellCard {

	public PotOfGreed(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		Card.getBoard().getActivePlayer().addNCardsToHand(2);

	}

}
