package gview.clientgardenservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import gview.clientgardenservice.model.Garden;

public interface ClientGardenRepository extends MongoRepository<Garden, String> {

	public List<Garden> findByEmail(String email,boolean active);
	public Garden findByGardenId(String gardenId);
	public Garden findById(String id);
   
}
