package com.example.Blackjack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AceWindow {

	private JFrame frame;
	private int aceVal;
	private boolean buttonPressed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceWindow window = new AceWindow();
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
	public AceWindow() {
		this.buttonPressed = false;
		this.aceVal = 0;
		initialize();
	}

	public int getAceVal() {
		return this.aceVal;
	}

	public boolean buttonPressed() {
		return this.buttonPressed;
	}
	
	public void setVisible(boolean val) {
		frame.setVisible(val);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(null);

		if (!buttonPressed) {
			JButton btnPoint = new JButton("1 Point");
			btnPoint.setBounds(82, 120, 89, 23);
			frame.getContentPane().add(btnPoint);
			btnPoint.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					aceVal = 1;
					buttonPressed = true;
					frame.dispose();
				}
			});

			JButton btnPoints = new JButton("11 Points");
			btnPoints.setBounds(262, 120, 89, 23);
			frame.getContentPane().add(btnPoints);
			btnPoints.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					aceVal = 11;
					buttonPressed = true;
					frame.dispose();
				}
			});
		}
		
		JLabel lblAcewarning = new JLabel("You have been dealt an ace.");
		lblAcewarning.setBounds(143, 28, 179, 14);
		frame.getContentPane().add(lblAcewarning);

		JLabel lblAcechoice = new JLabel("Would you like the card to be worth 1 or 11 points?");
		lblAcechoice.setBounds(95, 53, 294, 14);
		frame.getContentPane().add(lblAcechoice);

		frame.setVisible(true);
	}

}
