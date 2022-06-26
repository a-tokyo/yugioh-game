package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException {

	public WrongPhaseException() {
		super("Esta ação é ilegal na fase atual.");
	}

	public WrongPhaseException(String message) {
		super(message);
	}

}
