package catGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing. * ;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	private JTextField username;
	public static boolean gamestart;
	private boolean gameover;
	public int score;
	private Mouse mouse;
	private Image dbImage;
	public Graphics dbg;
	private Image cat_pic,
	dog_pic,
	map_pic,
	still_cat,
	cat_dead,
	cat_left,
	cat_right,
	coin_pic,
	adog_pic;
	private Cat myCat;
	private Map map;
	private Coin coin;
	private String playerName;
	private static Score scoreCard;
	public String barkSpeech;
	public boolean changeSpeech;

	private Dog dogs[] = new Dog[3];

	public GameWindow() {

		dogs[1] = new Dog(744, 144);
		dogs[2] = new Dog(844, 344);
		dogs[0] = new angrierDog(644, 244);

		myCat = new Cat();
		coin = new Coin(500, 250);
		map = new Map();
		gamestart = false;
		gameover = false;
		scoreCard = new Score();
		score = 0;
		////////////////////////////
		ImageIcon i = myCat.getPicture();
		ImageIcon j = dogs[1].getPicture();
		ImageIcon ja = dogs[0].getPicture();

		ImageIcon k = map.getPicture();
		ImageIcon l = myCat.getstillPicture();
		ImageIcon m = myCat.getRightPicture();
		ImageIcon n = myCat.getLeftPicture();
		ImageIcon o = myCat.getDeadPicture();
		ImageIcon p = coin.getPicture();

		dog_pic = j.getImage();
		adog_pic = ja.getImage();
		cat_pic = i.getImage();
		map_pic = k.getImage();
		still_cat = l.getImage();
		cat_right = m.getImage();
		cat_left = n.getImage();
		cat_dead = o.getImage();
		coin_pic = p.getImage();
		///////////////////////////////////////////
		mouse = new Mouse(this);
		addMouseListener(mouse);

		setTitle("Run Kitty Run!");
		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cat_pic = still_cat;
	}
	
	
	

	public void paint(Graphics g) {

		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public int getx() {
		return myCat.getX();
	}
	public int gety() {
		return myCat.getY();

	}
		
	public void randomMove(){
		
		//thread that generates a new move for the dogs
		new Thread(new Runnable()
	    {
	      public void run()
	      {
	        while(true)
	        {
				dogs[0].newMove();
				dogs[1].newMove();
				dogs[2].newMove();
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        	
	        }
	      }
	      
	    }).start();
		
		
		new Thread(new Runnable()
	    {
	      public void run()
	      {
	        while(true)
	        {
	        	changeSpeech = true;
	    		try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        	
	        }
	      }
	      
	    }).start();
	
	}

	synchronized void barkDog(String speech) {
		
		
		if (changeSpeech == true )
		{	
			changeSpeech = false;
			barkSpeech = speech;		

		}
		
}

	
	public void paintDog() throws InterruptedException{
				
			   
		Thread t1 = new Thread("Boxer Dog Thread"){		
	      public void run()
	      {
	    	  	    	  
	        while(true)
	        {
	        	dogs[0].moveDog();
	        	repaint();
	        	barkDog("Bark! Bark! >:]  I'm going to get you!");
	        	try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }		
	        
	        
	        
	      }		
	    };
		


		
		//Thread that controls the slower regular dogs.
		Thread t2 = new Thread("Regular Dog Thread"){		
	      public void run()
	      {
	        while(true)
	        {
	        	dogs[2].moveDog();
	        	dogs[1].moveDog();
	        	repaint();
	        	barkDog("ARGHH! Come here! Bark Bark!");

	    		try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        	
	        }
	      }
	    };
	    
	    t1.start();
	    t2.start();

		
	}
	public void paintComponent(Graphics g) {
		
			  
		if (gamestart) {

			g.drawImage(map_pic, 0, 0, null); //DRAW Map
			g.drawImage(adog_pic, dogs[0].getX(), dogs[0].getY(), null); //DRAW DOG
			g.drawImage(dog_pic, dogs[1].getX(), dogs[1].getY(), null); //DRAW DOG
			g.drawImage(dog_pic, dogs[2].getX(), dogs[2].getY(), null); //DRAW DOG
			g.drawImage(coin_pic, coin.getX(), coin.getY(), null); //DRAW COIN
			g.setFont(new Font("Arial", Font.BOLD, 40)); ///DRAW SCORE
			g.setColor(Color.GREEN);
			g.drawString("Score: " + score, 450, 100);
			g.drawString(barkSpeech, 50,490);


			if (moveCat() == true) { //DRAW CAT
				g.drawImage(cat_pic, myCat.getX() - 53, myCat.getY() - 32, null);
			} 
			else {

				g.drawImage(cat_pic, myCat.getX() - 53, myCat.getY() - 32, null); //DRAW CAT

				if (gameover) {
					g.setColor(Color.RED);
					g.drawString("Game Over", 400, 450);
					//g.setColor(Color.CYAN);
					//g.fillRect(100, 50, 200, 50);
					//g.fillRect(750, 50, 150, 50);
					g.setColor(Color.BLACK);
					//g.drawString("RESTART", 110, 90);
					//g.drawString("QUIT", 780, 90);
					//g.setColor(Color.CYAN);
					//g.fillRect(25, 380, 150, 150);
					//g.setColor(Color.BLACK);
					//g.setFont(new Font("Arial", Font.BOLD, 20));
					//g.drawString("Last 3 Scores", 40, 400);
					//g.drawString(">| " + scoreCard.getScores(0), 40, 425);
					//g.drawString(">| " + scoreCard.getScores(1), 40, 445);
					//g.drawString(">| " + scoreCard.getScores(2), 40, 465);
					
					return;
					

				}
				return;
			}
		}
		////MENU
		else {

			//username = new JTextField("Player");
			//username.setFont(new Font("Arial", Font.BOLD, 40));
			//add(username);
			//username.setLocation(300, 300);
			//username.setSize(400, 100);
			g.fillRect(0, 0, 1000, 500);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.setColor(Color.GREEN);
			g.drawString("Run Kitty Run!", 350, 130);
			g.setColor(Color.CYAN);
			g.fillRect(150, 200, 300, 100);
			g.setColor(Color.CYAN);
			g.fillRect(500, 200, 300, 100);
			g.setColor(Color.BLACK);
			g.drawString("Start", 250, 260);
			g.drawString("Quit", 600, 260);
			g.setColor(Color.RED);
			//g.drawString("Type your name and press START to began.",100,480);
			return;

		}

		//repaint();
	}

	public boolean moveCat() {
		if (mouse.getXDirection() == 1) {
			cat_pic = cat_right;
		}
		if (mouse.getXDirection() == -1) {
			cat_pic = cat_left;
		}
		if (mouse.getYCoord() == myCat.getY()) {
			mouse.setYDirection(0);
		}
		if (mouse.getXCoord() == myCat.getX()) {
			mouse.setXDirection(0);
		}
		if (mouse.getXCoord() == myCat.getX() && mouse.getYCoord() == myCat.getY()) {
			cat_pic = still_cat;
			return false;
		}
		if (myCat.getY() < 110) {
			myCat.setCatY(110);
			cat_pic = still_cat;
			return false;
		}
		if (myCat.getY() > 355) {
			myCat.setCatY(355);
			cat_pic = still_cat;
			return false;
		}

		///Intersection Check
		Rectangle r1 = new Rectangle(myCat.getX(), myCat.getY(), 50, 50);
		Rectangle r2 = new Rectangle(dogs[0].getX() + 60, dogs[0].getY() + 40, 30, 30);
		Rectangle r3 = new Rectangle(dogs[1].getX() + 60, dogs[1].getY() + 40, 30, 30);
		Rectangle r4 = new Rectangle(dogs[2].getX() + 60, dogs[2].getY() + 40, 30, 30);
		Rectangle r5COIN = new Rectangle(coin.getX() + 45, coin.getY(), 25, 25);

		if (r1.intersects(r2) || r1.intersects(r3) || r1.intersects(r4)) {
			cat_pic = cat_dead;
			gameover = true;
			scoreCard.setProfile(playerName, score);

			return false;
		}

		if (r1.intersects(r5COIN)) {
			score++;
			coin.spawnCoin();

		} else {
			myCat.setCatY(myCat.getY() + mouse.getYDirection());
			myCat.setCatX(myCat.getX() + mouse.getXDirection());
		}
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		GameWindow gw = new GameWindow();

		gw.paintDog();
		gw.randomMove();
		//.barkDog("haha");


	}

}