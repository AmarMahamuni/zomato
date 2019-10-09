package com.zomato.model;

public class Restuarant {
	String id;
	RestuarntLocation restuarntlocation;
	String name;
	String timings;
	long average_cost_for_two;
	String currency;
	String phone_numbers;
	String thumb;
	
	
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public Restuarant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restuarant(String id, RestuarntLocation restuarntlocation, String name, String timings,
			long average_cost_for_two, String currency, String phone_numbers, String thumb) {
		super();
		this.id = id;
		this.restuarntlocation = restuarntlocation;
		this.name = name;
		this.timings = timings;
		this.average_cost_for_two = average_cost_for_two;
		this.currency = currency;
		this.phone_numbers = phone_numbers;
		this.thumb=thumb;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RestuarntLocation getRestuarntlocation() {
		return restuarntlocation;
	}
	public void setRestuarntlocation(RestuarntLocation restuarntlocation) {
		this.restuarntlocation = restuarntlocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public long getAverage_cost_for_two() {
		return average_cost_for_two;
	}
	public void setAverage_cost_for_two(long average_cost_for_two) {
		this.average_cost_for_two = average_cost_for_two;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPhone_numbers() {
		return phone_numbers;
	}
	public void setPhone_numbers(String phone_numbers) {
		this.phone_numbers = phone_numbers;
	}
	
	

}
