package src.yugioh.cards.spells;

import src.yugioh.cards.Card;
import src.yugioh.cards.Location;
import src.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {

	public MonsterReborn(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {

		MonsterCard activeStongest = Card.getBoard().getActivePlayer()
				.getField().strongestMonsterInGraveyard();
		MonsterCard opponentStongest = Card.getBoard().getOpponentPlayer()
				.getField().strongestMonsterInGraveyard();

		if (opponentStongest.getAttackPoints() < activeStongest
				.getAttackPoints()) {

			Card.getBoard().getActivePlayer().getField().getMonstersArea()
					.add(activeStongest);

			Card.getBoard().getActivePlayer().getField().getGraveyard()
					.remove(activeStongest);

			activeStongest.setLocation(Location.FIELD);

		} else {

			Card.getBoard().getActivePlayer().getField().getMonstersArea()
					.add(opponentStongest);

			Card.getBoard().getOpponentPlayer().getField().getGraveyard()
					.remove(opponentStongest);

			opponentStongest.setLocation(Location.FIELD);

		}

	}

}
