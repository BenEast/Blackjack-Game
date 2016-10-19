package com.example.Blackjack;

/**
 * @author Benjamin East
 *
 */
public class BlackjackMain {
	private CardDeck deck;
	private BlackjackHand player, computer;

	public BlackjackMain() {
		this.deck = new CardDeck();
		resetHands();
	}

	public int getPlayerHandSize() {
		return this.player.getHandSize();
	}

	public int getComputerHandSize() {
		return this.computer.getHandSize();
	}

	public int getPlayerHandWeight() {
		return this.player.getTotalWeight();
	}

	public int getComputerHandWeight() {
		return this.computer.getTotalWeight();
	}

	public void resetHands() {
		this.player = new BlackjackHand();
		this.computer = new BlackjackHand();

		for (int i = 0; i < 2; ++i) {
			addPlayerCard();
			addComputerCard();
		}
	}

	public void addPlayerCard() {
		BlackjackCard card = this.deck.getNextCard();
		if (this.player.contains(card) || this.computer.contains(card)) {
			addPlayerCard();
		} else {
			if (card.isAce()) {
				// If a value of 11 makes the player lose, force the card to be
				// worth 1
				if (getPlayerHandWeight() + 11 > 21) {
					card.setWeight(1);
				} else {
					// handle ace
					card.setWeight(11);
				}
			}

			this.player.addCard(card);
		}
	}

	public void addComputerCard() {
		BlackjackCard card = this.deck.getNextCard();
		if (this.player.contains(card) || this.computer.contains(card)) {
			addComputerCard();
		} else {
			// Computer always takes greedy route for aces
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

	public String displayPlayerHand() {
		return player.toString();
	}

	public String displayComputerHand() {
		return computer.toString();
	}

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

	public void takeComputerTurn() {
		// If computer's total is 16 or less, take another card
		while (getComputerHandWeight() < 17) {
			addComputerCard();
		}
	}
}
