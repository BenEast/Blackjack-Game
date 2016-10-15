package com.example.Blackjack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EndWindow {

	private JFrame frame;
	private static BlackjackMain game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndWindow window = new EndWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EndWindow() {
		game = new BlackjackMain();
		initialize();
	}

	/**
	 * Create the application.
	 */
	public EndWindow(BlackjackMain g) {
		game = g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // using absolute layout scheme

		String pScore = "Player Score: " + Integer.toString(game.getPlayerHandWeight()),
				cScore = "Computer Score: " + Integer.toString(game.getComputerHandWeight()), playerWins = "";

		if (game.playerWins()) {
			playerWins = "You win!";
		} else {
			playerWins = "You lose!";
		}

		JLabel lblPlayerwins = new JLabel(playerWins);
		lblPlayerwins.setBounds(120, 20, 55, 10);
		frame.getContentPane().add(lblPlayerwins);

		JLabel lblPlayerscore = new JLabel(pScore);
		lblPlayerscore.setBounds(10, 60, 264, 14);
		frame.getContentPane().add(lblPlayerscore);

		JLabel lblComptuerscore = new JLabel(cScore);
		lblComptuerscore.setBounds(10, 80, 264, 14);
		frame.getContentPane().add(lblComptuerscore);

		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(10, 115, 118, 23);
		frame.getContentPane().add(btnPlayAgain);
		btnPlayAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameWindow(game);
				frame.dispose();
			}
		});

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setBounds(163, 115, 111, 23);
		frame.getContentPane().add(btnExitGame);
		btnExitGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}

}
