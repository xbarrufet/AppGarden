package gview.gardencenterservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import gview.gardencenterservice.model.GardenCenter;


@Repository
public interface GardenCenterRepository extends MongoRepository<GardenCenter, String> {

	public GardenCenter findByName(String name);
   
}
