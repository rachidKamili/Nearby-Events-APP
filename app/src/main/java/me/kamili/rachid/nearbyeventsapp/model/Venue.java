package me.kamili.rachid.nearbyeventsapp.model;

import com.google.gson.annotations.SerializedName;

public class Venue{

	@SerializedName("address")
	private Address address;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("age_restriction")
	private Object ageRestriction;

	@SerializedName("capacity")
	private Object capacity;

	@SerializedName("longitude")
	private String longitude;

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setResourceUri(String resourceUri){
		this.resourceUri = resourceUri;
	}

	public String getResourceUri(){
		return resourceUri;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAgeRestriction(Object ageRestriction){
		this.ageRestriction = ageRestriction;
	}

	public Object getAgeRestriction(){
		return ageRestriction;
	}

	public void setCapacity(Object capacity){
		this.capacity = capacity;
	}

	public Object getCapacity(){
		return capacity;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Venue{" + 
			"address = '" + address + '\'' + 
			",resource_uri = '" + resourceUri + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",age_restriction = '" + ageRestriction + '\'' + 
			",capacity = '" + capacity + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}