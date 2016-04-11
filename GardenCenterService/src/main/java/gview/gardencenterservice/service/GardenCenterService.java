package gview.gardencenterservice.service;

import java.util.List;

import gview.gardencenterservice.GardenCenterServiceException;
import gview.gardencenterservice.model.GardenCenter;

public interface GardenCenterService {

	public GardenCenter addGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException;
	public GardenCenter updateGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException;
	public GardenCenter deleteGardenCenter(String gardenCenterId) throws GardenCenterServiceException;
	public GardenCenter getGardenCenter(String gardenCenterId) throws GardenCenterServiceException;
	public List<GardenCenter> getAllGardenCenters(boolean onlyActive) throws GardenCenterServiceException;
	
}
