package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DeckGraveyard extends JPanel {
	private GraveyardButton graveyard;
	private DeckButton deck;

	public DeckGraveyard(boolean active){
		setLayout(new BorderLayout());
		graveyard = new GraveyardButton(active);
		deck = new DeckButton(active);
		if(!active){
			add(graveyard, BorderLayout.SOUTH);
			add(deck, BorderLayout.NORTH);
		}else{
			add(graveyard, BorderLayout.NORTH);
			add(deck, BorderLayout.SOUTH);
		}
		setPreferredSize(new Dimension(CardButton.getDimension('W'),300));
		validate();
	}

	public GraveyardButton getGraveyard() {
		return graveyard;
	}

	public void setGraveyard(GraveyardButton graveyard) {
		this.graveyard = graveyard;
	}

	public DeckButton getDeck() {
		return deck;
	}

	public void setDeck(DeckButton deck) {
		this.deck = deck;
	}
}