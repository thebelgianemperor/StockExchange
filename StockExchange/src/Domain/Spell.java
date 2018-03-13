package Domain;
import java.util.ArrayList;

public class Spell extends Card {

	public Spell(String name, int cost, ArrayList<Ability> abilities, boolean isOriginal){
		super(name, cost, abilities, isOriginal);
	}
	
}
