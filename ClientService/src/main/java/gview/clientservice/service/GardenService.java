package gview.clientservice.service;

import java.util.List;

import gview.clientservice.GardenServiceException;
import gview.clientservice.model.Garden;

public interface GardenService {

	
	public Garden addGarden(Garden garden) throws GardenServiceException;
	public Garden updateGarden(Garden garden) throws GardenServiceException;
	public Garden deleteGarden(String gardenId) throws GardenServiceException;
	public Garden getGarden(String gardenId) throws GardenServiceException;
	public List<Garden>  getGardenByClient(String clientId,String gardenCenterId) throws GardenServiceException;
	public List<Garden>  getAllGardens(String gardenCenterId) throws GardenServiceException;
	
}
