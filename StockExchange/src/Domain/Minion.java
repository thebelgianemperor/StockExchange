package Domain;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Minion extends Card {
	
	private int attack;
	private int health;
	private boolean died;
	
	private List<Buff> buffs;
	
	public Minion(String name, int attack, int health, int cost, 
			ArrayList<Ability> abilities, boolean isOriginal){
		super(name, cost, abilities, isOriginal);
		this.setAttack(attack);
		this.setHealth(health);
		this.setDied(false);
		this.buffs = new LinkedList<Buff>();
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	public void setAttack(int attack){
		this.attack = attack;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setHealth(int health){
		this.health = health;
	}

	public boolean hasDied() {
		return died;
	}

	public void setDied(boolean died) {
		this.died = died;
	}

	public void addBuff(Buff buff){
		this.buffs.add(buff);
		this.setAttack(this.getAttack() + buff.getAttack());
		this.setHealth(this.getHealth() + buff.getHealth());
		this.setCost(this.getCost() + buff.getCost());
	}
	
	public void removeBuff(Buff buff){
		this.setAttack(this.getAttack() - buff.getAttack());
		this.setHealth(this.getHealth() - buff.getHealth());
		this.setCost(this.getCost() - buff.getCost());
		this.buffs.remove(buff);
	}
}
