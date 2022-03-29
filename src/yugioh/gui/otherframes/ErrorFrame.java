package src.yugioh.gui.otherframes;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ErrorFrame extends JFrame {
	
	public ErrorFrame(String error) throws IOException{
	super(error);
	setSize(700,180);
	setVisible(true);
	setResizable(false);
	getContentPane().setBackground(Color.WHITE);
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	getContentPane().setLayout(new GridLayout(1,3));
// Error (X) Image
	BufferedImage XPicture = ImageIO.read(new File("images/Icon_Simple_Error.png"));
	JLabel XLabel = new JLabel(new ImageIcon(XPicture));
	add(XLabel);
//	Error
	JLabel ErrorMsg = new JLabel(error);
	add(ErrorMsg);
//	Kaiba
	BufferedImage kaiba = ImageIO.read(new File("images/kaiba.png"));
	JLabel KaibaLabel = new JLabel(new ImageIcon(kaiba));
	XLabel.setVisible(true);
	KaibaLabel.setVisible(true);
	add(KaibaLabel);
	this.validate();	
	}
}