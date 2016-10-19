package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.exceptions.IllegalSpellTargetException;

public abstract class Card {

	private final String name;
	private String description;
	private boolean isHidden;
	private Location location;
	private static Board board;

	public Card(String name, String desc) {

		this.name = name;
		this.description = desc;
		this.isHidden = true;

	}

	public Card(String name, String desc, boolean hidden, Location loc) {

		this.name = name;
		this.description = desc;
		this.isHidden = hidden;
		this.location = loc;

	}

	public abstract void action(MonsterCard monster) throws IllegalSpellTargetException;

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		Card.board = board;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {

		return description;

	}

}
