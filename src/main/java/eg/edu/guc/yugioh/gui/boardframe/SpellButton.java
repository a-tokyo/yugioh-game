package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class SpellButton extends CardButton implements ActionListener{	
	private SpellCard spell;

	public SpellButton() {
		super(spellIcon);
	}

	public SpellButton(SpellCard spell) {
		super(new ImageIcon("images/"+spell.getName()+".png"));
		this.spell = spell;
		String spellInfo = String.format("<html><div style=%s>%s<br>%s</div></html>", "width:50%;", spell.getName(), spell.getDescription());
		setToolTipText(spellInfo);
		//setToolTipText("<html>"+spell.getName()+"<br>"+spell.getDescription()+"</html>");
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
			new ConfirmFrame("Please Choose a monster to Activate spell on");
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