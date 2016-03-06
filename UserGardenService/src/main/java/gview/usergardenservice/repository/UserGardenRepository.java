package gview.usergardenservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import gview.usergardenservice.model.Garden;

public interface UserGardenRepository extends MongoRepository<Garden, String> {

	public List<Garden> findByEmail(String email,boolean active);
	public Garden findByGardenId(String gardenId);
	public Garden findById(String id);
   
}
