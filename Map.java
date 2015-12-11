package catGame;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Map {
	   static ImageIcon map_pic; 
	   public int catX, catY;
	   
	public Map() {

			try {
				map_pic = new ImageIcon(new URL("http://s22.postimg.org/4g9vh8jsx/map.png"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		catX  = 400;
		catY = 200;}
	
	public ImageIcon getPicture(){
		return map_pic;}
	

		
		
}


