package com.example.Blackjack;

/**
 * @author Benjamin East
 */
public class BlackjackMain {
	private BlackjackCardDeck deck; // The deck to be used by the game.
	private BlackjackHand player, computer; // A hand for the player, and one
											// hand for the computer.

	/**
	 * Creates a new deck and gives each hand 2 unique cards.
	 */
	public BlackjackMain() {
		this.deck = new BlackjackCardDeck();
		resetHands();
	}

	/**
	 * @return The number of cards in the player's hand.
	 */
	public int getPlayerHandSize() {
		return this.player.getHandSize();
	}

	/**
	 * @return The number of cards in the computer's hand.
	 */
	public int getComputerHandSize() {
		return this.computer.getHandSize();
	}

	/**
	 * @return The blackjack weight of the player's hand.
	 */
	public int getPlayerHandWeight() {
		return this.player.getTotalWeight();
	}

	/**
	 * @return The blackjack weight of the computer's hand.
	 */
	public int getComputerHandWeight() {
		return this.computer.getTotalWeight();
	}

	/**
	 * Clears both the player and computer hands, and gives each 2 cards again.
	 */
	public void resetHands() {
		this.player = new BlackjackHand();
		this.computer = new BlackjackHand();

		for (int i = 0; i < 2; ++i) {
			addPlayerCard();
			addComputerCard();
		}
	}

	/**
	 * Adds a unique card to the player's hand
	 */
	public void addPlayerCard() {
		BlackjackCard card = this.deck.getNextCard();

		// If the card is already in a hand, get a new one
		if (this.player.contains(card) || this.computer.contains(card)) {
			addPlayerCard();
		} else {
			if (card.isAce()) {
				// If a value of 11 makes the player lose, force the card to be
				// worth 1
				if (getPlayerHandWeight() + 11 > 21) {
					card.setWeight(1);
				} else {
					// PLAYER will be able to select the value of their ace
					// set to 11 for now.
					card.setWeight(11);
				}
			}

			this.player.addCard(card);
		}
	}

	/**
	 * Adds a unique card to the computer's hand.
	 */
	public void addComputerCard() {
		BlackjackCard card = this.deck.getNextCard();

		// if the card is already in a hand, get a new card.
		if (this.player.contains(card) || this.computer.contains(card)) {
			addComputerCard();
		} else {
			// Computer always takes greedy option for aces
			if (card.isAce()) {
				if (getComputerHandWeight() + 11 > 21) {
					card.setWeight(1);
				} else {
					card.setWeight(11);
				}
			}
			this.computer.addCard(card);
		}
	}

	/**
	 * @return Returns a string representation of the player's hand.
	 */
	public String displayPlayerHand() {
		return player.toString();
	}

	/**
	 * @return Returns a string representation of the computer's hand.
	 */
	public String displayComputerHand() {
		return computer.toString();
	}

	/**
	 * Determines if the player beat the computer based on the weight of each
	 * hand.
	 * 
	 * @return Returns true if the player wins, and false otherwise.
	 */
	public boolean playerWins() {
		int pWeight = this.player.getTotalWeight(), cWeight = this.computer.getTotalWeight();

		if (pWeight > 21) {
			return false;
		} else if (cWeight > 21) {
			return true;
		} else {
			if (pWeight > cWeight) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Adds cards to the computer's hand until the computer has an optimal hand.
	 */
	public void takeComputerTurn() {
		// If computer's total is 17 or less, take another card
		while (getComputerHandWeight() <= 17) {
			addComputerCard();
		}
	}
}
