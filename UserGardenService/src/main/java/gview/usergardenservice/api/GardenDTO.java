package gview.usergardenservice.api;

import java.util.ArrayList;
import java.util.List;

import gview.usergardenservice.ClientGardenServiceException;
import gview.usergardenservice.EmailValidator;


public class GardenDTO {

	private String email;
	private String gardenId;
	private String address;
	private String city;
    
   

    private GardenDTO(Builder builder) {
        super();
    	this.email=builder.email;
    	this.gardenId=builder.gardenId;
    	this.address=builder.address;
    	this.city=builder.city;
    }
    
    public static Builder getBuilder(){
    	return new Builder();
    }
    
		
	
	 public String getEmail() {
		return email;
	}

	public String getGardenId() {
		return gardenId;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}



	public static class Builder {
	    	 
		    private String email;
		    private String gardenId;
		    private String address;
			private String city;
	        private Builder() {}
	 
	        public Builder email(String email) {
	            this.email = email;
	            return this;
	        }
	        public Builder gardenId(String gardenId) {
	            this.gardenId = gardenId;
	            return this;
	        }
	        public Builder address(String address) {
	            this.address = address;
	            return this;
	        }
	        public Builder city(String city) {
	            this.city = city;
	            return this;
	        }
	 
	        public GardenDTO build() throws ClientGardenServiceException {
	        	GardenDTO build = new GardenDTO(this);
	            build.checkEmail(build.getEmail());
	            return build;
	        }
	    }
	 
	 private void checkEmail(String email) throws ClientGardenServiceException {   	
	    	if(email.isEmpty()) throw new ClientGardenServiceException("email can't be null");
	    	if(!EmailValidator.validate(email)) throw new ClientGardenServiceException("email is not valid");
	 
	    }
    
	
}
