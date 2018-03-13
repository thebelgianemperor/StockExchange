package Domain;

public class CopyCard {
	
	Card card;
	
	public CopyCard(Card card){
		if (card instanceof Minion){
			this.card = new Minion(card.getName(), ((Minion) card).getAttack(), 
					((Minion) card).getHealth(), card.getCost(), card.getAbilities(), false);
		}
		else{
			this.card = new Card(card.getName(), card.getCost(), card.getAbilities(), false);
		}
	}
	
}
