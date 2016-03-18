package gview.incidentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import gview.incidentservice.model.Incident;



public interface IncidentRepository extends MongoRepository<Incident, String> {
	
	public List<Incident> findByGardenId(String gardenId);
	public List<Incident> findByGardenIdAndStatus(String gardenId,String status);
	 
}