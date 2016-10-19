package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class IllegalSpellTargetException extends Exception {

	public IllegalSpellTargetException(){
		super("Illegal Spell Target");
	}
}
