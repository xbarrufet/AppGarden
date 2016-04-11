package gview.gardenservice.model;

public class Service {

	private String description;
	private String id;
	
	public Service() {
		
	}
	
	public Service(Builder builder) {
		
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
		
		public  Service build(){
			return new Service(this);
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
