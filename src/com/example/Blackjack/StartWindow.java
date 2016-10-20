package com.example.Blackjack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
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
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(null); // using absolute layout scheme

		// Make a quit game button to exit the program.
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.setBounds(157, 75, 117, 25);
		frame.getContentPane().add(btnQuitGame);
		btnQuitGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		// Make a start game button to initiate gameplay.
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBounds(10, 75, 123, 25);
		frame.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameWindow();
				frame.dispose();
			}
		});

		// title label for the start screen
		JLabel lblBlackjack = new JLabel("      Blackjack");
		lblBlackjack.setBounds(99, 21, 175, 23);
		frame.getContentPane().add(lblBlackjack);
	}

}
