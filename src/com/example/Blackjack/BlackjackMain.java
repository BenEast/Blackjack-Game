package com.example.Blackjack;

import java.util.Scanner;

/**
 * @author Benjamin East
 *
 */
public class BlackjackMain {
	private CardDeck deck;
	private BlackjackHand player, computer;

	public BlackjackMain() {
		this.deck = new CardDeck();
		this.player = new BlackjackHand();
		this.computer = new BlackjackHand();

		// Give each player 2 cards
		for (int i = 0; i < 2; ++i) {
			addPlayerCard();
			addComputerCard();
		}
	}

	/*
	 * Outputs the info in the "hands" to the console
	 */
	public void printHands() {
		System.out.println("Player: " + this.player);
		System.out.println("Computer: " + this.computer);
	}

	public int getPlayerHandSize() {
		return player.getHandSize();
	}

	public int getComputerHandSize() {
		return computer.getHandSize();
	}

	public int getPlayerHandWeight() {
		return this.player.getTotalWeight();
	}

	public int getComputerHandWeight() {
		return this.computer.getTotalWeight();
	}

	public void addPlayerCard() {
		BlackjackCard card = this.deck.getNextCard();
		if (this.player.contains(card) || this.computer.contains(card)) {
			addPlayerCard();
		} else {
			this.player.addCard(card);
		}
	}

	public void addComputerCard() {
		BlackjackCard card = this.deck.getNextCard();
		if (this.player.contains(card) || this.computer.contains(card)) {
			addComputerCard();
		} else {
			this.computer.addCard(card);
		}
	}

	public void takePlayerTurn() {
		boolean turn_complete = false;
		Scanner scan_in = new Scanner(System.in);

		while (!turn_complete) {
			System.out.println("Total hand value: " + getPlayerHandWeight());
			System.out.println("Type \"hit\" to receive another card.");
			System.out.println("Type \"hold\" to keep your current hand.");

			String user_input = scan_in.next();

			if (user_input.equalsIgnoreCase("hit")) {
				addPlayerCard();
			} else if (user_input.equalsIgnoreCase("hold")) {
				turn_complete = true;
			} else {
				System.out.println("Invalid input. Please input \"hit\" or \"hold\"");
				System.out.print("\n\n\n\n\n\n\n\n\n\n");
			}
		}

		scan_in.close();
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
			if (pWeight < cWeight) {
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
