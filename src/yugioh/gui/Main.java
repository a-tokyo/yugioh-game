/**
 * @author Tokyo
 */
package src.yugioh.gui;

import src.yugioh.board.Board;

public class Main {
	@SuppressWarnings("unused")
	public static void startNewGame(){
		Board b = new Board();
		GUI g = new GUI();
	}
	
	public static void main(String[] args) {
		startNewGame();
	}
}