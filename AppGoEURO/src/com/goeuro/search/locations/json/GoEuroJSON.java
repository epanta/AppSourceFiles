package com.goeuro.search.locations.json;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.goeuro.search.locations.Main;
import com.goeuro.search.locations.connection.GoEuroConnection;
import com.goeuro.search.locations.place.GeoPosition;
import com.goeuro.search.locations.place.Place;
import com.google.gson.Gson;

public class GoEuroJSON {
	
	private static final String HTTPS_JSON_GOEURO =  Main.config.getProperty("HTTPS_JSON_GOEURO");

	private static String callGoEuroConnection(String place) throws IOException{
		GoEuroConnection geConnection = new GoEuroConnection();
		String goEuroReturnJson = geConnection.goEuroURL(HTTPS_JSON_GOEURO+place);
		return goEuroReturnJson;
	}
	
	public ArrayList start(String host){
		Map map = null;
		ArrayList<Place> locations = new ArrayList<Place>();  
		
		try {
			String objJson = callGoEuroConnection(host);
			Gson gson = new Gson();
			map = gson.fromJson(objJson, Map.class);
			Place place = null;
			GeoPosition geoPosition = null;
			
			
			List<Map> placeList = (List<Map>) map.get("results");
			   for(Map places: placeList){
				   
				   Map<String, Double> places_geo_position = (Map<String, Double>) places.get("geo_position");		   
				   
				   place = new Place();
				   geoPosition = new GeoPosition();
		 		   place.set_type((String)places.get("_type"));
				   place.set_id((Double)places.get("_id"));
				   place.setName((String)places.get("name"));
				   place.setType((String)places.get("type"));
				   geoPosition.setLatitude((Double)places_geo_position.get("latitude"));
				   geoPosition.setLongitude((Double)places_geo_position.get("longitude"));
				   place.setGeoPosition(geoPosition);
				   
				   locations.add(place);
			   }
			System.out.println(gson.toJson(map));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return locations;
	}

}
