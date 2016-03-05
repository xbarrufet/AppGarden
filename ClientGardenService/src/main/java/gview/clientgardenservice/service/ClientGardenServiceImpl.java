package gview.clientgardenservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gview.clientgardenservice.ClientGardenServiceException;
import gview.clientgardenservice.api.GardenDTO;
import gview.clientgardenservice.model.Garden;
import gview.clientgardenservice.repository.ClientGardenRepository;

@Service
public class ClientGardenServiceImpl implements ClientGardenService{

	
	private final ClientGardenRepository repository;
	
	@Autowired
	public ClientGardenServiceImpl(ClientGardenRepository repository) {
		this.repository=repository;
	}

	@Override
	public Garden addGarden(Garden garden) throws ClientGardenServiceException {
		//check if exists
		if (repository.findByGardenId(garden.getGardenId()) !=null)
			throw new ClientGardenServiceException("Garden exists on client");
		else 
			return repository.save(garden);
	}

	@Override
	public Garden updateGarden(Garden garden) throws ClientGardenServiceException {
		//check if exists
		Garden current = repository.findByGardenId(garden.getGardenId());
		if (current==null)
			throw new ClientGardenServiceException("Garden doesn't exists on client");
		else{
			current.setCity(garden.getCity());
			current.setAddress(garden.getAddress());
			return repository.save(current);
		}
	}

	@Override
	public void deleteGarden(String gardenId) throws ClientGardenServiceException {
		//check if exists
		Garden current = repository.findByGardenId(gardenId);
		if (current==null)
			throw new ClientGardenServiceException("Garden doesn't exists on client");
		else{
			current.setActive(false);
			repository.save(current);
		}
		
	}

	@Override
	public List<Garden> getGardens(String email) {
		return this.repository.findByEmail( email,true);
	}





	

}
