
package gview.clientservice.api;

import gview.clientservice.ClientServiceException;
import gview.clientservice.ContextBuilder;
import gview.clientservice.OrikaConfig;
import gview.clientservice.model.Client;
import gview.clientservice.service.ClientService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/clients")
public class ClientRestController {



		@Autowired
		private ClientService clientService;
		private MapperFacade mapper;
		
		public ClientRestController(){
			mapper = OrikaConfig.getMapperFacade();
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public ClientDTO addClient(@RequestHeader("GView-Context") String gviewContext, 
	    										  @RequestBody  ClientDTO clientDTO)   {
	        try {
	        	String gardenCenterId = ContextBuilder.getGardenCenterId(gviewContext);
	        	Client client = Client.getBuilder().gardenCenterId(gardenCenterId).build();
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
		
		@RequestMapping(value = "/{clientId}",method = RequestMethod.PUT)
	    public ClientDTO updateClient(@RequestHeader("GView-Context") String gviewContext, 
	    							  @PathVariable String clientId, 
		  							  @RequestBody  ClientDTO clientDTO) {
	        try {
	        	String gardenCenterId = ContextBuilder.getGardenCenterId(gviewContext);
	        	Client client = Client.getBuilder().gardenCenterId(gardenCenterId).build();
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
	    public ClientDTO getClient(@RequestHeader("GView-Context") String gviewContext,
	    						  @RequestParam(value="clientId", defaultValue="") String clientId) {
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
	    public List<ClientDTO> getGardenCenterClients(@RequestHeader("GView-Context") String gviewContext)
		{
	       
			try {
				String gardenCenterId = ContextBuilder.getGardenCenterId(gviewContext);
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

