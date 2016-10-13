package com.example.Blackjack;

import java.util.LinkedList;

/**
 * @author Benjamin East
 *
 */
public class BlackjackHand {
	protected LinkedList<BlackjackCard> cardHand;

	public BlackjackHand() {
		this.cardHand = new LinkedList<BlackjackCard>();
	}

	public int getHandSize() {
		return cardHand.size();
	}
	
	public boolean contains(BlackjackCard card) {
		for(BlackjackCard c : cardHand) {
			if(c.equals(card)) {
				return true;
			}
		}
		
		return false;
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

	public String toString() {
		String output= "";
		
		
		
		return output;
	}

}
