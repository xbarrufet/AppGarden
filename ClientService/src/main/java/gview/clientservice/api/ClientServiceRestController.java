package gview.clientservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gview.clientservice.ClientServiceException;
import gview.clientservice.service.ClientService;


@RestController
@RequestMapping("/v1/clients")
public class ClientServiceRestController {

	@Autowired
	private ClientService clientService;
	
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ClientDTO addClientContract(@RequestBody  ClientContractDTO clientContractDTO) {
        try {
			return clientService.addClientContract(clientContractDTO);
		} catch (ClientServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
/*	@RequestMapping(method = RequestMethod.PUT)
    public ClientDTO updateClientContract(@RequestParam(value="name", defaultValue="World") ClientContractDTO clientContractDTO) {
        try {
			return clientService.updateClientContract(clientContractDTO);
		} catch (ClientServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value="/clients/activate", method=RequestMethod.PUT)
    public ClientDTO activateClient(@RequestParam(value="name", defaultValue="World") ClientContractDTO clientContractDTO) {
        try {
			return clientService.updateClientContract(clientContractDTO);
		} catch (ClientServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public ClientDTO getClient(@RequestParam(value="name", defaultValue="World") ClientContractDTO clientContractDTO) {
        try {
			return clientService.updateClientContract(clientContractDTO);
		} catch (ClientServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public ClientDTO getAllClients(@RequestParam(value="name", defaultValue="World") ClientContractDTO clientContractDTO) {
        try {
			return clientService.updateClientContract(clientContractDTO);
		} catch (ClientServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }*/
}
