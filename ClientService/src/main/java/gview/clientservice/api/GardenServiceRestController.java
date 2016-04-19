package gview.clientservice.api;


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

import gview.clientservice.ContextBuilder;
import gview.clientservice.GardenServiceException;
import gview.clientservice.OrikaConfig;
import gview.clientservice.model.Garden;
import gview.clientservice.service.GardenService;
import ma.glasnost.orika.MapperFacade;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/garden")
public class GardenServiceRestController {


			@Autowired
			private GardenService gardenService;
			private MapperFacade mapper;
			
			public GardenServiceRestController(){
				mapper = OrikaConfig.getMapperFacade();
			}
			
			@RequestMapping(params = {"clientId"}, method = RequestMethod.POST)
		    public GardenDTO addGarden(@RequestHeader("GView-Context") String gviewContext, 
		    						   @RequestParam String clientId,
					  				   @RequestBody  GardenDTO gardenDTO)   {
		        try {
		        	Garden garden = Garden.getBuilder().build();
		        	mapper.map(gardenDTO, garden);
		        	garden.setClientId(clientId);
		        	garden = gardenService.addGarden(garden);
		        	GardenDTO result = GardenDTO.getBuilder().build();
					mapper.map(garden, result);
					return result;
				} catch (GardenServiceException e) {
					e.printStackTrace();
					return null;
				}
		    }
			
			@RequestMapping(value = "/{clientId}/{gardenId}",method = RequestMethod.PUT)
		    public GardenDTO updateGarden(@RequestHeader("GView-Context") String gviewContext,
		    							 @PathVariable String clientId,
	   				                     @PathVariable String gardenId,
		    							 @RequestBody  GardenDTO gardenDTO) {
				 try {
			        	Garden garden = Garden.getBuilder().build();
			        	mapper.map(gardenDTO, garden);
			        	garden = gardenService.updateGarden(garden);
			        	GardenDTO result = GardenDTO.getBuilder().build();
						mapper.map(garden, result);
						return result;
					} catch (GardenServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
		    }
			
			@RequestMapping(value = "/{clientId}/{gardenId}",method=RequestMethod.GET)
		    public GardenDTO getGarden(@RequestHeader("GView-Context") String gviewContext, 
		    		 				  @PathVariable String clientId,
	  				   				  @PathVariable String gardenId) {
		        Garden garden;
				try {
					garden = gardenService.getGarden(gardenId);
					GardenDTO result = GardenDTO.getBuilder().build();
					mapper.map(garden, result);
					return result;
				} catch (GardenServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		      
		    }
			
			@RequestMapping(params = {"clientId"},method=RequestMethod.GET)
		    public List<GardenDTO> getGardenClients(@RequestHeader("GView-Context") String gviewContext, 
		    										@RequestParam(value = "clientId")  String clientId) {
		       
				try {
					String gardenCenterId = ContextBuilder.getGardenCenterId(gviewContext);
					List<Garden> gardens = gardenService .getGardenByClient(clientId, gardenCenterId);
					List<GardenDTO> result = mapper.mapAsList(gardens, GardenDTO.class);
					return result;
				} catch (GardenServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		      
		    }
			
			@RequestMapping(method=RequestMethod.GET)
		    public List<GardenDTO> getAllGardens(@RequestParam(value="gardenCenterId", defaultValue="") String gardenCenterId) {
		    									
				try {
					List<Garden> gardens = gardenService.getAllGardens(gardenCenterId);
					List<GardenDTO> result = mapper.mapAsList(gardens, GardenDTO.class);
					return result;
				} catch (GardenServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		      
		    }
			
		}

