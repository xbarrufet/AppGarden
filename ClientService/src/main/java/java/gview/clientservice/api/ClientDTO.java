package java.gview.clientservice.api;



public class ClientDTO {

	private String gardenCenterId;
	private String clientId;
	private String name;
	private String address;
	private String city;
	private String email;
	private String phone;
	
	public ClientDTO(){
		
	}
	
	public ClientDTO(Builder builder){
		
		this.gardenCenterId=builder.gardenCenterId;
		this.clientId=builder.clientId;
		this.name=builder.name;
		this.address=builder.address;
		this.city=builder.city;
		this.email=builder.email;
		this.phone=builder.phone;
	}
	
	
	
	
	public String getGardenCenterId() {
		return gardenCenterId;
	}
	public void setGardenCenterId(String gardenCenterId) {
		this.gardenCenterId = gardenCenterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
	   	 
		private String clientId;
		private String gardenCenterId;
		private String name;
		private String address;
		private String city;
		private String email;
		private String phone;
		
        private Builder() {}
 
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        public Builder gardenCenterId(String gardenCenterId) {
            this.gardenCenterId = gardenCenterId;
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
        
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
 
        public ClientDTO build()  {
        	ClientDTO build = new ClientDTO(this);
        		
            return build;
        }
	}
}
