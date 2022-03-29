package src.yugioh.gui.otherframes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.yugioh.cards.Card;
import src.yugioh.gui.GUI;
import src.yugioh.gui.Main;

@SuppressWarnings("serial")
public class WinnerFrame extends JFrame implements ActionListener{
	JLabel winner = new JLabel();
	JButton replayButton = new JButton("Replay");
	JButton exitGameButton = new JButton("Exit Game");
	
	public WinnerFrame(){
		super("Winner!");
		GUI.getBoardFrame().dispose();
		winner.setText(" Congratulations "+Card.getBoard().getWinner().getName()+", You won!");
		winner.setFont(new Font(winner.getFont().getName(),Font.PLAIN,18));
		setSize(350, 120);
		setLayout(new GridBagLayout());
		setVisible(true);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		replayButton.addActionListener(this);
		exitGameButton.addActionListener(this);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridwidth = 2;
		add(winner , c);
		c.insets.top = 15;
		c.insets.left = 30;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.gridy = 1;
		add(replayButton , c);
		c.gridx = 1;
		add(exitGameButton , c);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Replay")){
		GUI.getWinnerFrame().dispose();
		Main.startNewGame();
		}else
		if(arg0.getActionCommand().equals("Exit Game"))
			System.exit(0);
	}
}
