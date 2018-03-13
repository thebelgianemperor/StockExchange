package Domain;
import java.util.ArrayList;
import java.util.List;

public class Card {

	private String name;
	private int cost;
	
	/**
	 * Abilities per card. Enum to identify possible effects.
	 */
	private List<Ability> abilities;

	private boolean isOriginal;
	private Card original;
	
	public Card(String name, int cost, ArrayList<Ability> abilities, boolean isOriginal){
		this.setName(name);
		this.setCost(cost);
		this.setAbilities(abilities);
		this.setOriginal(isOriginal);
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}

	public ArrayList<Ability> getAbilities(){
		return (ArrayList)abilities;
	}

	public void setAbilities(ArrayList<Ability> abilities){
		this.abilities = abilities;
	}
	
	public boolean hasAbilities(){
		return (!this.getAbilities().isEmpty());
	}
	
	public boolean isOriginal(){
		return this.isOriginal;
	}
	
	public void setOriginal(boolean isOriginal){
		this.isOriginal = isOriginal;
	}
	
	public Card getOriginal(){
		return this.original;
	}
	
	public void setOriginal(Card card){
		this.original = card;
	}

	
}
