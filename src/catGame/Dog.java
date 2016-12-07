package catGame;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Dog {
	ImageIcon dog_pic;
	private int dogX,dogY,x,y;
	
	/**
	*Initializes an image of a Dog at specified location.
	*@param dogX The starting X location of dog.
	*@param dogY The starting Y location of dog.
	*@throws Illegal Exception if dog placed at invalid location.
	**/
	public Dog(int dogX, int dogY){
		if (dogX < 0 || dogX > 1000 || dogY < 0 || dogY > 500)
			throw new IllegalArgumentException("Illegal position of Dog");

		
		try {
			dog_pic = new ImageIcon(new URL("http://s15.postimg.org/fy5znvxpz/dog.png"));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		this.dogX = dogX;
		this.dogY = dogY; 
		x = randomXLocation();
		y = randomYLocation();	}

	/**
	*@return The X coord of dog.
	**/
	public int getX(){
		return dogX;}
	
	/**
	*@return The Y coord of dog.
	**/
	public int getY(){
		return dogY;}
	
	/**
	*@return image of a dog.
	**/
	public ImageIcon getPicture(){
		return dog_pic;}
	
	/**
	*@return A random X location to place dog.
	**/
	public static int randomXLocation(){
		Random rn = new Random();
		int x = rn.nextInt(960-20+1)+20;
		return x;}
	
	/**
	*@return A random Y location to place dog.
	**/
	public static int randomYLocation(){
		Random rn = new Random();
		int y = rn.nextInt(355-110+1) + 110;
		return y;}
	
	/**
	*Sets X and Y to random X and Y coords.
	**/
	public void newMove(){
		x = randomXLocation();
		y = randomYLocation();}
	
	/**
	*Moves the dog right or left, down or up, based on Random Location selected.
	* 		
	**/
	public void moveDog(){	
	//	try {
		    if (x > dogX){
		    	dogX++;}
		    if (x < dogX){
		    	dogX--;}
		    if (y > dogY){
		    	dogY++;}
		    if (y < dogY){
		    	dogY--;}
			if (x == dogX){
				dogX = x;}
			if (y == dogY){
				dogY = y;}}
	
	public  static void main(String [] args) {
		boolean valid = false;
		while (!valid)
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Get X: ");
			int x = sc.nextInt();
			System.out.print("Get Y: ");
			int y = sc.nextInt();
			
			try {
				@SuppressWarnings("unused")
				Dog d = new Dog(x,y);
				valid = true;
				System.out.println("Sucessfully moved dog to position ("+x+","+y+")");

			} catch(IllegalArgumentException e) {
				System.out.println(e);
				System.out.println("Invalid value for x or y. Try again.");
				
			}
		}
	}
	
}

