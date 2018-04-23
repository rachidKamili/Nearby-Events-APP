package me.kamili.rachid.nearbyeventsapp.model;

import com.google.gson.annotations.SerializedName;

public class LongDescription{

	@SerializedName("html")
	private Object html;

	@SerializedName("text")
	private Object text;

	public void setHtml(Object html){
		this.html = html;
	}

	public Object getHtml(){
		return html;
	}

	public void setText(Object text){
		this.text = text;
	}

	public Object getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"LongDescription{" + 
			"html = '" + html + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}