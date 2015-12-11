package catGame;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

public class angrierDog extends Dog {
	

	public angrierDog(int dogX, int dogY) {
		super(dogX, dogY);
		try {
			dog_pic = new ImageIcon(new URL("http://icons.iconarchive.com/icons/iconka/tailwaggers/72/dog-boxer-icon.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	

	

}
