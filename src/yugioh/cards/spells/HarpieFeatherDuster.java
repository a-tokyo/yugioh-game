package src.yugioh.cards.spells;

import java.util.ArrayList;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {

	public HarpieFeatherDuster(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		ArrayList<SpellCard> spells = Card.getBoard().getOpponentPlayer()
				.getField().getSpellArea();
		
		Card.getBoard().getOpponentPlayer().getField()
				.removeSpellToGraveyard(new ArrayList<SpellCard>(spells));

	}

}
