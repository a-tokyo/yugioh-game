package eg.edu.guc.yugioh.gui.boardframe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.configsGlobais.Logger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BoardFrame extends JFrame implements ActionListener{
	private FieldPanel fieldPanel;
	private HandPanel opponentHandPanel;
	private HandPanel activeHandPanel;
	private WestImagesPanel westImagesPanel;
	private EastButtonsPanel eastButtonsPanel;
	
	private MonsterCard attackingMonster;
	private boolean toSwitch = false;
	private SpellCard spellToActivate;
	private boolean sacrificeAttack ;
	private ArrayList<MonsterCard> sacrificedMonsters = new ArrayList<MonsterCard>();
	private int sacrificesCount;
	private MonsterCard monsterToSummon;

	public BoardFrame(){
		super("Yu-Gi-Oh!");
		setFramePrefrences();
		initializeAttributes();
		addPanels();
		validate();
	}

	private void setFramePrefrences(){
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1367, 792);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);		
//		setUndecorated(true);
		setVisible(true);	
		setResizable(false);
	}

	private void initializeAttributes(){

		fieldPanel = new FieldPanel();
		activeHandPanel = new HandPanel(true);
		opponentHandPanel = new HandPanel(false);
		opponentHandPanel.setPreferredSize(new Dimension(activeHandPanel.getPreferredSize().width,15));
		westImagesPanel = new WestImagesPanel();
		eastButtonsPanel =new EastButtonsPanel();
	}

	private void addPanels(){
		setContentPane(new JLabel(new ImageIcon("images/background.jpg")));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		dataPanel.setOpaque(false);
		dataPanel.setSize(1366,768);
		dataPanel.add(opponentHandPanel,BorderLayout.NORTH);
		dataPanel.add(fieldPanel, BorderLayout.CENTER);
		dataPanel.add(activeHandPanel,BorderLayout.SOUTH);
		dataPanel.add(eastButtonsPanel,BorderLayout.EAST);
		dataPanel.add(westImagesPanel,BorderLayout.WEST);
		add(dataPanel);
	}
	
	public FieldPanel getFieldPanel() {
		return fieldPanel;
	}

	public void setFieldPanel(FieldPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}

	public HandPanel getOpponentHandPanel() {
		return opponentHandPanel;
	}

	public void setOpponentHandPanel(HandPanel opponentHandPanel) {
		this.opponentHandPanel = opponentHandPanel;
	}

	public HandPanel getActiveHandPanel() {
		return activeHandPanel;
	}

	public void setActiveHandPanel(HandPanel activeHandPanel) {
		this.activeHandPanel = activeHandPanel;
	}

	public WestImagesPanel getWestImagesPanel() {
		return westImagesPanel;
	}

	public void setWestImagesPanel(WestImagesPanel westImagesPanel) {
		this.westImagesPanel = westImagesPanel;
	}

	public EastButtonsPanel getEastButtonsPanel() {
		return eastButtonsPanel;
	}

	public void setEastButtonsPanel(EastButtonsPanel eastButtonsPanel) {
		this.eastButtonsPanel = eastButtonsPanel;
	}

	public void updateBoardFrame() {

			Logger.logs().info("BoardFrame - updateBoardFrame");

			activeHandPanel.updateHand();
			opponentHandPanel.updateHand();
			fieldPanel.getActivePlayerPanel().getDeckGraveyardPanel().getDeck().updateDeck();
			fieldPanel.getOpponentPlayerPanel().getDeckGraveyardPanel().getDeck().updateDeck();
			fieldPanel.getActivePlayerPanel().getDeckGraveyardPanel().getGraveyard().updateGraveyard();
			fieldPanel.getOpponentPlayerPanel().getDeckGraveyardPanel().getGraveyard().updateGraveyard();
			fieldPanel.getActivePlayerPanel().getMonsterSpellPanel().getMonstersGrid().updateMonstersArea();
			fieldPanel.getOpponentPlayerPanel().getMonsterSpellPanel().getMonstersGrid().updateMonstersArea();
			fieldPanel.getActivePlayerPanel().getMonsterSpellPanel().getSpellsGrid().updateSpellsArea();
			fieldPanel.getOpponentPlayerPanel().getMonsterSpellPanel().getSpellsGrid().updateSpellsArea();
			fieldPanel.getActivePlayerPanel().getPlayerNamePanel().updateLifePoints();
			fieldPanel.getOpponentPlayerPanel().getPlayerNamePanel().updateLifePoints();
			repaint();
			validate();
	}

	public boolean isToSwitch() {
		return toSwitch;
	}

	public void setToSwitch(boolean toSwitch) {
		this.toSwitch = toSwitch;
	}

	public SpellCard getSpellToActivate() {
		return spellToActivate;
	}

	public void setSpellToActivate(SpellCard spellToActivate) {
		this.spellToActivate = spellToActivate;
	}

	
	public int getSacrificesCount() {
		return sacrificesCount;
	}

	public void setSacrificesCount(int sacrificesCount) {
		this.sacrificesCount = sacrificesCount;
	}
	
	public void decrementSacrificesCount() {
		this.sacrificesCount--;
	}

	public boolean isSacrificeAttack() {
		return sacrificeAttack;
	}

	public void setSacrificeAttack(boolean sacrificeAttack) {
		this.sacrificeAttack = sacrificeAttack;
	}

	public ArrayList<MonsterCard> getSacrificedMonsters() {
		return sacrificedMonsters;
	}

	public void setSacrificedMonsters(ArrayList<MonsterCard> sacrificedMonsters) {
		this.sacrificedMonsters = sacrificedMonsters;
	}

	public MonsterCard getMonsterToSummon() {
		return monsterToSummon;
	}

	public void setMonsterToSummon(MonsterCard monsterToSummon) {
		this.monsterToSummon = monsterToSummon;
	}

	public MonsterCard getAttackingMonster() {
		return attackingMonster;
	}

	public void setAttackingMonster(MonsterCard attackingMonster) {
		this.attackingMonster = attackingMonster;
	}

	public void resetHandlers() {

		Logger.logs().info("BoardFrame - resetHandlers");

		attackingMonster = null;
		toSwitch = false;
		spellToActivate = null;
		sacrificeAttack = false;
		sacrificedMonsters = new ArrayList<MonsterCard>();
		sacrificesCount=0;
		monsterToSummon=null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.toBack();
	}

}