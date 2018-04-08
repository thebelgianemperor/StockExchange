package Domain;
import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private int size;
	private List<Card> hand;
	
	public Hand(int size){
		this.setSize(size);
		this.hand = new ArrayList<Card>();
		for (int i = 0; i < size; i++)
			hand.add(null);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Card> getHand(){
		return hand;
	}
	
	public Card addToHand(Card card){
		if (this.isFullHand())
			return card;
		
		int i = 0;
		while (this.getHand().get(i) != null)
			i++;
		
		this.hand.add(i, card);
		
		return null;
	}
	
	public Card removeFromHand(Card card){
		if (!this.getHand().contains(card))
			throw new NullPointerException();
		this.hand.remove(card);
		this.hand.add(null);
		return card;
	}
	
	public boolean isFullHand(){
		for (int i = 0; i < size; i++){
			if (this.getHand().get(i) == null)
				return false;
		}
		return true;
	}
	
}
