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
	protected LinkedList<BlackjackCard> cardHand;

	public Hand() {
		this.cardHand = new LinkedList<BlackjackCard>();
	}

	public void addCard(BlackjackCard newCard) {
		cardHand.add(newCard);
	}

	public void clearHand() {
		this.cardHand = new LinkedList<BlackjackCard>();
	}

	/*
	 * @return Returns the total weight of the cards in the hand.
	 */
	public int getTotalWeight() {
		int total = 0;

		for (BlackjackCard c : this.cardHand) {
			total += c.getWeight();
		}

		return total;
	}

}
