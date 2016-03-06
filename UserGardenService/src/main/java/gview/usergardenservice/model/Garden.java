package gview.usergardenservice.model;


import org.springframework.data.annotation.Id;

import gview.usergardenservice.ClientGardenServiceException;


public class Garden {
	
	@Id
	private String id;
	private String email;
	private String gardenId;
	private String address;
	private String city;
	private boolean active;
	private Builder builder;
	
	
	//needed for spring-boot  mongodb repository (public or protected)
	protected Garden() {
		active=true;
	}
	
	 public static class Builder {
    	 
		   private String email;
		    private String gardenId;
			private String address;
			private String city;
			private boolean active;
			
	        private Builder() {
	        	active=true;
	        }
	 
	        public Builder email(String email) {
	            this.email = email;
	            return this;
	        }
	        
	        public Builder gardenId(String gardenId) {
	            this.gardenId = gardenId;
	            return this;
	        }
	       
	        public Builder city(String city) {
	            this.city = city;
	            return this;
	        }
	        public Builder address(String address) {
	            this.address = address;
	            return this;
	        }
	       
	        public Builder active(boolean active) {
	            this.active = active;
	            return this;
	        }
	 
	        public Garden build() throws ClientGardenServiceException {
	        	Garden build = new Garden(this);
	            return build;
	        }
	      
	        
	        
	    }
	
	
	public Garden(Builder builder){
		this.gardenId=builder.gardenId;
		this.address=builder.address;
		this.city=builder.city;
		this.active=active;
		this.email=builder.email;
	
	}
	
	

	 public static Builder getBuilder() {
	        return new Builder();
	    }



	public String getGardenId() {
		return gardenId;
	}




	public void setGardenId(String gardenId) {
		this.gardenId = gardenId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}

    

	
	
}
