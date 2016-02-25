package gview.clientservice.service;

import java.util.List;

import gview.clientservice.ClientServiceException;
import gview.clientservice.api.ClientContractDTO;
import gview.clientservice.api.ClientDTO;
import gview.clientservice.model.Client;

public interface ClientService {

	
	public ClientDTO addClientContract(ClientContractDTO clientContractDTO) throws ClientServiceException;
	public ClientDTO activateClient(String email,String name) throws ClientServiceException;
	public ClientDTO updateClientContract(ClientContractDTO clientContractDTO) throws ClientServiceException;

	public ClientDTO getClient(String email);
	public List<ClientDTO> getAllClients();
}
