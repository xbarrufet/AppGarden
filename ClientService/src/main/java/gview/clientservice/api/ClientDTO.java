package gview.clientservice.api;



public class ClientDTO {

	
	private String clientId;
	private String name;
	private String address;
	private String city;
	private String email;
	private String phone;
	private boolean	active;
	
	public ClientDTO(){
		this.active=true;
	}
	
	public ClientDTO(Builder builder){
		
		
		this.clientId=builder.clientId;
		this.name=builder.name;
		this.address=builder.address;
		this.city=builder.city;
		this.email=builder.email;
		this.phone=builder.phone;
		this.active=builder.active;
	}
	
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	
	
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
	   	 
		private String clientId;
		private String name;
		private String address;
		private String city;
		private String email;
		private String phone;
		private boolean	active;
		
        private Builder() {}
 
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder clientId(String clientId) {
            this.clientId = clientId;
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
 
        public Builder active(boolean active) {
            this.active = active;
            return this;
        } 
        
        public ClientDTO build()  {
        	ClientDTO build = new ClientDTO(this);
        		
            return build;
        }
	}
}
