package gview.incidentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Incident {

	
	@Id
	private String incidenceId;
	@Indexed
	private String gardenId;
	private String description;
	private String status;
	
	
	public void setStatus(String status) {
		this.status = status;
	}


	public final static String STATUS_PENDING="PENDING";
	public final static String STATUS_COMPLETED="COMPLETED";
	
	public Incident() {
	
	}
	
	
	public Incident(Builder builder) {
		
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
		
		public Incident build() {
			return new Incident(this);
		}
		
	}
	
}
