package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EastButtonsPanel extends JPanel {
	private NextPhaseButton nextPhaseButton = new NextPhaseButton();
	private EndTurnButton endTurnButton = new EndTurnButton();
	private SwitchMonsterModeButton switchMonsterModeButton= new SwitchMonsterModeButton();
	public EastButtonsPanel(){
		setLayout(new GridBagLayout());
		setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		c.insets.bottom = 20;
		c.insets.left = 25;
		add(switchMonsterModeButton, c);
		c.gridy = 1;
		add(nextPhaseButton, c);
		c.gridy =2;
		add(endTurnButton, c);
		validate();
	}
	
	
	public NextPhaseButton getNextPhaseButton() {
		return nextPhaseButton;
	}
	public void setNextPhaseButton(NextPhaseButton nextPhaseButton) {
		this.nextPhaseButton = nextPhaseButton;
	}
	public EndTurnButton getEndTurnButton() {
		return endTurnButton;
	}
	public void setEndTurnButton(EndTurnButton endTurnButton) {
		this.endTurnButton = endTurnButton;
	}
	public SwitchMonsterModeButton getSwitchMonsterModeButton() {
		return switchMonsterModeButton;
	}
	public void setSwitchMonsterModeButton(
			SwitchMonsterModeButton switchMonsterModeButton) {
		this.switchMonsterModeButton = switchMonsterModeButton;
	}
}