/**
 * 
 */
package com.goeuro.search.locations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.goeuro.search.locations.json.GoEuroJSON;
import com.goeuro.search.locations.place.Place;

/**
 * @author Edvaldo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static Properties config = new Properties();
	private static String arquivo = "config.ini";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 1)	{
			
			try {
				config.load(new FileInputStream(arquivo));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			GoEuroJSON geJson = new GoEuroJSON();
			ArrayList<Place> placesList = geJson.start(args[0]);
			
			CreateCsvFile cvs = new CreateCsvFile();
			System.out.println();
			System.out.println(cvs.createFile(placesList));
		} else {
		    System.out.println("Usage: java GoEuroTest <STRING>");
		    return;
		}

	}

}
