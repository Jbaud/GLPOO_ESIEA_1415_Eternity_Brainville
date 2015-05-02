package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzlePanel extends JPanel {

	public PuzzlePanel()
	{
		
		this.setBackground(Color.BLACK);
		
		/*this.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < 16; i++) {
			JPanel p = new JPanel();
			p.setBackground(new Color(i * 16, i * 16, i * 16));
			this.add(p);
		}*/
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Face[] faces1 = {new Face(0, "blue", "purple", ""), new Face(0, "purple", "red", ""), new Face(0, "green", "blue", ""), new Face(0, "red", "yellow", "")};
		Face[] faces2 = {new Face(0, "", "", ""), new Face(0, "yellow", "red", ""), new Face(0, "yellow", "green", ""), new Face(0, "purple", "red", "")};
		Piece[] pieces = {new Piece(0, faces1, 0, 0, 0), new Piece(0, faces2, 0, 0, 0)};
		
		for (int i = 0; i < pieces.length; i++)
		{
			g2.drawImage(PieceSynthetizer.synthetize(pieces[i]), 100*i, 100*i, 100, 100, null);
		}
	}
}
