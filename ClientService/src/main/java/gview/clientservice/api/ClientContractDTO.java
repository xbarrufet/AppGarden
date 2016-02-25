package gview.clientservice.api;

import java.util.ArrayList;
import java.util.List;

public class ClientContractDTO {

	private String email;
	private String gardenId;
	private String contractId;
	private String gardenName;
	private String location;
	private int dayOfWeek;
	private List<String> tasks;
	
	private Builder builder;
	public ClientContractDTO() {
		
	}
	
	public Builder getBuilder() {
		return this.builder;
	}
	
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
	
	class Builder {
		private String email;
		private String gardenId;
		private String contractId;
		private String gardenName;
		private String location;
		private int dayOfWeek;
		private List<String> tasks;
		
		Builder email(String email) {
			this.email=email;
			return this;
		}
		Builder contractId(String contractId) {
			this.contractId=contractId;
			return this;
		}
		Builder gardenId(String gardenId) {
			this.gardenId=gardenId;
			return this;
		}
		Builder gardenName(String gardenName) {
			this.gardenName=gardenName;
			return this;
		}
		Builder location(String location) {
			this.location=location;
			return this;
		}
		Builder dayOfWeek(int email) {
			this.dayOfWeek=dayOfWeek;
			return this;
		}
		
		Builder tasks(List<String> tasks) {
			this.tasks=tasks;
			return this;
		}
		
		
	}
	
}
