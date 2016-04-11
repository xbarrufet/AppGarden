package gview.clientservice.service;

import gview.clientservice.ClientServiceException;
import gview.clientservice.model.Client;
import gview.clientservice.repository.ClientRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client addClient(Client client) throws ClientServiceException {
		
		if(repository.findByEmailAndGardenCenterId(client.getEmail(),client.getGardenCenterId())!=null)
			throw new ClientServiceException("Client exist");
		Client result=repository.save(client);
		return result;
	}

	public Client updateClient(Client client) throws ClientServiceException {
		Client current = repository.findOne(client.getClientId());
		if(current ==null)
			throw new ClientServiceException("Client doesn't exist");
		Client result=repository.save(client);
		return result;
	}

	public Client deleteClient(String clientId) throws ClientServiceException {
		Client current = repository.findOne(clientId);
		if(current ==null)
			throw new ClientServiceException("Client doesn't exist");
		current.setActive(false);
		Client result=repository.save(current);
		return result;
	}

	public Client getClient(String clientId) throws ClientServiceException {
		return repository.findOne(clientId);
	}
	
	public List<Client> getGardenCenterClients(String gardenCenterId) throws ClientServiceException {
		return repository.findByGardenCenterId(gardenCenterId);
	}

}
