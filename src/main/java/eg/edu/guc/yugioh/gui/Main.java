/**
 * @author Tokyo
 */
package eg.edu.guc.yugioh.gui;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.configsGlobais.Logger;

public class Main {
	@SuppressWarnings("unused")

	public static void startNewGame(){

		Logger.startLogs().info("Main - startNewGame");

		Board b = new Board();
		GUI g = new GUI();
	}
	
	public static void main(String[] args) {
		startNewGame();
	}
}