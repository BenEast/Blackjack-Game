package com.example.Blackjack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
					EndWindow window = new EndWindow(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setVisible(boolean value) {
		frame.setVisible(value);
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
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		boolean playerWins = game.playerWins();
		String pScore = Integer.toString(game.getPlayerHandWeight()),
				cScore = Integer.toString(game.getPlayerHandWeight());

		if (playerWins) {
			JLabel lblPlayerwins = new JLabel("YOU WIN!");
			GridBagConstraints gbc_lblPlayerwins = new GridBagConstraints();
			gbc_lblPlayerwins.insets = new Insets(0, 0, 5, 0);
			gbc_lblPlayerwins.gridx = 12;
			gbc_lblPlayerwins.gridy = 6;
			frame.getContentPane().add(lblPlayerwins, gbc_lblPlayerwins);
		} else {
			JLabel lblPlayerwins = new JLabel("YOU LOSE!");
			GridBagConstraints gbc_lblPlayerwins = new GridBagConstraints();
			gbc_lblPlayerwins.insets = new Insets(0, 0, 5, 0);
			gbc_lblPlayerwins.gridx = 12;
			gbc_lblPlayerwins.gridy = 6;
			frame.getContentPane().add(lblPlayerwins, gbc_lblPlayerwins);
		}
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 11;
		gbc_verticalStrut.gridy = 0;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridheight = 2;
		gbc_horizontalStrut.gridwidth = 9;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 10;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		JLabel lblPlayerscore = new JLabel("Player: " + pScore);
		GridBagConstraints gbc_lblPlayerscore = new GridBagConstraints();
		gbc_lblPlayerscore.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerscore.gridx = 9;
		gbc_lblPlayerscore.gridy = 10;
		frame.getContentPane().add(lblPlayerscore, gbc_lblPlayerscore);

		JLabel lblComputerscore = new JLabel("Computer: " + cScore);
		GridBagConstraints gbc_lblComputerscore = new GridBagConstraints();
		gbc_lblComputerscore.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputerscore.gridx = 9;
		gbc_lblComputerscore.gridy = 11;
		frame.getContentPane().add(lblComputerscore, gbc_lblComputerscore);

		JButton btnPlayAgain = new JButton("Play Again");
		GridBagConstraints gbc_btnPlayAgain = new GridBagConstraints();
		gbc_btnPlayAgain.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlayAgain.gridx = 11;
		gbc_btnPlayAgain.gridy = 14;
		frame.getContentPane().add(btnPlayAgain, gbc_btnPlayAgain);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow newGame = new GameWindow();
				newGame.setVisible(true);
				frame.dispose();
			}
		});

		JButton btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 12;
		gbc_btnExit.gridy = 14;
		frame.getContentPane().add(btnExit, gbc_btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}

}
