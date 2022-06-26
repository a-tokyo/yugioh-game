package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException {

	public MultipleMonsterAdditionException() {
		super("Mutiplas invocações é ilegal.");
	}

	public MultipleMonsterAdditionException(String message) {
		super(message);
	}

}
