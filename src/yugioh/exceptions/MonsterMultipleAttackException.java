package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {

	public MonsterMultipleAttackException() {
		super("Atacar duas vezes com o mesmo monstro é ilegal.");
	}

	public MonsterMultipleAttackException(String message) {
		super(message);
	}

}
