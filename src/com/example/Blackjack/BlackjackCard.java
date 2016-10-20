package com.example.Blackjack;

/**
 * @author Benjamin East
 *
 */
public final class BlackjackCard extends Card {

	private int weight; // the weight of the card in the game of blackjack

	/**
	 * Constructs a new undefined BlackjackCard object.
	 */
	public BlackjackCard() {
		super();
		setCardWeight();
	}

	/**
	 * Constructs a new BlackjackCard with the given values.
	 * 
	 * @param suit
	 *            The suit of the new card (Hearts, Diamonds, Clubs, Spades).
	 * @param value
	 *            The value of the new card (1..13 for Ace..King).
	 */
	public BlackjackCard(String suit, int value) {
		super(suit, value);
		setCardWeight();
	}

	/*
	 * Sets the Weight value, to define the value of this card in Blackjack.
	 */
	private void setCardWeight() {
		if (this.value == -1) {
			this.weight = -1;
		} else if (this.value == 1) {
			this.weight = 1;
		} else if (this.value > 10) {
			this.weight = 10;
		} else {
			this.weight = this.value;
		}
	}

	/**
	 * Manually sets the weight of the card with the given weight.
	 * 
	 * @param newWeight
	 *            The new weight of the card.
	 */
	protected void setWeight(int newWeight) {
		this.weight = newWeight;
	}

	/**
	 * Returns the weight of the card.
	 * 
	 * @return The weight of the card.
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * @return Returns a string representation of the card.
	 */
	@Override
	public String toString() {
		return this.cardClass + " of " + this.suit + ":  " + this.weight + " points";
	}

	/**
	 * @return Returns true if the card is an ace, and false otherwise.
	 */
	public boolean isAce() {
		if (this.value == 1) {
			return true;
		} else {
			return false;
		}
	}

}
