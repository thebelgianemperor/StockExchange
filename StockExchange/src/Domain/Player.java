package Domain;
import java.util.LinkedList;

public class Player {

	private int health;
	private int gold;
	private int turnGold;
	private int maxGold;
	
	public Board board;
	public Hand hand;
	public Hand shared;
	public Deck deck;
	public Deck discard;
	
	public Player(int health, int maxGold, int gold, int boardSize, 
			int handSize, int sharedSize, LinkedList<Card> deck){
		
		this.setHealth(health);
		this.setTurnGold(turnGold);
		this.setGold(gold);
		this.setMaxGold(maxGold);
		
		this.board = new Board(boardSize);
		
		this.hand = new Hand(handSize);
		this.shared = new Hand(sharedSize);
		
		this.deck = new Deck(deck);
		this.discard = new Deck(new LinkedList<Card>());
	}

	public int getHealth(){
		return this.health;
	}

	public void setHealth(int health){
		this.health = health;
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public int setGold(int gold){
		int tempGold = gold;
		if (gold > this.getMaxGold())
			tempGold = this.getMaxGold();
		this.gold = tempGold;
		return tempGold;
	}
	
	public int getTurnGold(){
		return this.getTurnGold();
	}
	
	public void setTurnGold(int gold){
		this.turnGold = setGold(gold);
	}
	
	public int getMaxGold(){
		return this.maxGold;
	}
	
	public void setMaxGold(int gold){
		this.maxGold = gold;
	}
	
	public void addToDeckTop(Card card){
		this.deck.addTop(card);
	}
	
	public void addToDeckBottom(Card card){
		this.deck.addBottom(card);
	}
	
	public void addToDeckRandom(Card card){
		this.deck.addRandom(card);
	}
	
	public void addToDiscard(Card card){
		if (card.isOriginal())
			this.discard.addTop(card);
		else
			this.discard.addTop(card.getOriginal());
	}
	
}
