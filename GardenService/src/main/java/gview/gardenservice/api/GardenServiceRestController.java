package gview.gardenservice.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gview.gardenservice.GardenServiceException;
import gview.gardenservice.OrikaConfig;
import gview.gardenservice.model.Garden;
import gview.gardenservice.service.GardenService;
import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/v1/garden")
public class GardenServiceRestController {


			@Autowired
			private GardenService gardenService;
			private MapperFacade mapper;
			
			public GardenServiceRestController(){
				mapper = OrikaConfig.getMapperFacade();
			}
			
			@RequestMapping(method = RequestMethod.POST)
		    public GardenDTO addGarden(@RequestBody  GardenDTO gardenDTO)   {
		        try {
		        	Garden garden = Garden.getBuilder().build();
		        	List aux =gardenDTO.getScheduledServices();
		        	
		        	mapper.map(gardenDTO, garden);
		        	garden = gardenService.addGarden(garden);
		        	GardenDTO result = GardenDTO.getBuilder().build();
					mapper.map(garden, result);
					return result;
				} catch (GardenServiceException e) {
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
			
			@RequestMapping(method=RequestMethod.GET)
		    public GardenDTO getGarden(@RequestParam(value="gardenId", defaultValue="") String gardenId) {
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
			
			@RequestMapping(method=RequestMethod.GET)
		    public List<GardenDTO> getGardenClients(@RequestParam(value="gardenCenterId", defaultValue="") String gardenCenterId,
		    										@RequestParam(value="clientId", defaultValue="") String clientId) {
		       
				try {
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

