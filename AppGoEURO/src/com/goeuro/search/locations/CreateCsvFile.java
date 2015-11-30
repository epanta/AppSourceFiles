package com.goeuro.search.locations;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.goeuro.search.locations.place.Place;

public class CreateCsvFile {
	
	public String createFile(ArrayList locations){
	
		try{
		
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(Main.config.getProperty("ARQ_CSV_PATH"),Main.config.getProperty("APPEND_CSV_FILE").trim().toUpperCase().equals("YES")? true:false));
				   Place place = null;
				   Iterator<Place> locList = (Iterator) locations.iterator();  
			        while(locList.hasNext())  
			        {  
			        	/*bufferWriter.write(places.get("_type")+";"+places.get("_id")+";"
			 			       +places.get("name")+";"+places.get("type")+";"+places_geo_position.get("latitude")
			 			       +";"+places_geo_position.get("longitude")+"\n");
			 			       */
			        	place = (Place) locList.next();
			        	bufferWriter.write(place.get_type()+";"+place.get_id()+";"
				 			       +place.getName()+";"+place.getType()+";"+place.getGeoPosition().getLatitude()
				 			       +";"+place.getGeoPosition().getLongitude()+"\n");
			        }  
				   
				   
			   		
			bufferWriter.close();
		
		}catch (FileNotFoundException ex){
			ex.printStackTrace();
		}catch (IOException e){
			e.printStackTrace(); 
		}
		
		return "Process finished!";
	}

}
