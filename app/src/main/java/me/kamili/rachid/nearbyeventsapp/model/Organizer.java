package me.kamili.rachid.nearbyeventsapp.model;

import com.google.gson.annotations.SerializedName;

public class Organizer{

	@SerializedName("logo_id")
	private Object logoId;

	@SerializedName("num_past_events")
	private int numPastEvents;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("facebook")
	private String facebook;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private Description description;

	@SerializedName("logo")
	private Object logo;

	@SerializedName("long_description")
	private LongDescription longDescription;

	@SerializedName("id")
	private String id;

	@SerializedName("num_future_events")
	private int numFutureEvents;

	@SerializedName("url")
	private String url;

	public void setLogoId(Object logoId){
		this.logoId = logoId;
	}

	public Object getLogoId(){
		return logoId;
	}

	public void setNumPastEvents(int numPastEvents){
		this.numPastEvents = numPastEvents;
	}

	public int getNumPastEvents(){
		return numPastEvents;
	}

	public void setResourceUri(String resourceUri){
		this.resourceUri = resourceUri;
	}

	public String getResourceUri(){
		return resourceUri;
	}

	public void setFacebook(String facebook){
		this.facebook = facebook;
	}

	public String getFacebook(){
		return facebook;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setLogo(Object logo){
		this.logo = logo;
	}

	public Object getLogo(){
		return logo;
	}

	public void setLongDescription(LongDescription longDescription){
		this.longDescription = longDescription;
	}

	public LongDescription getLongDescription(){
		return longDescription;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNumFutureEvents(int numFutureEvents){
		this.numFutureEvents = numFutureEvents;
	}

	public int getNumFutureEvents(){
		return numFutureEvents;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Organizer{" + 
			"logo_id = '" + logoId + '\'' + 
			",num_past_events = '" + numPastEvents + '\'' + 
			",resource_uri = '" + resourceUri + '\'' + 
			",facebook = '" + facebook + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",logo = '" + logo + '\'' + 
			",long_description = '" + longDescription + '\'' + 
			",id = '" + id + '\'' + 
			",num_future_events = '" + numFutureEvents + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}