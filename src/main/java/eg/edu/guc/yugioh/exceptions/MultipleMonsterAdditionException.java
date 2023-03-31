package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException {

	public MultipleMonsterAdditionException() {
		super("Multiple monster addition is illegal.");
	}

	public MultipleMonsterAdditionException(String message) {
		super(message);
	}

}
