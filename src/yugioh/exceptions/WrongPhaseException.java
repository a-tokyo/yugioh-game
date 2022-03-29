package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException {

	public WrongPhaseException() {
		super("This action is illegal in this phase.");
	}

	public WrongPhaseException(String message) {
		super(message);
	}

}
