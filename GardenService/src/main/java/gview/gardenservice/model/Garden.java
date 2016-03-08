package gview.gardenservice.model;

import org.springframework.data.annotation.Id;

public class Garden {

	@Id
	private String gardenId;
	private String gardenCenterId;
	private String clientId;
	private String type;
	private String address;
	private String city;
	private int[] daysOfWeek;
	private String[] services;
	private boolean active;
	
	public final static String OPEN_CONTRACT = "OPEN_CONTRACT"; 
	public final static String TASKS_CONTRACT = "TASKS_CONTRACT";
	
	public Garden() {
		this.active=true;
	}
	
	public Garden(Builder builder) {
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	
	
	public String getGardenId() {
		return gardenId;
	}
	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
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
	
	
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}




	public static class Builder{
		
		Builder(){
			
		}
		
		public Garden build() {
			Garden build = new Garden(this);
			return build;
		}
		}
}
	
