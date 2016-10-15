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
	private String cardClass;
	
	public BlackjackCard() {
		super();
		setCardWeight();
		setCardClass();
	}

	public BlackjackCard(String suit, int value) {
		super(suit, value);
		setCardWeight();
		setCardClass();
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
	
	private void setCardClass() {
		switch(this.value) {
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

	protected void setWeight(int cardWeight) {
		this.weight = cardWeight;
	}
	
	public int getWeight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return this.cardClass + " of " + this.suit +  ":  " + this.weight + " points";
	}
	
	// Returns true if the card is an Ace
	public boolean isAce() {
		if(this.value == 1) {
			return true;
		} else {
			return false;
		}
	}

}
