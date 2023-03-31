package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnknownCardTypeException extends UnexpectedFormatException {

	String unknownType;

	public UnknownCardTypeException() {
	}

	public UnknownCardTypeException(String arg0) {
		super(arg0);
	}

	public UnknownCardTypeException(String sFile, int sLine, String type) {
		super(sFile, sLine);
		this.unknownType = type;
	}

	public UnknownCardTypeException(String message, String sFile, int sLine,
			String type) {
		super(message, sFile, sLine);
		this.unknownType = type;
	}

	public String getUnknownType() {
		return unknownType;
	}

}
