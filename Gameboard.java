
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JPanel{

	public static void main(String[] args){
		Game g = new Game();

		JFrame frame = new JFrame("Snake");
		frame.setBounds(10, 10, 905, 700);
		frame.setBackground(Color.gray);
		frame.setResizable(false);
		frame.getContentPane().add(g);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




	}



}
