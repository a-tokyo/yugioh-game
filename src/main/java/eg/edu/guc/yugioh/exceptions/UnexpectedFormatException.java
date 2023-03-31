package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnexpectedFormatException extends Exception {

	String sourceFile;
	int sourceLine;
	
	
	
	public UnexpectedFormatException() {
	}

	public UnexpectedFormatException(String arg0) {
		super(arg0);
	}
	
	public UnexpectedFormatException(String sFile, int sLine) {
		this.sourceFile = sFile;
		this.sourceLine = sLine;
	}
	
	public UnexpectedFormatException(String message, String sFile, int sLine) {
		super(message);
		this.sourceFile = sFile;
		this.sourceLine = sLine;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	public int getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(int sourceLine) {
		this.sourceLine = sourceLine;
	}

}
