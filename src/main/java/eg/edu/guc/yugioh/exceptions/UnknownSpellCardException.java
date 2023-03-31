package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnknownSpellCardException extends UnexpectedFormatException {

	String unknownSpell;
	
	public UnknownSpellCardException() {
	}

	public UnknownSpellCardException(String arg0) {
		super(arg0);
	}

	public UnknownSpellCardException(String sFile, int sLine, String spell) {
		super(sFile, sLine);
		this.unknownSpell = spell;
	}

	public UnknownSpellCardException(String message, String sFile, int sLine, String spell) {
		super(message, sFile, sLine);
		this.unknownSpell = spell;
	}

	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}

}
