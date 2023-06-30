package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.configsGlobais.Logger;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.otherframes.AnimationFrame;

@SuppressWarnings("serial")
public class HandOptionsFrame extends JFrame implements ActionListener{

	JButton leftButton = new JButton ("Summon Monster");
	JButton rightButton = new JButton ("Set Monster");
	JButton cancelButton = new JButton ("Cancel");
	SpellCard spell;
	MonsterCard monster;
	JTextArea cardName = new JTextArea("");
	JTextArea cardDescription = new JTextArea("");

	private void ConfigTextArea(JTextArea textArea) {
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		int padding = 10; // Adjust the padding value as needed
		textArea.setBorder(new EmptyBorder(padding, padding, padding, padding));


	}


	public HandOptionsFrame(boolean isMonsterOptions , Card card){
		super("Choose Action");
		if (!isMonsterOptions) {
			spell = (SpellCard)card;

			leftButton.setText("Activate Spell");
			rightButton.setText("Set Spell");
		} else {
			monster = (MonsterCard)card;
		}

		ConfigTextArea(cardName);
		cardName.setText(card.getName());
		cardName.setFont(cardName.getFont().deriveFont(Font.BOLD));

		ConfigTextArea(cardDescription);
		cardDescription.setText(card.getDescription());
		constructFrame();
	}

	private void constructFrame() {
		setVisible(true);
		setLayout(new GridBagLayout());
		setSize(450,200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.WEST;

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.fill = 1;
		add(cardName, c);

		c.gridx = 0;
		c.gridy = 1;
		c.insets.top = 10;
		c.insets.bottom = 10;
		add(cardDescription, c);

		c.gridwidth = 1;
		c.fill = 0;

		c.insets.right = 5;
		c.gridx = 0;
		c.gridy = 2;
		add(leftButton , c);
		c.gridx =1;
		c.insets.right = 0;
		c.ipadx = 40;

		c.gridx = 1;
		add(rightButton , c);

		c.gridx = 2;
		add(cancelButton , c);

		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Logger.logs().info("HandOptionsFrame - actionPerformed getActionCommand: " + e.getActionCommand());

		if(e.getActionCommand().equals("Cancel")){
			GUI.getBoardFrame().resetHandlers();
		}else
			if(e.getActionCommand().equals("Activate Spell")){
				activateSpellCard();
			}
			else
				if(e.getActionCommand().equals("Set Spell")){
					try {
						Card.getBoard().getActivePlayer().setSpell(spell);
						GUI.getBoardFrame().setMonsterToSummon(null);
						GUI.getBoardFrame().setSpellToActivate(null);
					} catch (Exception e1) {
						Logger.logs().error("HandOptionsFrame - actionPerformed Exception: " + e1);
						GUI.errorFrame(e1);
					}
				}else
					monsterOptions(e);
		GUI.getBoardFrame().updateBoardFrame();
		dispose();
	}

	private void activateSpellCard() {

		boolean isInstanceChangeOfHeart = spell instanceof ChangeOfHeart;
		boolean isInstanceMagePower = spell instanceof MagePower;

		Logger.logs().info("HandOptionsFrame - activateSpellCard isInstanceChangeOfHeart " + isInstanceChangeOfHeart + " " + "isInstanceMagePower " + isInstanceMagePower);

		if(isInstanceChangeOfHeart || isInstanceMagePower){
			new ConfirmFrame("Please click a monster to activate on");
			GUI.getBoardFrame().setSpellToActivate(spell);
			GUI.getBoardFrame().setMonsterToSummon(null);
		}else{
			try {
				Card.getBoard().getActivePlayer().activateSpell(spell, null);
				GUI.getBoardFrame().setMonsterToSummon(null);
				GUI.getBoardFrame().setSpellToActivate(null);
			} catch (Exception e) {
				Logger.logs().error("HandOptionsFrame - activateSpellCard Exception: " + e);
				GUI.errorFrame(e);
			}
		}
		AnimationFrame an = new AnimationFrame();
		an.AnimationAsk();
	}
	private void monsterOptions(ActionEvent e){

		Logger.logs().info("HandOptionsFrame - monsterOptions getActionCommand: " + e.getActionCommand());

		try{
			if(e.getActionCommand().equals("Summon Monster")){
				if(monster.getLevel()<5){
					Card.getBoard().getActivePlayer().summonMonster(monster);
					GUI.getBoardFrame().setMonsterToSummon(null);
				}
				else {
					ritualSummon(true);
				}
				GUI.getBoardFrame().setSpellToActivate(null);
			}

			if(e.getActionCommand().equals("Set Monster")){

				int monsterLevel = monster.getLevel();

				Logger.logs().info("HandOptionsFrame - monsterOptions monsterLevel: " + monsterLevel);

				if(monsterLevel<5){
					Card.getBoard().getActivePlayer().setMonster(monster);
					GUI.getBoardFrame().setMonsterToSummon(null);
				}else {
					ritualSummon(false);
				}
				GUI.getBoardFrame().setSpellToActivate(null);
			}
			
		}catch(Exception e1){
			Logger.logs().error("HandOptionsFrame - monsterOptions Exception: " + e1);
			GUI.errorFrame(e1);

		}
	}
	private void ritualSummon(boolean isAttackMode) {

		int monsterLevel = monster.getLevel();

		Logger.logs().info("HandOptionsFrame - ritualSummon monsterLevel: " + monsterLevel);

		if( monsterLevel < 7)
			GUI.getBoardFrame().setSacrificesCount(1);
		else 
			GUI.getBoardFrame().setSacrificesCount(2);

		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()>=GUI.getBoardFrame().getSacrificesCount()){

			Logger.logs().info("HandOptionsFrame - ritualSummon monster: " + monster);

			new ConfirmFrame("Please click "+GUI.getBoardFrame().getSacrificesCount()+" monster(s) to sacrifice");
			GUI.getBoardFrame().setMonsterToSummon(monster);
			GUI.getBoardFrame().setSacrificeAttack(isAttackMode);
		}else{

			String message = "You don't have enough sacrifices.";

			Logger.logs().error("HandOptionsFrame - ritualSummon message: " + message);
			GUI.errorFrame(new Exception(message));
		}
	}
}