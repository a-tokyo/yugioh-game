package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {

	public DarkHole(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		super.action(monster);

		ArrayList<MonsterCard> monsters = Card.getBoard().getActivePlayer()
				.getField().getMonstersArea();

		Card.getBoard().getActivePlayer().getField()
				.removeMonsterToGraveyard(new ArrayList<MonsterCard>(monsters));

	}

}
