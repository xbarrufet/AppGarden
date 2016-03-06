package gview.gardencenterservice.service;

import gview.gardencenterservice.GardenCenterServiceException;
import gview.gardencenterservice.model.GardenCenter;

public interface GardenCenterService {

	public GardenCenter addGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException;
	public GardenCenter updateGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException;
	public GardenCenter deleteGardenCenter(String gardenId) throws GardenCenterServiceException;
	public GardenCenter getGardenCenter(String gardenId) throws GardenCenterServiceException;
	
}
