package src.yugioh.cards.spells;

import java.util.ArrayList;
import java.util.Random;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {

	public GracefulDice(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		Random r = new Random();
		int increase = 100 * (r.nextInt(10) + 1);

		ArrayList<MonsterCard> monsters = Card.getBoard().getActivePlayer()
				.getField().getMonstersArea();
		for (int i = 0; i < monsters.size(); i++) {

			monsters.get(i).setAttackPoints(
					monsters.get(i).getAttackPoints() + increase);
			monsters.get(i).setDefensePoints(
					monsters.get(i).getDefensePoints() + increase);

		}

	}

}
