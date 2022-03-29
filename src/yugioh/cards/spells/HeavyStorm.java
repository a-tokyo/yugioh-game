package src.yugioh.cards.spells;

import java.util.ArrayList;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster {

	public HeavyStorm(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		super.action(monster);
		
		ArrayList<SpellCard> spells = Card.getBoard().getActivePlayer()
				.getField().getSpellArea();
		
		Card.getBoard().getActivePlayer().getField()
				.removeSpellToGraveyard(new ArrayList<SpellCard>(spells));

	}

}
