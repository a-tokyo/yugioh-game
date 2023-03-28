package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.player.Player;

public class MonsterCard extends Card {

	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode = Mode.DEFENSE;
	private boolean switchedMode;
	private boolean attacked;

	public MonsterCard(String n, String desc, int l, int a, int d) {

		super(n, desc);
		this.level = l;
		this.attackPoints = a;
		this.defensePoints = d;
		this.attacked = false;
		this.switchedMode = false;

	}

	public void action() {

		attackLifePoints();
		this.setAttacked(true);

	}

	public void action(MonsterCard monster) {

		if (monster != null) {
			attackMonster(monster);
		}

		this.setAttacked(true);

	}

	public void attackLifePoints() {

		int lp = getBoard().getOpponentPlayer().getLifePoints();
		getBoard().getOpponentPlayer().setLifePoints(
				lp - this.getAttackPoints());

	}

	public void attackMonster(MonsterCard target) {

		Player active = getBoard().getActivePlayer();
		Player opponent = getBoard().getOpponentPlayer();

		if (target.getMode() == Mode.ATTACK) {

			if (this.getAttackPoints() > target.getAttackPoints()) {

				int damage = this.getAttackPoints() - target.getAttackPoints();
				opponent.getField().removeMonsterToGraveyard(target);
				int lp = opponent.getLifePoints();
				opponent.setLifePoints(lp - damage);

			} else if (this.getAttackPoints() == target.getAttackPoints()) {

				active.getField().removeMonsterToGraveyard(this);
				opponent.getField().removeMonsterToGraveyard(target);
				this.setAttacked(true);

			} else {

				int damage = target.getAttackPoints() - this.getAttackPoints();
				active.getField().removeMonsterToGraveyard(this);
				int lp = active.getLifePoints();
				active.setLifePoints(lp - damage);

			}

		} else {

			if (this.getAttackPoints() > target.getDefensePoints()) {

				opponent.getField().removeMonsterToGraveyard(target);
				this.setAttacked(true);

			} else if (this.getAttackPoints() == target.getAttackPoints()) {

				this.setAttacked(true);
				this.setHidden(true);

			} else {

				int damage = target.getDefensePoints() - this.getAttackPoints();
				int lp = active.getLifePoints();
				active.setLifePoints(lp - damage);
				this.setHidden(true);

			}
		}

	}

	public void switchMode() {

		if (mode == Mode.ATTACK) {

			mode = Mode.DEFENSE;
			setHidden(true);

		} else {

			mode = Mode.ATTACK;
			setHidden(false);

		}
	}

	public boolean isSwitchedMode() {
		return switchedMode;
	}

	public void setSwitchedMode(boolean switchedMode) {
		this.switchedMode = switchedMode;
	}

	public boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public void setHidden(boolean hidden) {
		super.setHidden(hidden);
	}

}
