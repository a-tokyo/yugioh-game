package src.yugioh.gui.boardframe;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CardButton extends JButton {
	protected static ImageIcon Attack = new ImageIcon("images/AttackMode.png");
	protected static ImageIcon Defence = new ImageIcon("images/DefenceMode.png");
	protected static ImageIcon spellIcon = new ImageIcon("images/SpellTrapCardZone.png");
	private static int height=155;
	private static int width = 95;
	
	public CardButton() {
		super();
		construct();
	}

	public CardButton(Icon arg0) {
		super(arg0);
		construct();
	}

	public CardButton(String arg0) {
		super(arg0);
		construct();
	}

	public CardButton(Action arg0) {
		super(arg0);
		construct();
	}

	public CardButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		construct();
	}
	
	private void construct(){
		setPreferredSize(new Dimension(width,height));
		setBackground(Color.GRAY);
		validate();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public static int getDimension(char WorH) {
		if(WorH=='w'||WorH=='W')
		return width;
		if(WorH=='h'||WorH=='H')
			return height;
		return 0;
	}
}