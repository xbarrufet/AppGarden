package gview.gardenservice.api;

import gview.gardenservice.model.Garden;
import gview.gardenservice.model.Garden.Builder;

public class GardenDTO {
	private String gardenCenterId;
	private String clientId;
	private String type;
	private String address;
	private String city;
	private int[] daysOfWeek;
	private String[] services;

	
	
	public GardenDTO() {
		
	}
	
	public GardenDTO(Builder builder) {
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	
	
	
	public String getGardenCenterId() {
		return gardenCenterId;
	}
	public void setGardenCenterId(String gardenCenterId) {
		this.gardenCenterId = gardenCenterId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int[] getDaysOfWeek() {
		return daysOfWeek;
	}
	public void setDaysOfWeek(int[] daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}
	
	
	
	
	public static class Builder{
		
		Builder(){
			
		}
		
		GardenDTO build() {
			GardenDTO build = new GardenDTO(this);
			return build;
		}
		}
}
