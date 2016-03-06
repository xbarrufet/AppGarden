package java.gview.clientservice.repository;

import java.gview.clientservice.model.Client;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

	public Client findByEmailAndGardenCenterId(String email,String gardenCenterId);
	public List<Client> findByGardenCenterId(String gardenCenterId);
   
}
