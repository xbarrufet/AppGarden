package gview.clientservice.api;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {

	private String email;
    private String type;
    private String name;
    private String status;
    
    private List<GardenContractDTO> gardens;
    
    public ClientDTO() {
    	this.gardens=new ArrayList<GardenContractDTO>();
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<GardenContractDTO> getGardens() {
		return gardens;
	}

	public void setGardens(List<GardenContractDTO> gardens) {
		this.gardens = gardens;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addGarden(GardenContractDTO gardenContractDTO) {
		this.gardens.add(gardenContractDTO);
	}

	
    
	
}
