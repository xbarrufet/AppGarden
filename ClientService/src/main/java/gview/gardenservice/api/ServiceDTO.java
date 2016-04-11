package gview.gardenservice.api;

import gview.gardenservice.model.Service;
import gview.gardenservice.model.Service.Builder;

public class ServiceDTO {

	private String description;
	private String id;
	
	public ServiceDTO() {
		
	}
	
	public ServiceDTO(Builder builder) {
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static class Builder {
		private String description;
		private String id;
		
		public  ServiceDTO build(){
			return new ServiceDTO(this);
		}
		public Builder id(String id) {
			this.id=id;
			return this;
		}
		
		public Builder description(String description) {
			this.description=description;
			return this;
		}
		
	}
	
}
