package com.example.Blackjack;

public class Card {

	protected String suit; // the suit of the card
	protected int value; // the value of the card (1..13) where 1 = ace, 11 =
	protected String cardClass;

	public Card() {
		this.suit = "UNDEFINED";
		this.value = -1;
		setCardClass();
	}

	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
		setCardClass();
	}

	public String getSuit() {
		return this.suit;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{S: " + this.suit + ", V: " + this.value + "}";
	}

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
