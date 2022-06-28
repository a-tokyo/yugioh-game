package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException {

	public DefenseMonsterAttackException() {
		super("Monstros em defesa não podem atacar.");
	}

	public DefenseMonsterAttackException(String message) {
		super(message);
	}
	
}
