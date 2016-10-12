package com.example.Blackjack;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Benjamin East
 *
 */
public class CardDeck {

	private LinkedList<BlackjackCard> deck;

	public CardDeck() {
		this.deck = new LinkedList<BlackjackCard>();
		resetDeck();
	}

	/*
	 * This function resets the deck to it's original, full state
	 */
	private void resetDeck() {
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		for (String suit : suits) {
			for (int i = 1; i < 14; ++i) {
				this.deck.addLast(new BlackjackCard(suit, i));
			}
		}
	}

	/*
	 * @return Returns a random BlackjackCard that is in the deck. Randomly
	 * chooses an index in the deck and returns that card. The card is removed
	 * from the deck.
	 */
	public BlackjackCard getNextCard() {
		Random rand = new Random();
		
		int randInt = rand.nextInt(this.deck.size());

		BlackjackCard temp = this.deck.get(randInt);
		this.deck.remove(temp);

		if(this.deck.size() == 0) {
			resetDeck();
		}
		
		return temp;
	}

}
