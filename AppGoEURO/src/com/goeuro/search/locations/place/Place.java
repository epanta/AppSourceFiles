package com.goeuro.search.locations.place;


public class Place {

    private String _type;
    private Double _id;
    private String name;
    private String type;
    private GeoPosition geoPosition;
    
	/**
	 * @return the _type
	 */
	public String get_type() {
		return _type;
	}
	/**
	 * @param _type the _type to set
	 */
	public void set_type(String _type) {
		this._type = _type;
	}
	/**
	 * @return the _id
	 */
	public Double get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(Double _id) {
		this._id = _id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the geoLocations
	 */
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}
	/**
	 * @param geoLocations the geoLocations to set
	 */
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
    
    

}
