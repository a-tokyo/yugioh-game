package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

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
