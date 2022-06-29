package src.yugioh.board.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class reader {
	public static void readCSV(String path) throws IOException{ //ie Database-Dragons_20310.csv
		File f = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String thisLine="";
		while((thisLine=br.readLine())!=null){
		String [] currentLineArray = thisLine.split((",")); //ie arr[0] =  "Shenron" arr[2] = "10"
		//now you have the line in the array as strings do whatever you want
		//when the end of the loop is reached, it reads a new line and continues unless the file ends
		//i don't know the format da monster wla card wla eh fa msh ha3rf a3mlha
		}
		//closing the reader after I am finished
		br.close();
	}
}
