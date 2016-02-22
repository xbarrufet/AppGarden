package gview.clientservice.service;

import java.util.List;

public class ClientContractDTO {

	private String email;
	private String gardenId;
	private String contractId;
	private String gardeName;
	private String location;
	private int dayOfWeek;
	private List<String> tasks;
	public String getEmail() {
		return email;
	}
	public String getGardenId() {
		return gardenId;
	}
	public String getContractId() {
		return contractId;
	}
	public String getGardeName() {
		return gardeName;
	}
	public String getLocation() {
		return location;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public List<String> getTasks() {
		return tasks;
	}
	
	
}
