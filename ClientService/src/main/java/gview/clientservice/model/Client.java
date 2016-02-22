package gview.clientservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import gview.clientservice.ClientServiceException;
import gview.clientservice.Constants;
import gview.clientservice.EmailValidator;


public class Client {

	@Id
    private String id;

    private String email;
    private String type;
    private String status;
    private String name;
    private List<GardenContract> gardens;
    
    
    public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public List<GardenContract> getGardens() {
		return gardens;
	}

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

      
    private Client(Builder builder) {
        this.email = builder.email;
        this.status = Constants.STATUS_PENDING;
    }
 
    public static Builder getBuilder() {
        return new Builder();
    }
    
    public String getEmail() {
    	return this.email;
    }

    @Override
    public String toString() {
        return String.format(
                "client[id=%s, email='%s', String='%name']",
                id, email, name);
    }
    
    public void addContract(String gardenId,String contractId,String location,int dayOfWeek,List<String> tasks) throws ClientServiceException{
    	if(this.gardens==null) 
    		this.gardens = new ArrayList<GardenContract>();
		if(this.findGarden(gardenId, contractId)==null) {
			GardenContract gardenContract = GardenContract.getBuilder()
					.contractId(contractId)
					.gardenId(gardenId)
					.location(location)
					.name(location)
					.dayOfWeek(dayOfWeek)
					.tasks(tasks).build();
			this.gardens.add(gardenContract);
		} else {
			throw new ClientServiceException(Constants.EX_GARDEN_EXIST);
    	}
    }
    
    public void activateClient(String name) throws ClientServiceException{
    	this.name=name;
    	this.status=Constants.STATUS_ACTIVE;
    }
    
    public void updateContract(String gardenId,String contractId,String location,int dayOfWeek,List<String> tasks) throws ClientServiceException{
        GardenContract gardenContractOld = this.findGarden(gardenId, contractId);
		if(gardenContractOld!=null) {
			this.gardens.remove(gardenContractOld);
			GardenContract gardenContract = GardenContract.getBuilder()
					.contractId(contractId)
					.gardenId(gardenId)
					.location(location)
					.name(location)
					.dayOfWeek(dayOfWeek)
					.tasks(tasks).build();
			this.gardens.add(gardenContract);
		} else {
			throw new ClientServiceException(Constants.EX_GARDEN_NOT_EXIST);
    	}
    }
    
    private GardenContract findGarden(String gardenId,String contractId) {
    	GardenContract res = null;
    	if(this.gardens!=null&&this.gardens.size()==0) {
    		for(GardenContract gardenContract : this.gardens) {
    			if(gardenContract.getContractId().equals(contractId) &&
    			   gardenContract.getGardenId().equals(gardenId))
    				res=gardenContract;
    		}
    	} 
    	return res;
    }
    
    public static class Builder {
    	 
        private String email;
        private Builder() {}
 
        public Builder email(String email) {
            this.email = email;
            return this;
        }
 
        public Client build() throws ClientServiceException {
        	Client build = new Client(this);
            build.checkEmail(build.getEmail());
 
            return build;
        }
    }
    
    private void checkEmail(String email) throws ClientServiceException {   	
    	if(email.isEmpty()) throw new ClientServiceException("email can't be null");
    	if(!EmailValidator.validate(email)) throw new ClientServiceException("email is not valid");
 
    }

	
}
