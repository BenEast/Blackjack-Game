/**
 * 
 */
package com.example.Blackjack;

/**
 * @author Benjamin East
 *
 */
public final class BlackjackCard extends Card {

	private int weight; // the weight of the card in the game of blackjack

	public BlackjackCard() {
		super();
		setCardWeight();
	}

	public BlackjackCard(String suit, int value) {
		super(suit, value);
		setCardWeight();
	}

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

	public int getWeight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return "{S: " + this.suit + ", V: " + this.value + ", W: " + this.weight + "}";
	}

}
