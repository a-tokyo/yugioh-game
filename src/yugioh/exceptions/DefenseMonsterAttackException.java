package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException {

	public DefenseMonsterAttackException() {
		super("Defence monsters can't attack.");
	}

	public DefenseMonsterAttackException(String message) {
		super(message);
	}
	
}
