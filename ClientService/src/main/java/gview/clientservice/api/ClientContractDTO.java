package gview.clientservice.api;

import java.util.List;

public class ClientContractDTO {

	private String email;
	private String gardenId;
	private String contractId;
	private String gardenName;
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
	public String getGardenName() {
		return gardenName;
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
