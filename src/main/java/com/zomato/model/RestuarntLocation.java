package com.zomato.model;


public class RestuarntLocation {
String address;
String locality;
String city ;
String latitude ;
String locality_verbose;
String longitude ;
String zipcode;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}
public String getLocality_verbose() {
	return locality_verbose;
}
public void setLocality_verbose(String locality_verbose) {
	this.locality_verbose = locality_verbose;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public RestuarntLocation() {
	super();
	// TODO Auto-generated constructor stub
}
public RestuarntLocation(String address, String locality, String city, String latitude, String locality_verbose,
		String longitude, String zipcode) {
	super();
	this.address = address;
	this.locality = locality;
	this.city = city;
	this.latitude = latitude;
	this.locality_verbose = locality_verbose;
	this.longitude = longitude;
	this.zipcode = zipcode;
}






}
