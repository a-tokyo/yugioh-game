package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {

	public NoMonsterSpaceException() {
		super("Monsters Area is full.");
	}

	public NoMonsterSpaceException(String arg0) {
		super(arg0);
	}

}
