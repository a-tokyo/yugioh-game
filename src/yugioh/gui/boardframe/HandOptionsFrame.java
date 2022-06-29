package src.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import src.yugioh.cards.Card;
import src.yugioh.cards.MonsterCard;
import src.yugioh.cards.spells.ChangeOfHeart;
import src.yugioh.cards.spells.MagePower;
import src.yugioh.cards.spells.SpellCard;
import src.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class HandOptionsFrame extends JFrame implements ActionListener{

	JButton leftButton = new JButton ("Invocar Monstro");
	JButton rightButton = new JButton ("\n" + "Definir Monstro");
	JButton cancelButton = new JButton ("Cancelar");
	SpellCard spell;
	MonsterCard monster;
	public HandOptionsFrame(boolean isMonsterOptions , Card card){
		super("\n" + "Escolher ação");
		if(!isMonsterOptions){
			spell = (SpellCard)card;
			leftButton.setText("\n" + "Ativar Feitiço");
			rightButton.setText("Definir feitiço");
		}
		else
			monster = (MonsterCard)card;
		constructFrame();
	}

	private void constructFrame() {
		setVisible(true);
		setLayout(new GridBagLayout());
		setSize(300,150);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.insets.top = 10;
		c.insets.right = 5;
		c.gridy = 0;
		add(leftButton , c);
		c.gridx =1;
		c.insets.right = 0;
		c.ipadx = 25;
		add(rightButton , c);
		c.gridx = 0;
		c.ipadx = 0;
		c.gridy =1 ;
		c.gridwidth =2;
		add(cancelButton , c);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancelar")){
			GUI.getBoardFrame().resetHandlers();
		}else
			if(e.getActionCommand().equals("Ativar Feitiço")){
				activateSpellCard();
			}
			else
				if(e.getActionCommand().equals("Definir Feitiço")){
					try {
						Card.getBoard().getActivePlayer().setSpell(spell);
						GUI.getBoardFrame().setMonsterToSummon(null);
						GUI.getBoardFrame().setSpellToActivate(null);
					} catch (Exception e1) {
						GUI.errorFrame(e1);
					}
				}else
					monsterOptions(e);
		GUI.getBoardFrame().updateBoardFrame();
		dispose();
	}

	private void activateSpellCard() {
		if((spell instanceof ChangeOfHeart || spell instanceof MagePower)){
			new ConfirmFrame("Por favor, clique em um monstro para ativar");
			GUI.getBoardFrame().setSpellToActivate(spell);
			GUI.getBoardFrame().setMonsterToSummon(null);
		}else{
			try {
				Card.getBoard().getActivePlayer().activateSpell(spell, null);
				GUI.getBoardFrame().setMonsterToSummon(null);
				GUI.getBoardFrame().setSpellToActivate(null);
			} catch (Exception e) {
				GUI.errorFrame(e);
			}
		}
	}
	private void monsterOptions(ActionEvent e){
		try{
			if(e.getActionCommand().equals("Invocar Monstro")){
				if(monster.getLevel()<5){
					Card.getBoard().getActivePlayer().summonMonster(monster);
					GUI.getBoardFrame().setMonsterToSummon(null);
				}
				else {
					ritualSummon(true);
				}
				GUI.getBoardFrame().setSpellToActivate(null);
			}
			if(e.getActionCommand().equals("Definir Monstro")){
				if(monster.getLevel()<5){
					Card.getBoard().getActivePlayer().setMonster(monster);
					GUI.getBoardFrame().setMonsterToSummon(null);
				}else {
					ritualSummon(false);
				}
				GUI.getBoardFrame().setSpellToActivate(null);
			}
			
		}catch(Exception e1){
			GUI.errorFrame(e1);
		}
	}
	private void ritualSummon(boolean isAttackMode) {
		if(monster.getLevel()<7)
			GUI.getBoardFrame().setSacrificesCount(1);
		else 
			GUI.getBoardFrame().setSacrificesCount(2);
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()>=GUI.getBoardFrame().getSacrificesCount()){
			new ConfirmFrame("Por favor clique "+GUI.getBoardFrame().getSacrificesCount()+" monstro(s) para sacrificar");
			GUI.getBoardFrame().setMonsterToSummon(monster);
			GUI.getBoardFrame().setSacrificeAttack(isAttackMode);
		}else{
			GUI.errorFrame(new Exception("Você não tem sacrifícios suficientes."));
		}
	}
}