package gview.incidentservice.model;

import org.springframework.data.annotation.Id;

public class Incidence {

	
	@Id
	private String incidenceId;
	private String gardenId;
	private String description;
	private String status;
	
	public Incidence() {
		
	}
	
	
	public Incidence(Builder builder) {
		
	}
	
	public static Builder getBuilder(){
		return new Builder();
	}
	
	
	
	
	public String getIncidenceId() {
		return incidenceId;
	}


	public void setIncidenceId(String incidenceId) {
		this.incidenceId = incidenceId;
	}


	public String getGardenId() {
		return gardenId;
	}


	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}




	public static class Builder {
		
		public Incidence build() {
			return new Incidence(this);
		}
		
	}
	
}
