package gview.clientservice.service;

import java.util.List;

import gview.clientservice.ClientServiceException;
import gview.clientservice.model.Client;

public interface ClientService {

	
	public void addClient(ClientContractDTO clientContractDTO) throws ClientServiceException;
	public void activateClient(String email,String name) throws ClientServiceException;
	public void updateContract(ClientContractDTO clientContractDTO) throws ClientServiceException;

	public ClientDTO getClient(String email);
	public List<ClientDTO> getAllClients();
}
