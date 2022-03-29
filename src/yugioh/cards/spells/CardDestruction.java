package src.yugioh.cards.spells;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {

	public CardDestruction(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard m) {

		int discardedCards = Card.getBoard().getActivePlayer().getField()
				.discardHand();
		Card.getBoard().getActivePlayer().addNCardsToHand(discardedCards);

		discardedCards = Card.getBoard().getOpponentPlayer().getField()
				.discardHand();
		Card.getBoard().getOpponentPlayer().addNCardsToHand(discardedCards);

	}

}
