package gview.clientservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import gview.clientservice.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	public Client findByEmail(String email);
	public Client findById(String id);
    public List<Client> findAll();
}
