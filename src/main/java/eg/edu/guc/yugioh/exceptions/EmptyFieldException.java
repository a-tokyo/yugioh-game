package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends UnexpectedFormatException {

	int sourceField;
	
	public EmptyFieldException() {
	}

	public EmptyFieldException(String arg0) {
		super(arg0);
	}

	public EmptyFieldException(String sFile, int sLine, int sField) {
		super(sFile, sLine);
		this.sourceField = sField;
	}

	public EmptyFieldException(String message, String sFile, int sLine, int sField) {
		super(message, sFile, sLine);
		this.sourceField = sField;
	}

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}

}
