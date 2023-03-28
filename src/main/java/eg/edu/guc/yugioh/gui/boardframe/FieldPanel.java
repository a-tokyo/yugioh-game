package eg.edu.guc.yugioh.gui.boardframe;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {
	private PlayerAreaPanel activePlayerPanel;
	private PlayerAreaPanel opponentPlayerPanel;
	
	public FieldPanel(){
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700,700));
		activePlayerPanel = new PlayerAreaPanel(true);  
		opponentPlayerPanel = new PlayerAreaPanel(false); 
		setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		add(opponentPlayerPanel,c);
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridy=1;
		add(activePlayerPanel , c);
		validate();
	}
	
	public PlayerAreaPanel getActivePlayerPanel() {
		return activePlayerPanel;
	}

	public void setActivePlayerPanel(PlayerAreaPanel activePlayerPanel) {
		this.activePlayerPanel = activePlayerPanel;
	}

	public PlayerAreaPanel getOpponentPlayerPanel() {
		return opponentPlayerPanel;
	}

	public void setOpponentPlayerPanel(PlayerAreaPanel opponentPlayerPanel) {
		this.opponentPlayerPanel = opponentPlayerPanel;
	}
}