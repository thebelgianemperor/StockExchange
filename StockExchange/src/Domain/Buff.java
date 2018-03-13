package Domain;

import java.util.ArrayList;
import java.util.List;

public class Buff {
	
	private String name;
	private int Attack;
	private int Health;
	private int Cost;
	
	private List<Ability> abilities;
	
	public Buff(String name, int attack, int health, ArrayList<Ability> abilities){
		this.setName(name);
		this.setAttack(attack);
		this.setHealth(health);
		this.setAbilities(abilities);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public int getAttack(){
		return Attack;
	}

	public void setAttack(int attack){
		Attack = attack;
	}

	public int getHealth(){
		return Health;
	}

	public void setHealth(int health){
		Health = health;
	}
	
	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public ArrayList<Ability> getAbilities(){
		return (ArrayList)abilities;
	}

	public void setAbilities(ArrayList<Ability> abilities) {
		this.abilities = abilities;
	}
		
}
