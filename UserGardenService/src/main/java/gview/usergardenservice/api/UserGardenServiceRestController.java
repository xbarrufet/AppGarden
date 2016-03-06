package gview.usergardenservice.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gview.usergardenservice.ClientGardenServiceException;
import gview.usergardenservice.OrikaConfig;
import gview.usergardenservice.model.Garden;
import gview.usergardenservice.service.UserGardenService;
import ma.glasnost.orika.MapperFacade;


@RestController
@RequestMapping("/v1/clients")
public class UserGardenServiceRestController {

	@Autowired
	private UserGardenService clientService;
	private MapperFacade mapper;
	
	public UserGardenServiceRestController(){
		mapper = OrikaConfig.getMapperFacade();
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public GardenDTO addGarden(@RequestBody  GardenDTO gardenDTO) {
        try {
        	Garden garden = Garden.getBuilder().build();
        	mapper.map(gardenDTO, garden);
			garden =  clientService.addGarden(garden);
			GardenDTO result = GardenDTO.getBuilder().build();
			mapper.map(garden, result);
			return result;
		} catch (ClientGardenServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public GardenDTO updateGarden(@RequestBody  GardenDTO gardenDTO) {
        try {
        	Garden garden = Garden.getBuilder().build();
        	mapper.map(gardenDTO, garden);
			garden =  clientService.updateGarden(garden);
			GardenDTO result = GardenDTO.getBuilder().build();
			mapper.map(garden, result);
			return result;
		} catch (ClientGardenServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	
	@RequestMapping(method=RequestMethod.GET)
    public List<GardenDTO> getClient(@RequestParam(value="email", defaultValue="") String email) {
        List<Garden> gardens =  clientService.getGardens(email);
		List<GardenDTO> result = mapper.mapAsList(gardens,GardenDTO.class);
		return result;
    }
	
	
}
