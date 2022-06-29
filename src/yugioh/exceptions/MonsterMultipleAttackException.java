package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {

	public MonsterMultipleAttackException() {
		super("Apenas um ataque por monstro.");
	}

	public MonsterMultipleAttackException(String message) {
		super(message);
	}

}
