package gview.gardenservice.model;

import org.springframework.data.annotation.Id;

public class Garden {

	@Id
	private String gardenId;
	private String gardenCenterId;
	private String address;
	private String city;
	private String email;
	
}
