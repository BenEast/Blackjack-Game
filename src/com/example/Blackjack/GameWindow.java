package com.example.Blackjack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GameWindow {

	private JFrame frame;
	private BlackjackMain game;
	private HashMap<String, JLabel> playerCardLabels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		this.game = new BlackjackMain();
		this.playerCardLabels = new HashMap<String, JLabel>();
		initialize();
	}

	public GameWindow(BlackjackMain g) {
		this.game = g;
		this.game.resetHands();
		this.playerCardLabels = new HashMap<String, JLabel>();
		initialize();
	}

	// Generates a series of labels to represent each card in the player's hand
	private void makePlayerCardLabels() {
		int yVal = 300; // the y value of the label in the pane

		for (String card : game.displayPlayerHand().split("\n")) {
			if (!playerCardLabels.containsKey(card)) {
				JLabel lblCard = new JLabel(card);
				lblCard.setBounds(23, yVal, 550, 14);
				frame.getContentPane().add(lblCard);

				// store the label in case we need it again
				playerCardLabels.put(card, lblCard);
			}

			yVal += 15; // always increment to ensure the labels are properly
						// spaced
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(null); // using absolute layout scheme

		makePlayerCardLabels();

		JButton btnHold = new JButton("Hold");
		btnHold.setBounds(59, 73, 89, 23);
		frame.getContentPane().add(btnHold);
		btnHold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.takeComputerTurn();
				new EndWindow(game);
				frame.dispose();
			}
		});

		JLabel lblPlayerscore = new JLabel("Player Score: " + Integer.toString(game.getPlayerHandWeight()));
		lblPlayerscore.setBounds(23, 280, 550, 14);
		frame.getContentPane().add(lblPlayerscore);

		JLabel lblComputerscore = new JLabel("Comptuer Score: ?");
		lblComputerscore.setBounds(23, 240, 550, 14);
		frame.getContentPane().add(lblComputerscore);

		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(59, 39, 89, 23);
		frame.getContentPane().add(btnHit);
		btnHit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.addPlayerCard();

				// update displays of scores
				lblPlayerscore.setText("Player Score: " + Integer.toString(game.getPlayerHandWeight()));
				makePlayerCardLabels();
				
				// Hide the button if the player meets or exceeds 21 points
				if(game.getPlayerHandWeight() > 21) {
					btnHit.setVisible(false);
				}
				frame.repaint();
			}
		});

		frame.setVisible(true);
	}
}
