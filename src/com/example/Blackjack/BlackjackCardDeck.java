package com.example.Blackjack;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Benjamin East
 *
 */
public class BlackjackCardDeck {

	private LinkedList<BlackjackCard> deck;

	/**
	 * Constructs a new CardDeck object.
	 */
	public BlackjackCardDeck() {
		this.deck = new LinkedList<BlackjackCard>();
		resetDeck();
	}

	/*
	 * This function resets the deck to it's original, full state.
	 */
	private void resetDeck() {
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		for (String suit : suits) {
			for (int i = 1; i < 14; ++i) {
				this.deck.addLast(new BlackjackCard(suit, i));
			}
		}
	}

	/**
	 * Randomly chooses a card from the deck, removes it from the deck, and
	 * returns the card.
	 * 
	 * @return Returns a randomly chosen Blackjackcard from the deck.
	 */
	public BlackjackCard getNextCard() {
		Random rand = new Random();

		int randInt = rand.nextInt(this.deck.size());

		BlackjackCard temp = this.deck.get(randInt);
		this.deck.remove(temp);

		if (this.deck.size() == 0) {
			resetDeck();
		}

		return temp;
	}

}
