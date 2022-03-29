package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {

	public MonsterMultipleAttackException() {
		super("Attacking twice with the same monster is illegal.");
	}

	public MonsterMultipleAttackException(String message) {
		super(message);
	}

}
