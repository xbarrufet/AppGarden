package gview.clientservice.model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

	
	private int dayOfWeek;
	private List<Service> services;
	
	
	
	public Schedule() {
		this.services=new ArrayList<Service>();
	}
	
	public Schedule(Builder builder) {
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
		
		public Schedule build() {
			return new Schedule(this);
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
