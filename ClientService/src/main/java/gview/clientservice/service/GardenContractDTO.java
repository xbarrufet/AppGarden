package gview.clientservice.service;

import java.util.List;

import gview.clientservice.model.GardenContract;

public class GardenContractDTO {

	
	private String gardenId;
	private String contractId;
	private String gardeName;
	private String location;
	private int dayOfWeek;
	private List<String> tasks;
	
	
	public GardenContractDTO(GardenContract gardenContract) {
		this.gardenId=gardenContract.getGardenId();
		this.contractId=gardenContract.getContractId();
		this.location=gardenContract.getLocation();
		this.gardeName=gardenContract.getName();
		this.dayOfWeek=gardenContract.getDayOfWeek();
		this.tasks=gardenContract.getTasks();
	}
	
	public String getGardenId() {
		return gardenId;
	}
	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getGardeName() {
		return gardeName;
	}
	public void setGardeName(String gardeName) {
		this.gardeName = gardeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public List<String> getTasks() {
		return tasks;
	}
	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
}
