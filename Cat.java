package catGame;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Cat {
	   static ImageIcon cat_pic, still_cat, right_cat, left_cat,cat_dead; 
	   private int catX, catY;
	   
	public Cat() {
		try {
			still_cat = new ImageIcon(new URL("http://s12.postimg.org/n005i7689/cat_STILL.png"));
			right_cat = new ImageIcon(new URL("http://s12.postimg.org/x19l598p5/cat.gif"));
			left_cat = new ImageIcon(new URL("http://s12.postimg.org/y0van7yh5/cat_LEFT.gif"));
			cat_dead = new ImageIcon(new URL("http://s12.postimg.org/6ex4ga4i1/coffin.png"));
			cat_pic = new ImageIcon(new URL("http://s12.postimg.org/x19l598p5/cat.gif"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		catX  = 40;
		catY = 140;
	}

	public int getX(){
		return catX;
	}
	public int getY(){
		return catY;
	}
	public void setCatX(int setx){
		catX = setx;
	}
	public void setCatY(int sety){
		catY = sety;
	}
	
	
	public ImageIcon getPicture(){
		return cat_pic;
	}
	public ImageIcon getRightPicture(){
		return right_cat;
	}
	public ImageIcon getDeadPicture(){
		return cat_dead;
	}
	public ImageIcon getLeftPicture(){
		return left_cat;
	}
	public ImageIcon getstillPicture(){
		return still_cat;
	}

		
		
}


