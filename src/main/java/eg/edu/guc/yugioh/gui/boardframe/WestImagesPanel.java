package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import eg.edu.guc.yugioh.gui.otherframes.PlayerSwitch;

@SuppressWarnings("serial")
public class WestImagesPanel extends JPanel {
	private JLabel activeImage = new JLabel(new ImageIcon("images/YugiDuel.jpg"));
	private JLabel opponentImage = new JLabel(new ImageIcon("images/KaibaDuel.jpg"));
	private CountPhase CountPhase;
	Dimension dimension = new Dimension(200,760-15-new CardButton().getPreferredSize().height);
	boolean swapped = false;
	//PlayerSwitch ps = new PlayerSwitch();


	public WestImagesPanel() {
		setLayout(new BorderLayout());
		activeImage.setPreferredSize(new Dimension(dimension.width,dimension.height/2-20));
		opponentImage.setPreferredSize(new Dimension(dimension.width,dimension.height/2-30));
		CountPhase = new CountPhase(1);
		setOpaque(false);

		add(activeImage,BorderLayout.SOUTH);
		add(CountPhase,BorderLayout.CENTER);
		add(opponentImage,BorderLayout.NORTH);
		setPreferredSize(dimension); // add 5 
		validate();
	}
	
	public void swap(){
		//ps.askForSwitching();

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
	public CountPhase getCurrentCountPhase() {
		return CountPhase;
	}
}