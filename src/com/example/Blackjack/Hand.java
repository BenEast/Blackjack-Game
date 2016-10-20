/**
 * 
 */
package com.example.Blackjack;

import java.util.LinkedList;

/**
 * @author Benjamin East
 *
 */
public class Hand {
	private LinkedList<Card> cardHand;

	/**
	 * Constructs an empty linked list to store Card objects
	 */
	public Hand() {
		this.cardHand = new LinkedList<Card>();
	}

	/**
	 * @param newCard
	 *            The new card to be added to the hand.
	 */
	public void addCard(Card newCard) {
		cardHand.add(newCard);
	}

	/**
	 * Clears all of the cards from this.cardHand
	 */
	public void clearHand() {
		this.cardHand.clear();
	}
}
