package gview.clientservice.api;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {
	private int dayOfWeek;
	private List<ServiceDTO> services;
	
	
	
	public ScheduleDTO() {
		services=new ArrayList<ServiceDTO>();
	}
	
	public ScheduleDTO(Builder builder) {
		services=new ArrayList<ServiceDTO>();
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<ServiceDTO> getServices() {
		return services;
	}

	public void setServices(List<ServiceDTO> services) {
		this.services = services;
	}
	
	
	public static class Builder {
		
		private int dayOfWeek;
		private List<ServiceDTO> services;
		
		public Builder() {
		}
		
		public ScheduleDTO build() {
			return new ScheduleDTO(this);
		}
		
		public Builder dayOfweek(int dayOfWeek) {
			this.dayOfWeek=dayOfWeek;
			return this;
		}
		
		public Builder services(List<ServiceDTO> services) {
			this.services=services;
			return this;
		}
		
	}
	
}
