package bankapp;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSV {
	
	/**
	 
	 * This function will read data from a CSV file and return a list
	 */
	public static List<String[]> read(String file){
		
		List<String[]> data = new LinkedList<String[]>();
	
			String dataRow;
			try {
				//create a buffered reader object passing in the file  that you want to read as a FileReader object
				BufferedReader br = new BufferedReader(new FileReader(file));
				//read one line at a time  and store it in the String dataRow as long as there is a line to read
				while((dataRow = br.readLine())!=null) {
				//split the row into individual elements split them at the commas
				String[] dataRecords = dataRow.split(",");
				//add the split row which is now a list of 5 things to the List of String arrays
				data.add(dataRecords);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("COULD NOT FIND FILE");
				e.printStackTrace();
				
			} catch (IOException e) {
				System.out.println("COULD NOT READ FILE");
				e.printStackTrace();
			}
			
			return data;
			}
		
		
	}

