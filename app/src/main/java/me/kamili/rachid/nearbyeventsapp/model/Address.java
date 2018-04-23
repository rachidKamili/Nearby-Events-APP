package me.kamili.rachid.nearbyeventsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("localized_area_display")
	private String localizedAreaDisplay;

	@SerializedName("country")
	private String country;

	@SerializedName("localized_address_display")
	private String localizedAddressDisplay;

	@SerializedName("city")
	private String city;

	@SerializedName("address_1")
	private String address1;

	@SerializedName("localized_multi_line_address_display")
	private List<String> localizedMultiLineAddressDisplay;

	@SerializedName("address_2")
	private String address2;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("region")
	private String region;

	@SerializedName("postal_code")
	private String postalCode;

	@SerializedName("longitude")
	private String longitude;

	public void setLocalizedAreaDisplay(String localizedAreaDisplay){
		this.localizedAreaDisplay = localizedAreaDisplay;
	}

	public String getLocalizedAreaDisplay(){
		return localizedAreaDisplay;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setLocalizedAddressDisplay(String localizedAddressDisplay){
		this.localizedAddressDisplay = localizedAddressDisplay;
	}

	public String getLocalizedAddressDisplay(){
		return localizedAddressDisplay;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress1(){
		return address1;
	}

	public void setLocalizedMultiLineAddressDisplay(List<String> localizedMultiLineAddressDisplay){
		this.localizedMultiLineAddressDisplay = localizedMultiLineAddressDisplay;
	}

	public List<String> getLocalizedMultiLineAddressDisplay(){
		return localizedMultiLineAddressDisplay;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}

	public String getAddress2(){
		return address2;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
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
			"Address{" + 
			"localized_area_display = '" + localizedAreaDisplay + '\'' + 
			",country = '" + country + '\'' + 
			",localized_address_display = '" + localizedAddressDisplay + '\'' + 
			",city = '" + city + '\'' + 
			",address_1 = '" + address1 + '\'' + 
			",localized_multi_line_address_display = '" + localizedMultiLineAddressDisplay + '\'' + 
			",address_2 = '" + address2 + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",region = '" + region + '\'' + 
			",postal_code = '" + postalCode + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}