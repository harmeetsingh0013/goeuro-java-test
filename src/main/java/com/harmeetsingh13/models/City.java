/**
 * 
 */
package com.harmeetsingh13.models;

import java.util.Map;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class City {

	private String _id;
	private String key;
	private String name;
	private String fullName;
	private String iata_airport_code;
	private String type;
	private String country;
	private Map<String, String> geo_position;
	private Integer locationId;
	private Boolean inEurope;
	private String countryCode;
	private Boolean coreCountry;
	private Double distance;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(Map<String, String> geo_position) {
		this.geo_position = geo_position;
	}

	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Boolean getInEurope() {
		return inEurope;
	}
	public void setInEurope(Boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Boolean getCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return _id + ", " + name + ", " + type + ", " + geo_position.getOrDefault("latitude", "0") + ", " + geo_position.getOrDefault("longitude", "0");
	}
}
