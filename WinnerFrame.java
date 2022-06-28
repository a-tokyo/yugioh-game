//package src.yugioh.gui.otherframes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.text.html.ImageView;

//import javafx.scene.layout.BackgroundImage;
import src.yugioh.cards.Card;
import src.yugioh.gui.GUI;
import src.yugioh.gui.Main;

@SuppressWarnings("serial")
public class WinnerFrame extends JFrame implements ActionListener{
	JLabel winner = new JLabel();
	JButton replayButton = new JButton("NOVA BATALHA");
	JButton exitGameButton = new JButton("SAIR DO JOGO");
	
	public WinnerFrame(){
		super("CAMPEAO!"); //, new ImageIcon("images/WinnerIcon.jpg")
		//WinnerFrame.
		//new ImageIcon("images/WinnerIcon.jpg");
		setContentPane(new JLabel(new ImageIcon("images/images/WinnerIcon.jpg"))); //nao funcionou

		GUI.getBoardFrame().dispose();
		winner.setText(" FELICITAÇÕES "+Card.getBoard().getWinner().getName()+", VOCÊ GANHOU!");
		winner.setFont(new Font(winner.getFont().getName(),Font.PLAIN,18));
		//setSize(350, 120);
		setSize(1000, 476);
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
		if(arg0.getActionCommand().equals("NOVA BATALHA")){
		GUI.getWinnerFrame().dispose();
		Main.startNewGame();
		}else
		if(arg0.getActionCommand().equals("SAIR DO JOGO"))
			System.exit(0);
	}
}
