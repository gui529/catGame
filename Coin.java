package catGame;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Coin {
	static ImageIcon coin_pic;
	private int coinX,coinY;
	
	/**
	*Initialize position of first coin at specified location and location of file.
	*@param coinX X location of first coin.
	*@param coinY Y location of first coin.
	*@throws Exception error if invalid X and Y coord of coin.
	*@throws Exception if path file not specified.
	**/
	public Coin(int coinX, int coinY){
		if (coinX >  1000 || coinX < 0 || coinY > 500 || coinY < 0)
			throw new IllegalArgumentException("Coin cannot be outside Map.");
		
		this.coinX = coinX;
		this.coinY = coinY;
		try {
			coin_pic = new ImageIcon(new URL("http://s3.postimg.org/430jccr8v/coin.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*Generates a random X and Y position for new coin.
	**/
	public void spawnCoin(){
		Random rn = new Random();
		coinX = rn.nextInt(980-20+1)+20;
		coinY = rn.nextInt(355-110+1) + 110;
		assert coinX < 1000 && coinY < 500;}
	
	/**
	*@return X coord of coin.
	**/
	public int getX(){
		return coinX;}
	
	/**
	*@return Y coord of coin.
	**/
	public int getY(){
		return coinY;}
	
	/**
	*@return Image of Coin.
	**/
	public ImageIcon getPicture(){
		return coin_pic;}

	public  static void main(String [] args) {
		boolean spawned = false;
		while (!spawned)
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("We have no coins in the map, where should one be place?");
			System.out.print("X position of coin: ");
			int x = in.nextInt();
			System.out.print("Y position of coin: ");
			int y = in.nextInt();
		
		try {
			@SuppressWarnings("unused")
			Coin coin = new Coin(x,y);
			spawned = true;
			System.out.println("Sucessfully placed coin at position ("+x+","+y+")");

		} catch(IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("Invalid value for x or y. Try again.");
			
		}
		}
	}
}



