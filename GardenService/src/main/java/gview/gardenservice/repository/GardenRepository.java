package gview.gardenservice.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import gview.gardenservice.model.Garden;

public interface GardenRepository extends MongoRepository<Garden, String> {

	public List<Garden> findByClientIdAndGardenCenterIdAndActive(String clientId,String gardenCenterId,boolean active);
	public List<Garden> findByGardenCenterIdAndActive(String gardenCenterId,boolean active);
	   
}
