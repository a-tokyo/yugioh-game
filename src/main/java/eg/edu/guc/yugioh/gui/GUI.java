package eg.edu.guc.yugioh.gui;

import java.io.IOException;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.boardframe.*;
import eg.edu.guc.yugioh.gui.otherframes.*;

public class GUI {
	private static PlayersFrame playerFrame;
	private static WinnerFrame winnerFrame;
	private static BoardFrame boardFrame;
	
	public GUI(){
		GUI.playerFrame = new PlayersFrame();
	}
	
	public static void errorFrame(Exception e){
		if(Card.getBoard().isGameOver()) // bug fix
			return;
		try {
			new ErrorFrame(e.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
	}
	
	public static WinnerFrame getWinnerFrame() {
		return winnerFrame;
	}

	public static void setWinnerFrame(WinnerFrame winnerFrame) {
		GUI.winnerFrame = winnerFrame;
	}

	public static PlayersFrame getPlayerFrame() {
		return playerFrame;
	}
	public static void setPlayerFrame(PlayersFrame player) {
		GUI.playerFrame = player;
	}

	public static BoardFrame getBoardFrame() {
		return boardFrame;
	}

	public static void setBoardFrame(BoardFrame boardFrame) {
		GUI.boardFrame = boardFrame;
	}
}