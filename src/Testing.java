import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//import factory.*;
//import gui.components.*;

public class Testing extends JFrame implements ActionListener{

	private GUIPartsRobot c;

	public Testing() {
		c = new GUIPartsRobot();
		addKeyListener(new myKeyListener());
		addMouseListener(new myMouseListener());
	}

	//set up keyListener to be used for rotations
	class myKeyListener implements KeyListener {
		public void keyPressed(KeyEvent ke) {
			switch (ke.getKeyCode()) {
			case KeyEvent.VK_R:
				c.rotate(90);
				System.out.println("Rotating");
				break;
			}
		}

		public void keyTyped(KeyEvent ke) {
		}

		public void keyReleased(KeyEvent ke) {
		}
	}
	
	//set up mouseListener to be used for moving the robot
	class myMouseListener implements MouseListener 
	{

		@Override
		public void mouseClicked(MouseEvent mA)
		{
			// move the robot when the mouse is clicked somewhere in the panel
			System.out.println("X is: " + mA.getX());
			System.out.println("Y is: " + mA.getY());
			c.xDest = mA.getX();
			c.yDest = mA.getY();
		}

		@Override
		public void mouseEntered(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//updates the robot then repaints every tick of the timer
		c.update();
		repaint();
	}	

	
	/** Main routine to get gui started */
	public static void main(String[] args) {
		Testing t = new Testing();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setSize(600, 600);
		t.setVisible(true);

		Timer timer = new Timer(10, t);
		timer.start();
	}

	//clears the background, then paints the robot
	public void paint(Graphics g) {
		g.clearRect(0, 0, 600, 600);
		Graphics2D g2 = (Graphics2D) g;
		c.draw(g2);
	}
}
