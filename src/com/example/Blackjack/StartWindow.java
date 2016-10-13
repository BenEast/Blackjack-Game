package com.example.Blackjack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;

public class StartWindow {

	private JFrame frame;

	/**
	 * @wbp.nonvisual location=479,269
	 */

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
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		Component rigidArea = Box.createRigidArea(new Dimension(410, 20));
		frame.getContentPane().add(rigidArea);

		JButton btnStartGame = new JButton("Start Game");
		frame.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow game = new GameWindow();
				game.setVisible(true);
				frame.dispose();
			}
		});

		JButton btnExitGame = new JButton("Exit Game");
		frame.getContentPane().add(btnExitGame);
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		Component rigidArea_1 = Box.createRigidArea(new Dimension(410, 20));
		frame.getContentPane().add(rigidArea_1);

	}

}
