package gview.incidentservice.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import gview.incidentservice.model.Incident;
import gview.incidentservice.model.Incident.Builder;

public class IncidentDTO {

	@Id
	private String incidenceId;
	@Indexed
	private String gardenId;
	private String description;
	private String status;
	
	public void setStatus(String status) {
		this.status = status;
	}

	
	public IncidentDTO() {
	
	}
	
	
	public IncidentDTO(Builder builder) {
		
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


	public static class Builder {
		
		public IncidentDTO build() {
			return new IncidentDTO(this);
		}
		
	}
}

