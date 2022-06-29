package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {

	public NoMonsterSpaceException() {
		super("A Área de Monstros está cheia.");
	}

	public NoMonsterSpaceException(String arg0) {
		super(arg0);
	}

}
