package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {

	public NoSpellSpaceException() {
		super("A área de feitiços está cheia.");
	}

	public NoSpellSpaceException(String arg0) {
		super(arg0);
	}

}
