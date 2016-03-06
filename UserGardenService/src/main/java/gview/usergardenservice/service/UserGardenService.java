package gview.usergardenservice.service;

import java.util.List;

import gview.usergardenservice.ClientGardenServiceException;
import gview.usergardenservice.api.GardenDTO;
import gview.usergardenservice.model.Garden;

public interface UserGardenService {

	
	public Garden addGarden(Garden garden) throws ClientGardenServiceException;
	public Garden updateGarden(Garden garden) throws ClientGardenServiceException;
	public void deleteGarden(String gardenId) throws ClientGardenServiceException;
	public List<Garden> getGardens(String email);
	
}
