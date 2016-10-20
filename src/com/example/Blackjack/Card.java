package com.example.Blackjack;

/**
 * 
 * @author Benjamin East
 */
public class Card {

	protected String suit; // the suit of the card
	protected int value; // the value of the card (1..13) where 1 = ace, 11 =
	protected String cardClass; // the class of the card (Ace, 2..10, Jack,
								// Queen, King)

	/**
	 * Constructs an undefined card with invalid values
	 */
	public Card() {
		this.suit = "UNDEFINED";
		this.value = -1;
		setCardClass();
	}

	/**
	 * Constructs a card object using the specified information.
	 * 
	 * @param suit
	 *            the suit of the card (Hearts, Diamonds, Clubs, or Spades)
	 * @param value
	 *            the value of the card (1..13 for Ace..King)
	 */
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
		setCardClass();
	}

	/**
	 * @return Returns the suit of this card.
	 */
	public String getSuit() {
		return this.suit;
	}

	/**
	 * @return Returns the value of this card.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * @return Returns a string representation of this card object.
	 */
	public String toString() {
		return "{S: " + this.suit + ", V: " + this.value + "}";
	}

	/**
	 * Uses the value of the card to determine the class of the card. In this
	 * case, class is Ace, 2..10, Jack, Queen, or King.
	 */
	private void setCardClass() {
		switch (this.value) {
		case -1:
			this.cardClass = "Undefined";
			break;
		case 1:
			this.cardClass = "Ace";
			break;
		case 11:
			this.cardClass = "Jack";
			break;
		case 12:
			this.cardClass = "Queen";
			break;
		case 13:
			this.cardClass = "King";
			break;
		default:
			this.cardClass = Integer.toString(this.value);
			break;
		}
	}
}
