package java.gview.clientservice.service;

import java.gview.clientservice.ClientServiceException;
import java.gview.clientservice.model.Client;
import java.util.List;

public interface ClientService {

	public Client addClient(Client client) throws ClientServiceException;
	public Client updateClient(Client client) throws ClientServiceException;
	public Client deleteClient(String clientId) throws ClientServiceException;
	public Client getClient(String clientId) throws ClientServiceException;
	public List<Client> getGardenCenterClients(String gardenCenterId) throws ClientServiceException;
	
}
