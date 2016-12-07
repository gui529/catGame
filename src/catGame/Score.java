package catGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Score {
	ArrayList<String> myScoreNow = new ArrayList<String>();
	FileWriter myWriter;
	BufferedReader myReader;

	public Score(){
		
	}

	public static void main(String[] args) {
		Score score = new Score();
		score.setProfile("Billy",9);
		score.setProfile("Steven",4);
		score.setProfile("Eric",22);
		
		System.out.println(score.getScores(0));
		
	}
	
	public String getScores(int pos){

	
		try {
			myReader = new BufferedReader(new FileReader("scores.csv"));
			String myData1 = myReader.readLine();
			String myData2 = myReader.readLine();
			String myData3 = myReader.readLine();
			
			myScoreNow.add(myData1);
			myScoreNow.add(myData2);
			myScoreNow.add(myData3);
			myReader.close();
			}
			
			
		 catch (IOException e) {
			e.printStackTrace();}
		
		return myScoreNow.get(pos);	
		
	}
			
	public void setProfile(String name,int score){
		try {

			myWriter = new FileWriter("scores.csv",true);
			myWriter.write(score+","+name+System.lineSeparator());
			myWriter.close();
		} catch (IOException e) {
			System.out.print("Could not add scores to scoreboard.");
		}

	}	

}
