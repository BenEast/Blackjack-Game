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

	public int getPlayerHandWeight() {
		return this.player.getTotalWeight();
	}

	public int getComputerHandWeight() {
		return this.computer.getTotalWeight();
	}

	public void addPlayerCard() {
		this.player.addCard(this.deck.getNextCard());
	}

	public void addComputerCard() {
		this.computer.addCard(this.deck.getNextCard());
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

	public void takeComputerTurn() {
		// If computer's total is 16 or less, take another card
		while (getComputerHandWeight() < 17) {
			addComputerCard();
		}
	}

	public static void main(String[] args) {
		BlackjackMain game = new BlackjackMain();

		game.takePlayerTurn();
		game.takeComputerTurn();

		int p_weight = game.getPlayerHandWeight(), c_weight = game.getComputerHandWeight();

		if (p_weight > 21) {
			System.out.println("you lose");
		} else if (c_weight > 21) {
			System.out.println("You win");
		} else if (p_weight == c_weight) {
			System.out.println("You tied");
		} else {
			if (p_weight > c_weight) {
				System.out.println("You win");
			} else {
				System.out.println("You lose");
			}
		}

		System.out.println("\n\n\nThank you for playing!");
	}

}
