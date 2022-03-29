package src.yugioh.exceptions;

@SuppressWarnings("serial")
public class IllegalSpellTargetException extends Exception {

	public IllegalSpellTargetException(){
		super("Illegal Spell Target");
	}
}
