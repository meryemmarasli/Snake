import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class Game extends JPanel implements KeyListener, ActionListener{
	int score;


	int directionX = 0;
	int directionY = 0;
	int myIteration = 0;

	Coordinate a = new Coordinate(450, 350);
	Snake s = new Snake();
	Timer time = new Timer(1, this);



	public Game(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time.start();
	}


	public void paint(Graphics g){
		int width = 20;
		int height = 20;


		Font font = new Font("Times New Roman", Font.PLAIN, 50);
		g.setColor(Color.decode("#003300"));
		g.fillRect(25, 10, 851, 551);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 50, 60);


		g.setColor(Color.WHITE);
		ImageIcon i = new ImageIcon("snake title.jpg");;
		i.paintIcon(this,  g, 349,  10);
		g.setColor(Color.black);
		g.fillRect(26, 75, 850, 575);


			g.setColor(Color.green);
			g.drawOval(a.getX(),a.getY(), width, height);
			g.fillOval(a.getX(), a.getY(), width, height);

			g.setColor(Color.red);


		if(s.getX(0) <= 25 || s.getX(0) >= 850 || s.getY(0) <= 75 || s.getY(0) >= 625) {
			time.stop();
			g.drawString("GAME OVER!", 300, 350);
		}

		for(int x = 0; x < s.getArraySize(); x++){
			if(x== 0){
				g.drawOval(s.getX(x), s.getY(x), width, height);
				g.fillOval(s.getX(x),s.getY(x), width, height);
			}else{
				if(s.getX(x) != 0 )
					g.drawOval(s.getX(x), s.getY(x), width, height);
			}
		}


		if(a.getX() == s.getX(0) && a.getY() == s.getY(0)){

			int randX = (int)(Math.random() * 825) + 25;
			int randY = (int)(Math.random() * 550) + 75;
			int normX = 25 * (randX / 25);
			int normY = 25 * (randY / 25);

			a = new Coordinate(normX, normY);
			score++;
			s.add();
		}


		}


	public void actionPerformed(ActionEvent e){


		myIteration++;
		if (myIteration % 100!= 0)
			return;

		if (directionX != 0 || directionY != 0) {
			for (int i = s.getArraySize() - 1; i > 0; i--) {
				s.moveSnake(s.getX(i-1), s.getY(i-1), i);
			}
			s.moveSnake(s.getX(0) + directionX, s.getY(0) + directionY, 0);
		}
		repaint();
	}





	public void keyPressed(KeyEvent e)
    {

        int key = e.getKeyCode();
        int movement = 25;

        if ((key == KeyEvent.VK_LEFT))
        {
           directionX = -movement;
           directionY = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) )
        {
        	directionX = movement;
        	directionY = 0;
        }

        if ((key == KeyEvent.VK_UP) )
        {
            directionX = 0;
            directionY = -movement;
        }

        if ((key == KeyEvent.VK_DOWN))
        {
           directionX = 0;
           directionY = movement;
        }
    }

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}
