package gview.gardenservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gview.gardenservice.GardenServiceException;
import gview.gardenservice.model.Garden;
import gview.gardenservice.repository.GardenRepository;

@Service
public class GardenServiceImpl implements GardenService {

	private GardenRepository repository;
	public Garden addGarden(Garden garden) throws GardenServiceException {
		if(garden.getGardenId()!=null && this.repository.findOne(garden.getGardenId())!=null)
			throw new GardenServiceException("Garden already exists");
		return this.repository.save(garden);
	}

	public Garden updateGarden(Garden garden) throws GardenServiceException {
		if(garden.getGardenId()==null || this.repository.findOne(garden.getGardenId())!=null)
			throw new GardenServiceException("Garden doesn't exists");
		return this.repository.save(garden);
	}

	public Garden deleteGarden(String gardenId) throws GardenServiceException {
		Garden garden = this.repository.findOne(gardenId);
		if(garden==null )
			throw new GardenServiceException("Garden doesn't exists");
		garden.setActive(false);
		return this.repository.save(garden);
	}

	public Garden getGarden(String gardenId) throws GardenServiceException {
		return this.repository.findOne(gardenId);
	}

	public List<Garden> getGardenByClient(String clientId, String gardenCenterId) throws GardenServiceException {
		return this.repository.findByClientIdAndGardenCenterIdAndActive(clientId, gardenCenterId, true);
	}

	public List<Garden>  getAllGardens(String gardenCenterId) throws GardenServiceException {
		return this.repository.findByGardenCenterIdAndActive(gardenCenterId, true);
	}

	

}
