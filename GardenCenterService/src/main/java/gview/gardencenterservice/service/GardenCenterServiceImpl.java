package gview.gardencenterservice.service;

import org.springframework.stereotype.Service;

import gview.gardencenterservice.GardenCenterServiceException;
import gview.gardencenterservice.model.GardenCenter;
import gview.gardencenterservice.repository.GardenCenterRepository;

@Service
public class GardenCenterServiceImpl implements GardenCenterService {
	
	private GardenCenterRepository repository;
	
	public GardenCenter addGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException {
		
		if(repository.findByName(gardenCenter.getName())!=null)
			throw new GardenCenterServiceException("Garden center exist");
		GardenCenter result=repository.save(gardenCenter);
		return result;
	}

	public GardenCenter updateGardenCenter(GardenCenter gardenCenter) throws GardenCenterServiceException {
		GardenCenter current = repository.findOne(gardenCenter.getGardenCenterId());
		if(current ==null)
			throw new GardenCenterServiceException("Garden center doesn't exist");
		GardenCenter result=repository.save(gardenCenter);
		return result;
	}

	public GardenCenter deleteGardenCenter(String gardenId) throws GardenCenterServiceException {
		GardenCenter current = repository.findOne(gardenId);
		if(current ==null)
			throw new GardenCenterServiceException("Garden center doesn't exist");
		current.setActive(false);
		GardenCenter result=repository.save(current);
		return result;
	}

	public GardenCenter getGardenCenter(String gardenId) throws GardenCenterServiceException {
		return repository.findOne(gardenId);
	}

}
