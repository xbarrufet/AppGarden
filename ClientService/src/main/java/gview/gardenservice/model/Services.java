package gview.gardenservice.model;

import java.util.ArrayList;
import java.util.List;

public class Services {

	
	private int dayOfWeek;
	private List<Service> services;
	
	
	
	public Services() {
		this.services=new ArrayList<Service>();
	}
	
	public Services(Builder builder) {
		this.services=new ArrayList<Service>();
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
	public static class Builder {
		
		private int dayOfWeek;
		private List<Service> services;
		
		
		public Builder() {
		}
		
		public Services build() {
			return new Services(this);
		}
		
		public Builder dayOfweek(int dayOfWeek) {
			this.dayOfWeek=dayOfWeek;
			return this;
		}
		
		public Builder services(List<Service> services) {
			this.services=services;
			return this;
		}
		
	}
	
}
