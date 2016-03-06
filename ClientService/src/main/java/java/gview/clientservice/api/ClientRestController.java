package java.gview.clientservice.api;

import java.gview.clientservice.ClientServiceException;
import java.gview.clientservice.OrikaConfig;
import java.gview.clientservice.model.Client;
import java.gview.clientservice.service.ClientService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/v1/clients")
public class ClientRestController {



		@Autowired
		private ClientService clientService;
		private MapperFacade mapper;
		
		public ClientRestController(){
			mapper = OrikaConfig.getMapperFacade();
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public ClientDTO addClient(@RequestBody  ClientDTO clientDTO)   {
	        try {
	        	Client client = Client.getBuilder().build();
	        	mapper.map(clientDTO, client);
	        	client = clientService.addClient(client);
	        	ClientDTO result = ClientDTO.getBuilder().build();
				mapper.map(client, result);
				return result;
			} catch (ClientServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }
		
		@RequestMapping(method = RequestMethod.PUT)
	    public ClientDTO updateClient(@RequestBody  ClientDTO clientDTO) {
	        try {
	        	Client client = Client.getBuilder().build();
	        	mapper.map(clientDTO, client);
	        	client = clientService.updateClient(client);
	        	ClientDTO result = ClientDTO.getBuilder().build();
				mapper.map(client, result);
				return result;
			} catch (ClientServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }
		
		@RequestMapping(method=RequestMethod.GET)
	    public ClientDTO getClient(@RequestParam(value="clientId", defaultValue="") String clientId) {
	        Client client;
			try {
				client = clientService.getClient(clientId);
			  ClientDTO result = ClientDTO.getBuilder().build();
				mapper.map(client, result);
				return result;
			} catch (ClientServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	      
	    }
		
		@RequestMapping(method=RequestMethod.GET)
	    public List<ClientDTO> getGardenCenterClients(@RequestParam(value="gardenCenterId", defaultValue="") String gardenCenterId) {
	       
			try {
				List<Client> clients = clientService.getGardenCenterClients(gardenCenterId);
				List<ClientDTO> result = mapper.mapAsList(clients, ClientDTO.class);
				return result;
			} catch (ClientServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	      
	    }
		
		
	}

