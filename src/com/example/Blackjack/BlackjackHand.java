package com.example.Blackjack;

import java.util.LinkedList;

/**
 * @author Benjamin East
 *
 */
public class BlackjackHand extends Hand {

	private LinkedList<BlackjackCard> cardHand;

	/**
	 * Constructs an empty BlackjackHand object
	 */
	public BlackjackHand() {
		super();
		this.cardHand = new LinkedList<BlackjackCard>();
	}

	/**
	 * @return Returns the number of cards in the hand.
	 */
	public int getHandSize() {
		return cardHand.size();
	}

	/**
	 * @param card
	 *            The card to be found in the hand.
	 * @return Returns true if the card is in the hand, and false otherwise.
	 */
	public boolean contains(BlackjackCard card) {
		for (BlackjackCard c : cardHand) {
			if (c.equals(card)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param newCard
	 *            The card to be added to the hand.
	 */
	public void addCard(BlackjackCard newCard) {
		cardHand.add(newCard);
	}

	/**
	 * @return Returns the total blackjack "weight" of the hand.
	 */
	public int getTotalWeight() {
		int total = 0;

		for (BlackjackCard c : this.cardHand) {
			total += c.getWeight();
		}

		return total;
	}

	/**
	 * @return Returns a string representation of the BlackjackHand.
	 */
	@Override
	public String toString() {
		String result = "";
		for (BlackjackCard c : this.cardHand) {
			result += c.toString() + "\n";
		}

		return result;
	}

}
