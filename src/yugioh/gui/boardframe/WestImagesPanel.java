package src.yugioh.gui.boardframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WestImagesPanel extends JPanel {
	private JLabel activeImage = new JLabel(new ImageIcon("images/YugiDuel.jpg"));
	private JLabel opponentImage = new JLabel(new ImageIcon("images/KaibaDuel.jpg"));
	Dimension dimension = new Dimension(300,760-15-new CardButton().getPreferredSize().height);
	boolean swapped = false;
	
	public WestImagesPanel() {
		setLayout(new BorderLayout());
		activeImage.setPreferredSize(new Dimension(dimension.width,dimension.height/2-7));
		opponentImage.setPreferredSize(new Dimension(dimension.width,dimension.height/2-17));
		setOpaque(false);
		JPanel separator = new JPanel();
		separator.setOpaque(false);
		separator.setPreferredSize(new Dimension(300,5));
		add(activeImage,BorderLayout.SOUTH);
		add(separator,BorderLayout.CENTER);
		add(opponentImage,BorderLayout.NORTH);
		setPreferredSize(dimension); // add 5 
		validate();
	}
	
	public void swap(){
		remove(activeImage);
		remove(opponentImage);
		if(!swapped){
			add(activeImage , BorderLayout.NORTH);
			add(opponentImage , BorderLayout.SOUTH);
			swapped = true;}
		else{
			add(activeImage,BorderLayout.SOUTH);
			add(opponentImage,BorderLayout.NORTH);
			swapped = false;
		}
	}
}