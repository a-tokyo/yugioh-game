package src.yugioh.cards.spells;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;

public class PotOfGreed extends SpellCard {

	public PotOfGreed(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		Card.getBoard().getActivePlayer().addNCardsToHand(2);

	}

}
