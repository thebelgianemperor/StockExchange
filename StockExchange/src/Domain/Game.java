package Domain;
import java.util.LinkedList;

public class Game {

	private int turn;
	
	private Player currentPlayer;
	
	public Player player1;
	public Player player2;
	
	public Hand shared;
	
	public Game(int turn, int maxGold, int playerHealth, int gold1, int gold2, int boardSize, 
			int handSize, int sharedSize, LinkedList<Card> deck1, LinkedList<Card> deck2){
		
		LinkedList<Card> deck1copy = new LinkedList<Card>();
		for (Card card: deck1)
			deck1copy.add(card);
		
		LinkedList<Card> deck2copy = new LinkedList<Card>();
		for (Card card: deck2)
			deck2copy.add(card);
		
		this.setTurn(turn);
		
		this.player1 = new Player(playerHealth, maxGold, gold1, boardSize, handSize, sharedSize, deck1copy);
		this.player2 = new Player(playerHealth, maxGold, gold2, boardSize, handSize, sharedSize, deck2copy);
		
		this.setCurrentPlayer(player1);
		
		this.shared = new Hand(sharedSize);		
	}
	
	public int getTurn(){
		return this.turn;
	}
	
	public void setTurn(int turn){
		this.turn = turn;
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(Player player){
		this.currentPlayer = player;
	}
	
	/**
	 * Draw a card for a player.
	 * @param player The player that draws the card.
	 */
	private void draw(Player player){
		
		Card card = player.deck.drawCard();

		//TODO: if null? fatigue?
		if (card == null)
			return;
		
		Card sharedCard = player.hand.addToHand(card);
		if (sharedCard == null)
			return;
		
		Card discardCard = this.shared.addToHand(sharedCard);
		if (discardCard == null){
			player.shared.addToHand(sharedCard);
			return;
		}
		
		player.addToDiscard(discardCard);
	}
	
	public void playCard(Hand hand, int index){
		//TODO: remove from shared hand and player.shared hand
	}
	
	/**
	 * A minion attacks a minion.
	 * 
	 * @param index1
	 * @param player1
	 * @param index2
	 * @param player2
	 */
	private void attackMinion(int index1, Player player1, int index2, Player player2){
		Minion minion1 = player1.board.getMinionAt(index1);
		Minion minion2 = player2.board.getMinionAt(index2);
		
		minion1.setHealth(minion1.getHealth() - minion2.getAttack());
		minion2.setHealth(minion2.getHealth() - minion1.getAttack());
	}
	
	/**
	 * A minion attacks a player
	 * 
	 * @param index
	 * @param player1
	 * @param player2
	 */
	private void attackPlayer(int index, Player player1, Player player2){
		Minion minion = player1.board.getMinionAt(index);
		player2.setHealth(player2.getHealth() - minion.getAttack());
	}
	
	private void addMinion(Player player, int index, Minion minion){
		if (player.board.isFull())
			return;
		//TODO: full board
		player.board.addMinion(index, minion);
	}
	
	private Minion removeMinion(Player player, int index){
		return player.board.removeMinionAt(index);
	}
	
	private void killMinion(Player player, int index){
		Card discard = this.removeMinion(player, index);
		player.addToDiscard(discard);
	}
	
	//TODO: END AND START: think this through!
	private void endTurn(Player player){
		//TODO: end-of-turn effects
		if (player == this.player2){
			this.setTurn(this.getTurn() + 1);
			this.setCurrentPlayer(this.player1);
		}
		else
			this.setCurrentPlayer(this.player2);
	}
	
	private void startTurn(Player player){
		player.setTurnGold(player.getTurnGold() + 1);
		//TODO: start-of-turn effects
		this.draw(player);
	}
	
}
