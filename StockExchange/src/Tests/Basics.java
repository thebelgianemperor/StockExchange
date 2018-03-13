package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Domain.*;

public class Basics {

	@Before
	public void setUp() throws Exception {
	}

	//Minion
	@Test
	public void testMakeMinion() {
		ArrayList abilities = new ArrayList();
		Minion testCard = new Minion("Test", 1, 2, 1, abilities, true);
	}
	
	ArrayList abilities = new ArrayList();
	Minion testCard = new Minion("Test", 1, 2, 1, abilities, true);
	
	@Test
	public void testName(){
		assertEquals(testCard.getName(), "Test");
	}
	
	@Test
	public void testAttack(){
		assertEquals(testCard.getAttack(), 1);
	}
	
	@Test
	public void testHealth(){
		assertEquals(testCard.getHealth(), 2);
	}
	
	@Test
	public void testCost(){
		assertEquals(testCard.getCost(), 1);
	}
	
	@Test
	public void testAbilities(){
		assertEquals(testCard.getAbilities(), abilities);
	}
	
	@Test
	public void testDied(){
		assertFalse(testCard.hasDied());
	}
	
	//Spell
	Spell testSpell = new Spell("Test", 2, abilities, true);
	
	@Test
	public void testSpell(){
		assertEquals(testSpell.getCost(), 2);
		assertEquals(testSpell.getName(), "Test");
		assertEquals(testSpell.getAbilities(), abilities);
	}
	
	//Deck
	LinkedList<Card> deckList = new LinkedList<Card>();
	
	{for (int i = 0; i < 5; i++){
		Spell cardx = new Spell("Testing", i, abilities, true);
		deckList.add(cardx);
	}}
	Deck deck = new Deck(deckList);
	
	@Test
	public void testDrawDeck(){
		Card test = deck.drawCard();
		assertEquals(test.getCost(),0);
	}
	
	@Test
	public void testAddDeck(){
		Spell test = new Spell("Test", 8, abilities, true);
		deck.addTop(test);
		test.setCost(5);
		Card test2 = deck.drawCard();
		
		assertEquals(test.getCost(), 5);
		assertEquals(test2.getCost(), 8);
	}
	
	//Hand	
	@Test
	public void testAddHand(){
		Hand testHand = new Hand(4);
		
		for (int i = 0; i < 4; i++){
			Spell card = new Spell("Test", i, abilities, true);
			testHand.addToHand(card);
		}
		for (int i = 0; i < 4; i++){
			int cost = testHand.getHand().get(i).getCost();
			assertEquals(cost, i);
		}
	}
	
	@Test
	public void testAddHandFull(){
		Hand testHand = new Hand(2);
		
		for (int i = 0; i < 2; i++){
			Spell card = new Spell("Test", i, abilities, true);
			testHand.addToHand(card);
		}
		
		Spell card = new Spell("Test", 4, abilities, true);
		Card test = testHand.addToHand(card);
		assertEquals(test, card);
	}
	
	@Test
	public void removeFromHand(){
		Hand testHand = new Hand(2);
		
		for (int i = 0; i < 2; i++){
			Spell card = new Spell("Test", i, abilities, true);
			testHand.addToHand(card);
		}
		
		Card test = testHand.getHand().get(1);
		Card remove = testHand.removeFromHand(1);
		
		assertEquals(test, remove);
	}
	
	@Test
	public void removeFromHandAdd(){
		Hand testHand = new Hand(2);
		
		for (int i = 0; i < 2; i++){
			Spell card = new Spell("Test", i, abilities, true);
			testHand.addToHand(card);
		}
		
		testHand.removeFromHand(1);
		Spell test = new Spell("Test", 2, abilities, true);
		testHand.addToHand(test);
		Card test2 = testHand.getHand().get(1);
		
		assertEquals(test, test2);
	}
}
