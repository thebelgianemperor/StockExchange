package Domain;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	private List<Card> deck;
	
	public Deck(LinkedList<Card> deck){
		this.deck = deck;
		//this.shuffle();
	}
	
	public void shuffle(){
		Collections.shuffle(this.deck);
	}
	
	public Card drawCard(){
		return ((LinkedList<Card>) deck).pollFirst();
	}
	
	public void addTop(Card card){
		CopyCard copy = new CopyCard(card);
		((LinkedList<Card>) deck).addFirst(copy.card);
	}
	
	public void addBottom(Card card){
		CopyCard copy = new CopyCard(card);
		((LinkedList<Card>) deck).addLast(copy.card);
	}
	
	public void addRandom(Card card){
		CopyCard copy = new CopyCard(card);
		int index = ThreadLocalRandom.current().nextInt(0,deck.size());
		deck.add(index, copy.card);
	}
}
