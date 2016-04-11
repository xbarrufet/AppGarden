package gview.schedulerservice.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class ScheduledService {

	@Id
	private String scheduledServiceId;
	private String gardenId;
	private String clientId;
	private String adress;
	private String clientName;
	private Date date;
	private List<Task> tasks;
	private String status;
	
	public static final String STATUS_PENDING="PENDING";
	public static final String STATUS_COMPLETE="COMPLETE";
	public static final String STATUS_PARTIAL="PARTIAL";
	
	public ScheduledService() {
		
	}
	
	public ScheduledService(Builder builder) {
		
	}
	
	
	public String getScheduledServiceId() {
		return scheduledServiceId;
	}
	public void setScheduledServiceId(String scheduledServiceId) {
		this.scheduledServiceId = scheduledServiceId;
	}
	public String getGardenId() {
		return gardenId;
	}
	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static class Builder {
		
		private String gardenId;
		private String clientId;
		private String adress;
		private String clientName;
		private Date date;
		private List<Task> tasks;
		private String status;
		
		public ScheduledService build() {
			return new ScheduledService(this);
		}
		
		public Builder gardenId(String gardenId) {
			this.gardenId=gardenId;
			return this;
		}
		public Builder clientId(String clientId) {
			this.clientId=clientId;
			return this;
		}
		public Builder adress(String adress) {
			this.adress=adress;
			return this;
		}
		public Builder clientName(String clientName) {
			this.clientName=clientName;
			return this;
		}
		public Builder date(Date date) {
			this.date=date;
			return this;
		}
		public Builder status(String status) {
			this.status=status;
			return this;
		}
		public Builder tasks(List<Task> tasks) {
			this.tasks=tasks;
			return this;
		}
		
	}
	
	
}
