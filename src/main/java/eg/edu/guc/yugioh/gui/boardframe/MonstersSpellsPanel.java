package eg.edu.guc.yugioh.gui.boardframe;
import eg.edu.guc.yugioh.configsGlobais.Logger;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonstersSpellsPanel extends JPanel{
	private MonstersGrid monstersGrid;
	private SpellsGrid spellsGrid;
	

	public MonstersSpellsPanel(boolean active) {
		setLayout(new BorderLayout());
		monstersGrid = new MonstersGrid(active);
		spellsGrid = new SpellsGrid(active);
		setPreferredSize(new Dimension(CardButton.getDimension('W')*5,300));
		if(!active){
			add(monstersGrid,BorderLayout.SOUTH);
			add(spellsGrid,BorderLayout.NORTH);	
		}else{
		add(monstersGrid,BorderLayout.NORTH);
		add(spellsGrid,BorderLayout.SOUTH);
		}
		
		setVisible(true);
		validate();
	}
	
	public void updateFieldCards(){

		Logger.logs().info("MonstersSpellsPanel - updateFieldCards");

		monstersGrid.updateMonstersArea();
		spellsGrid.updateSpellsArea();
	}
	
	public MonstersGrid getMonstersGrid() {
		return monstersGrid;
	}
	public void setMonstersGrid(MonstersGrid monstersGrid) {
		this.monstersGrid = monstersGrid;
	}
	public SpellsGrid getSpellsGrid() {
		return spellsGrid;
	}
	public void setSpellsGrid(SpellsGrid spellsGrid) {
		this.spellsGrid = spellsGrid;
	}
}