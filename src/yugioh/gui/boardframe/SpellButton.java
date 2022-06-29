package src.yugioh.gui.boardframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import src.yugioh.cards.Card;
import src.yugioh.cards.Location;
import src.yugioh.cards.spells.ChangeOfHeart;
import src.yugioh.cards.spells.MagePower;
import src.yugioh.cards.spells.SpellCard;
import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class SpellButton extends CardButton implements ActionListener{	
	private SpellCard spell;

	public SpellButton() {
		super(spellIcon);
	}

	public SpellButton(SpellCard spell) {
		super(new ImageIcon("images/"+spell.getName()+".png"));
		this.spell = spell;
		setToolTipText(spell.getName()+"\n"+spell.getDescription());
		setVisible(true);
		addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(spell.getLocation()==Location.HAND)
			new HandOptionsFrame(false,spell);
		else 
		if(spell.getLocation()==Location.FIELD)
			spellInFieldAction();	
	}

	private void spellInFieldAction() {
		if((spell instanceof ChangeOfHeart || spell instanceof MagePower)){
			GUI.getBoardFrame().setSpellToActivate(spell);
			new ConfirmFrame("Por favor, escolha um monstro para ativar o feitiço");
		}else{
			try {
				Card.getBoard().getActivePlayer().activateSpell(spell, null);
			} catch (Exception e2) {
				GUI.errorFrame(e2);
			}
		}
		GUI.getBoardFrame().updateBoardFrame();
	}
}