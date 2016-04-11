package gview.gardencenterservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gview.gardencenterservice.GardenCenterServiceException;
import gview.gardencenterservice.OrikaConfig;
import gview.gardencenterservice.model.GardenCenter;
import gview.gardencenterservice.service.GardenCenterService;
import ma.glasnost.orika.MapperFacade;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/gardencenters")
public class GardenCenterServiceRestController {



		@Autowired
		private GardenCenterService gardenCenterService;
		private MapperFacade mapper;
		
		public GardenCenterServiceRestController(){
			mapper = OrikaConfig.getMapperFacade();
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public GardenCenterDTO addGarden(@RequestBody  GardenCenterDTO gardenCenterDTO)   {
	        try {
	        	GardenCenter gardenCenter = GardenCenter.getBuilder().build();
	        	mapper.map(gardenCenterDTO, gardenCenter);
	        	gardenCenter = gardenCenterService.addGardenCenter(gardenCenter);
	        	GardenCenterDTO result = GardenCenterDTO.getBuilder().build();
				mapper.map(gardenCenter, result);
				return result;
			} catch (GardenCenterServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }
		
		@RequestMapping(value = "/{gardenCenterId}",method = RequestMethod.PUT)
	    public GardenCenterDTO updateGarden(@PathVariable String gardenCenterId,@RequestBody  GardenCenterDTO gardenCenterDTO) {
	        try {
	        	GardenCenter gardenCenter = GardenCenter.getBuilder().build();
	        	mapper.map(gardenCenterDTO, gardenCenter);
	        	gardenCenter = gardenCenterService.updateGardenCenter(gardenCenter);
	        	GardenCenterDTO result = GardenCenterDTO.getBuilder().build();
				mapper.map(gardenCenter, result);
				return result;
			} catch (GardenCenterServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }
		
		@RequestMapping(method=RequestMethod.GET)
	    public List<GardenCenterDTO> getAllGardenCenters() {
	       
			try {
				 List<GardenCenter> gardenCenters = gardenCenterService.getAllGardenCenters(false);
				 List<GardenCenterDTO> result = mapper.mapAsList(gardenCenters, GardenCenterDTO.class);
				return result;
			} catch (GardenCenterServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	      
	    }
		
		
		@RequestMapping(value = "/{gardenCenterId}", method=RequestMethod.GET)
	    public GardenCenterDTO getClient(@PathVariable String gardenCenterId) {
	        GardenCenter gardenCenter;
			try {
				gardenCenter = gardenCenterService.getGardenCenter(gardenCenterId);
			  GardenCenterDTO result = GardenCenterDTO.getBuilder().build();
				mapper.map(gardenCenter, result);
				return result;
			} catch (GardenCenterServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	      
	    }
		
		
	}

