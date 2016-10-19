package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {

	public NoSpellSpaceException() {
		super("Spells Area is full.");
	}

	public NoSpellSpaceException(String arg0) {
		super(arg0);
	}

}
