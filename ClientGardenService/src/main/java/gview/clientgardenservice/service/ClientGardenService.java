package gview.clientgardenservice.service;

import java.util.List;

import gview.clientgardenservice.ClientGardenServiceException;
import gview.clientgardenservice.api.GardenDTO;
import gview.clientgardenservice.model.Garden;

public interface ClientGardenService {

	
	public Garden addGarden(Garden garden) throws ClientGardenServiceException;
	public Garden updateGarden(Garden garden) throws ClientGardenServiceException;
	public void deleteGarden(String gardenId) throws ClientGardenServiceException;
	public List<Garden> getGardens(String email);
	
}
