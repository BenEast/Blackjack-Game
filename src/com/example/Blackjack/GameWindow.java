package com.example.Blackjack;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

	private JFrame frame;
	private BlackjackMain game;
	private String totalPHandWeight;
	private String currentPHand;
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
		updatePHandWeight();
		updateCurrentPHand();
		initialize();
	}

	public void updatePHandWeight() {
		this.totalPHandWeight = Integer.toString(game.getPlayerHandWeight());
	}
	
	public void updateCurrentPHand() {
		this.currentPHand = game.displayPlayerHand();
	}
	
	public void setVisible(boolean value) {
		frame.setVisible(value);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnHit = new JButton("Hit");
		GridBagConstraints gbc_btnHit = new GridBagConstraints();
		gbc_btnHit.insets = new Insets(0, 0, 5, 5);
		gbc_btnHit.gridx = 1;
		gbc_btnHit.gridy = 9;
		frame.getContentPane().add(btnHit, gbc_btnHit);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.addPlayerCard();
				updatePHandWeight();
				updateCurrentPHand();
				
				// we need to update what's displayed in the current frame
			}
		});

		JButton btnHold = new JButton("Hold");
		GridBagConstraints gbc_btnHold = new GridBagConstraints();
		gbc_btnHold.insets = new Insets(0, 0, 5, 5);
		gbc_btnHold.gridx = 1;
		gbc_btnHold.gridy = 10;
		frame.getContentPane().add(btnHold, gbc_btnHold);
		btnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.takeComputerTurn();

				EndWindow end = new EndWindow(game);
				end.setVisible(true);
				frame.dispose();
			}
		});

		Component rigidArea = Box.createRigidArea(new Dimension(50, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 18;
		frame.getContentPane().add(rigidArea, gbc_rigidArea);

		JLabel lblHandTotal = new JLabel("Hand Total:");
		GridBagConstraints gbc_lblHandTotal = new GridBagConstraints();
		gbc_lblHandTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblHandTotal.gridx = 1;
		gbc_lblHandTotal.gridy = 18;
		frame.getContentPane().add(lblHandTotal, gbc_lblHandTotal);

		JLabel lblPlayerweight = new JLabel(totalPHandWeight);
		GridBagConstraints gbc_lblPlayerweight = new GridBagConstraints();
		gbc_lblPlayerweight.insets = new Insets(0, 0, 0, 5);
		gbc_lblPlayerweight.gridx = 2;
		gbc_lblPlayerweight.gridy = 18;
		frame.getContentPane().add(lblPlayerweight, gbc_lblPlayerweight);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(200, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 4;
		gbc_rigidArea_1.gridy = 18;
		frame.getContentPane().add(rigidArea_1, gbc_rigidArea_1);

		JLabel lblCurrenthand = new JLabel(currentPHand);
		GridBagConstraints gbc_lblCurrenthand = new GridBagConstraints();
		gbc_lblCurrenthand.gridx = 6;
		gbc_lblCurrenthand.gridy = 18;
		frame.getContentPane().add(lblCurrenthand, gbc_lblCurrenthand);

	}

}
