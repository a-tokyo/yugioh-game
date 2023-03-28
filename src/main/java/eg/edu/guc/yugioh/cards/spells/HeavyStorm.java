package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

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
