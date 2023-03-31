package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MissingFieldException extends UnexpectedFormatException {

	public MissingFieldException() {
	}

	public MissingFieldException(String arg0) {
		super(arg0);
	}

	public MissingFieldException(String sFile, int sLine) {
		super(sFile, sLine);
	}

	public MissingFieldException(String message, String sFile, int sLine) {
		super(message, sFile, sLine);
	}

}
