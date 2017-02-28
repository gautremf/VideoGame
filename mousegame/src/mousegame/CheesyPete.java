/**
 * 
 */
package mousegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @author TaylorJenkins
 * @version 0.0.0
 */
public class CheesyPete extends JPanel{

	/**
	 * Global Variables
	 */
	private static final long serialVersionUID = 1L;
	static int screenMaxX = 650;
	static int screenMaxY = 700;
	
	//Keys used for moving
	int leftArrow = 0;
	int rightArrow = 0;
	int jump = 0;
	int push = 0;
	
	//Used for the game score.
	int gameScore = 0;
	int gameOver = 0;
	
	//MouseGame mainPanel (images etc);
	Image bkgrnd;
	Image mouse;
	Image mouseAlt;
	int usingAlt =0;
	int cx = 470;
	int cy = 540;
	Image catIm;
	Image plankIm;
	Image largeCheeseIm;
	Image smallCheeseIm;
	
	Timer timerEv;
	
	public static void main(String[] args) {
		CheesyPete mainPanel = new CheesyPete();
		
		//setting up main panel.
		JFrame window = new JFrame();
		window.setTitle("CheesyPete");
		window.setSize(650,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(mainPanel);
		window.setVisible(true);
		screenMaxX = mainPanel.getWidth();
		screenMaxY = mainPanel.getHeight();
	}
	
	public CheesyPete(){
			
		setFocusable(true);
		setDoubleBuffered(true);
		
		//Images for the panel
		ImageIcon ii = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\bkgrnd.png");
		bkgrnd = ii.getImage();
		ImageIcon ii2 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\mouse.png");
		mouse = ii2.getImage();
		ImageIcon ii3 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\mouseAlt.png");
		mouseAlt = ii3.getImage();
		ImageIcon ii4 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\cat.png");
		catIm = ii4.getImage();
		ImageIcon ii5 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\plank.png");
		plankIm = ii5.getImage();
		ImageIcon ii6 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\largeCheese.png");
		largeCheeseIm = ii6.getImage();
		ImageIcon ii7 = new ImageIcon("C:\\Users\\Taylor\\Documents\\GitHub\\mousegame\\src\\images\\smallCheese.png");
		smallCheeseIm = ii7.getImage();
		timerEv = new Timer(25, new TimerClass());
		timerEv.start();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		drawScreen(g);
	}
	
	private void drawScreen(Graphics g){
		g.drawImage(bkgrnd,0,0,this);
		g.drawImage(largeCheeseIm, 300,200, this);
		g.drawImage(smallCheeseIm, 100, 200, this);
		
		if (usingAlt > 0){
			g.drawImage(mouse, cx, cy, this);
		}
		else{
			g.drawImage(mouseAlt, cx, cy, this);
		}
	}
	
	public void eventFrame(){
		//Insert Code to move characters
	}
	
	//Key Pressed Event
	public void keyPressedEvent(KeyEvent e){
		int cd = e.getKeyCode();
		char cdc = e.getKeyChar();
		if(cd== KeyEvent.VK_LEFT)
			leftArrow=1;
		if(cd== KeyEvent.VK_RIGHT)
			rightArrow=1;
		if(cdc== KeyEvent.VK_UP)
			jump=1;
		if(cdc== KeyEvent.VK_DOWN)
			push=1;
	}
	
	//Key Released Event
	public void keyReleasedEvent(KeyEvent e){
		int cd = e.getKeyCode();
		char cdc = e.getKeyChar();
		if(cd== KeyEvent.VK_LEFT)
			leftArrow=0;
		if(cd== KeyEvent.VK_RIGHT)
			rightArrow=0;
		if(cdc== KeyEvent.VK_UP)
			jump=0;
		if(cdc== KeyEvent.VK_DOWN)
			push=0;
	}
	
	class TimerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			eventFrame();
		}
	}

}
