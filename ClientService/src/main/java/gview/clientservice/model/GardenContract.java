package gview.clientservice.model;

import java.util.List;

import gview.clientservice.ClientServiceException;


public class GardenContract {

	private String gardenId;
	private String contractId;
	private String name;
	private String location;
	private int dayOfWeek;
	private List<String> tasks;
	
	//needed for spring-boot  mongodb repository (public or protected)
	protected GardenContract() {
		
	}
	
	 public static class Builder {
    	 
		    private String gardenId;
			private String contractId;
			private String name;
			private String location;
			private int dayOfWeek;
			private List<String> tasks;
	        private Builder() {}
	 
	        public Builder gardenId(String gardenId) {
	            this.gardenId = gardenId;
	            return this;
	        }
	        public Builder contractId(String contractId) {
	            this.contractId = contractId;
	            return this;
	        }
	        public Builder name(String name) {
	            this.name = name;
	            return this;
	        }
	        public Builder location(String location) {
	            this.location = location;
	            return this;
	        }
	        public Builder dayOfWeek(int dayOfWeek) {
	            this.dayOfWeek = dayOfWeek;
	            return this;
	        }
	        public Builder tasks(List<String> tasks) {
	        	this.tasks=tasks;
	        	return this;
	        }
	 
	        public GardenContract build() throws ClientServiceException {
	        	GardenContract build = new GardenContract(this);
	            return build;
	        }
	    }
	
	
	public GardenContract(Builder builder){
		this.gardenId=builder.gardenId;
		this.contractId=builder.contractId;
		this.name=builder.name;
		this.location=builder.location;
		this.dayOfWeek=builder.dayOfWeek;
		this.tasks=builder.tasks;
	}
	
	

	 public static Builder getBuilder() {
	        return new Builder();
	    }



	public String getGardenId() {
		return gardenId;
	}



	public String getContractId() {
		return contractId;
	}



	public void setName(String name) {
		this.name = name;
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



	public String getName() {
		return name;
	}



	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}



	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	
	
	
	
	
	
}
