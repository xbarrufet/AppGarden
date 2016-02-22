package gview.clientservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gview.clientservice.ClientServiceException;
import gview.clientservice.Constants;
import gview.clientservice.model.Client;
import gview.clientservice.model.GardenContract;
import gview.clientservice.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	
	private final ClientRepository repository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository repository) {
		this.repository=repository;
	}
	
	

	public void activateClient(String email, String name) throws ClientServiceException {
		Client client=repository.findByEmail(email);
		if(client==null) {
			throw new ClientServiceException(Constants.EX_CLIENT_NOT_EXIST);
		}
		client.activateClient(name);
		repository.save(client);
		
	}

	

	public void addClient(ClientContractDTO clientContractDTO) throws ClientServiceException {
		Client client=repository.findByEmail(clientContractDTO.getEmail());
		if(client==null) {
			client = Client.getBuilder()
					.email(clientContractDTO.getEmail())
					.build();
		}
		client.addContract(clientContractDTO.getGardenId(),
						   clientContractDTO.getContractId(),
						   clientContractDTO.getLocation(),
						   clientContractDTO.getDayOfWeek(),
						   clientContractDTO.getTasks());
		repository.save(client);
		
	}





	public void updateContract(ClientContractDTO clientContractDTO) throws ClientServiceException {
		Client client=repository.findByEmail(clientContractDTO.getEmail());
		if(client==null) {
			throw new ClientServiceException(Constants.EX_CLIENT_NOT_EXIST);
		}
		client.updateContract(clientContractDTO.getGardenId(),
						   clientContractDTO.getContractId(),
						   clientContractDTO.getLocation(),
						   clientContractDTO.getDayOfWeek(),
						   clientContractDTO.getTasks());
		repository.save(client);
		
	}



	public ClientDTO getClient(String email) {
		Client client = this.repository.findByEmail(email);
		return this.clientToClientDTO(client);
	}
	


	public List<ClientDTO> getAllClients() {
		Iterator<Client> clients= repository.findAll().iterator();
		List<ClientDTO> res = new ArrayList<ClientDTO>();
		while(clients.hasNext()) {
			res.add(this.clientToClientDTO(clients.next()));
		}
			return res;
	}

	private ClientDTO clientToClientDTO(Client client) {
		ClientDTO res = new ClientDTO();
		res.setEmail(client.getEmail());
		res.setStatus(client.getStatus());
		res.setName(client.getName());
		for(GardenContract garden:client.getGardens()) {
			res.addGarden(new GardenContractDTO(garden));
		}
		return res;
	
	}


	





	

}
