package com.example.Blackjack;

public class Card {

	protected String suit; // the suit of the card
	protected int value; // the value of the card (1..13) where 1 = ace, 11 =

	public Card() {
		this.suit = "UNDEFINED";
		this.value = -1;
	}

	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
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
	
}
