package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerAreaPanel extends JPanel {
	private MonstersSpellsPanel monsterSpellPanel;
	private DeckGraveyard deckGraveyardPanel;
	private PlayerNamePanel playerNamePanel;
	
	public PlayerAreaPanel(boolean ao){
		super();
		setOpaque(false);
		monsterSpellPanel = new MonstersSpellsPanel(ao);
		deckGraveyardPanel = new DeckGraveyard(ao);
		playerNamePanel = new PlayerNamePanel(ao);
		add(playerNamePanel, BorderLayout.WEST);
		add(monsterSpellPanel,BorderLayout.CENTER);
		add(deckGraveyardPanel,BorderLayout.EAST);
		setPreferredSize(new Dimension(900,320));
		validate();
		
	}
	
	public MonstersSpellsPanel getMonsterSpellPanel() {
		return monsterSpellPanel;
	}
	public void setMonsterSpellPanel(MonstersSpellsPanel monsterSpellPanel) {
		this.monsterSpellPanel = monsterSpellPanel;
	}
	public DeckGraveyard getDeckGraveyardPanel() {
		return deckGraveyardPanel;
	}
	public void setDeckGraveyardPanel(DeckGraveyard deckGraveyardPanel) {
		this.deckGraveyardPanel = deckGraveyardPanel;
	}
	public PlayerNamePanel getPlayerNamePanel() {
		return playerNamePanel;
	}
	public void setPlayerNamePanel(PlayerNamePanel playerNamePanel) {
		this.playerNamePanel = playerNamePanel;
	}
}