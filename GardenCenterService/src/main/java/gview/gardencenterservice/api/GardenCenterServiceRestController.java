package gview.gardencenterservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		@RequestMapping(method = RequestMethod.PUT)
	    public GardenCenterDTO updateGarden(@RequestBody  GardenCenterDTO gardenCenterDTO) {
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
	    public GardenCenterDTO getClient(@RequestParam(value="email", defaultValue="") String gardenCenterId) {
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

