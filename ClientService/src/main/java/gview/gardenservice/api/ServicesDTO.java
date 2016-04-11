package gview.gardenservice.api;

import java.util.ArrayList;
import java.util.List;

public class ServicesDTO {
	private int dayOfWeek;
	private List<ServiceDTO> services;
	
	
	
	public ServicesDTO() {
		services=new ArrayList<ServiceDTO>();
	}
	
	public ServicesDTO(Builder builder) {
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
		
		public ServicesDTO build() {
			return new ServicesDTO(this);
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
