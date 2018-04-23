package me.kamili.rachid.nearbyeventsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseData{

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("events")
	private List<Event> events;

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setEvents(List<Event> events){
		this.events = events;
	}

	public List<Event> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"pagination = '" + pagination + '\'' + 
			",events = '" + events + '\'' + 
			"}";
		}
}