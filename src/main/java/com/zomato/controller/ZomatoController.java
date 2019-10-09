package com.zomato.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zomato.model.Restuarant;
import com.zomato.model.RestuarntLocation;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ZomatoController {

	

	@Autowired
	private RestTemplate resttemplate;
	
	@GetMapping("/")
	public String show()
	{
		return "application";
	}
	

	OkHttpClient client = new OkHttpClient();

	@GetMapping("/list/{city}")
	public JSONObject getCityDetails(@PathVariable String city) throws IOException, ParseException {
		
		String entity_type = null;
		Long entity_id = null;
		Request city_request = new Request.Builder().url("https://developers.zomato.com/api/v2.1/locations?query=" + city)
				.get().addHeader("user-key", "d120fd8c59ef08ab5b584772b0ea8a6d").build();

		Response city_response = client.newCall(city_request).execute();
		JSONParser parse = new JSONParser();
		JSONObject city_json = (JSONObject) parse.parse(city_response.body().string());
		JSONArray city_location_suggestions = (JSONArray) city_json.get("location_suggestions");
			JSONObject city_location = (JSONObject) city_location_suggestions.get(0);
			entity_type = (String) city_location.get("entity_type");
			entity_id = (Long) city_location.get("entity_id");
		
		
		Request restuarnts_request = new Request.Builder().url("https://developers.zomato.com/api/v2.1/search?entity_id="+entity_id+"&entity_type="+entity_type)
				.get().addHeader("user-key", "d120fd8c59ef08ab5b584772b0ea8a6d").build();
		Response restuarnts_response = client.newCall(restuarnts_request).execute();
		JSONObject restuarnts_json = (JSONObject) parse.parse(restuarnts_response.body().string());
		JSONArray restaurants = (JSONArray) restuarnts_json.get("restaurants");
		JSONObject restuarnt_obj=null;
		//Long a = (Long) jobj1.get("results_found");
    	for (int j = 0; j < restaurants.size(); j++) {
			JSONObject restaurant = (JSONObject) restaurants.get(j);
			 restuarnt_obj = (JSONObject) restaurant.get("restaurant");
			String c = (String) restuarnt_obj.get("name");
			System.out.println(c);
			//System.out.println(b.get("include_bogo_offers"));

		}
    	

		
		return restuarnt_obj;

	}
	RestuarntLocation restuarntLocation=null;
	Restuarant restuarnt=null;
	List<Restuarant> restuarntList=new ArrayList<>();
	
	
	@GetMapping("/restuarant/{rname}")
	public List<Restuarant> getRestuarant(@PathVariable String rname) throws IOException, ParseException {
		Request restuarnts_request = new Request.Builder().url("https://developers.zomato.com/api/v2.1/search?q=" + rname)		
				.get().addHeader("user-key", "d120fd8c59ef08ab5b584772b0ea8a6d").build();
		Response restuarnts_response = client.newCall(restuarnts_request).execute();
		JSONParser parse = new JSONParser();
		JSONObject restuarnts_json = (JSONObject) parse.parse(restuarnts_response.body().string());
		JSONArray restaurants = (JSONArray) restuarnts_json.get("restaurants");
		JSONObject restuarnt_obj=null;
		//Long a = (Long) jobj1.get("results_found");
    	for (int j = 0; j < restaurants.size(); j++) {
			JSONObject restaurant = (JSONObject) restaurants.get(j);
			 restuarnt_obj = (JSONObject) restaurant.get("restaurant");
			String c = (String) restuarnt_obj.get("name");
			JSONObject location =  (JSONObject) restuarnt_obj.get("location");
			//JSONObject city_location = (JSONObject) location.get(0);
		restuarntLocation=new RestuarntLocation((String) location.get("address"),(String)location.get("locality"),(String)location.get("city"),
				(String)location.get("latitude"),(String)location.get("locality_verbose"),(String)location.get("longitude"),(String)location.get("zipcode"));
		restuarnt=new Restuarant((String) restuarnt_obj.get("id"),restuarntLocation,(String) restuarnt_obj.get("name"),
		(String)restuarnt_obj.get("timings"),(long) restuarnt_obj.get("average_cost_for_two"),(String) restuarnt_obj.get("currency"),(String) restuarnt_obj.get("phone_numbers"),(String) restuarnt_obj.get("thumb"));
		System.out.println((String) restuarnt_obj.get("name"));
		System.out.println((String)restuarnt_obj.get("timings"));
		restuarntList.add(restuarnt);
		}
		
		return restuarntList;

	}
}
