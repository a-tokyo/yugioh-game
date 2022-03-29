package src.yugioh.gui.otherframes;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.yugioh.board.player.Player;
import src.yugioh.cards.Card;
import src.yugioh.exceptions.UnexpectedFormatException;
import src.yugioh.gui.GUI;
import src.yugioh.gui.boardframe.BoardFrame;

@SuppressWarnings("serial")
public class PlayersFrame extends JFrame implements ActionListener{
	PlayersPanel player1Panel = new PlayersPanel("Player 1");
	PlayersPanel player2Panel = new PlayersPanel("Player 2");
	JButton playerButton = new JButton("Start Game");
	JLabel image = new JLabel(new ImageIcon("images/gameStart.jpg"));
	JPanel DataPanel = new JPanel();
	
	public PlayersFrame (){
		super("Players name");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1024,720);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerButton.addActionListener(this);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setContentPane(image);
		DataPanel.setOpaque(false);
		DataPanel.setSize(300, 100);
		DataPanel.setLocation(362,210);
		DataPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets.bottom = 5;
		DataPanel.add(player1Panel,c);
		c.gridy =1;
		DataPanel.add(player2Panel,c);
		c.gridy =2;
		c.insets.bottom=0;
		DataPanel.add(playerButton,c);
		add(DataPanel);
		validate();
	}
	
	public void actionPerformed(ActionEvent e) {
		String name1 = player1Panel.getNameField().getText();
		String name2 = player2Panel.getNameField().getText();
		Player p1=null,p2 = null;
		try {
			p1 = new Player(name1);
			p2 = new Player(name2);
			Card.getBoard().startGame(p1, p2);
			GUI.setBoardFrame(new BoardFrame());
		} catch (IOException | UnexpectedFormatException e1) {
			e1.printStackTrace();
		}finally{
			GUI.getPlayerFrame().dispose();
			}
	}

}

