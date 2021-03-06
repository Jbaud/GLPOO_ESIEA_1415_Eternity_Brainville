package main.java.gui;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import main.java.controller.Game;

public class HomePanel extends JPanel implements ActionListener {
	
	private Game game;
	
	private JButton[] levelButtons;
	
	public HomePanel(Game game) {
		this.game = game;
	
		// setPreferredSize rather than setSize because of layout manager
		// The contentPane excludes the menu
		this.setPreferredSize(new Dimension(720, 400));
		this.setBackground(new Color(200, 50, 100));
		
		JLabel title = new JLabel("Eternity", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 80));
		title.setPreferredSize(new Dimension(720, 180));
		
		JLabel credits = new JLabel("2015 - Nicolas Gattolin, Arthur Brainville, Sylvie Ye, Sébastien Raullet, Nicolas Devaux, Romain Adam", SwingConstants.CENTER);
		credits.setFont(new Font("Arial", Font.BOLD, 12));
		credits.setPreferredSize(new Dimension(720, 40));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(250, 210, 220));
		levelButtons = new JButton[this.game.getLevelCount()];
		for (int i = 0; i < levelButtons.length; i++) {
			JButton lvlButton = new JButton("Level " + (i+1));
			levelButtons[i] = lvlButton;
			buttonPanel.add(lvlButton);
			lvlButton.addActionListener(this);
		}
		
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(credits, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < this.levelButtons.length; i++) {
			if(e.getSource() == this.levelButtons[i]) {
				this.game.startGame();
				this.game.loadLevel(i+1);
			}
		}
	}
	
}
