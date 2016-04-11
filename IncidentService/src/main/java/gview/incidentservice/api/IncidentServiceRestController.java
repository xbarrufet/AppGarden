package gview.incidentservice.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gview.incidentservice.IncidentServiceException;
import gview.incidentservice.OrikaConfig;
import gview.incidentservice.model.Incident;
import gview.incidentservice.service.IncidentService;
import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/v1/incidents")
public class IncidentServiceRestController {

	
	@Autowired
	private IncidentService incidentService;
	private MapperFacade mapper;
	
	public IncidentServiceRestController(){
		mapper = OrikaConfig.getMapperFacade();
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public IncidentDTO addIncident(@RequestBody  IncidentDTO incidentDTO)   {
        try {
        	Incident incident = Incident.getBuilder().build();
        	mapper.map(incidentDTO, incident);
        	incident = incidentService.addIncident(incident);
        	IncidentDTO result = IncidentDTO.getBuilder().build();
			mapper.map(incident, result);
			return result;
		} catch (IncidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public IncidentDTO updateIncident(@RequestBody  IncidentDTO incidentDTO) {
        try {
        	Incident incident = Incident.getBuilder().build();
        	mapper.map(incidentDTO, incident);
        	incident = incidentService.updateIncident(incident);
        	IncidentDTO result = IncidentDTO.getBuilder().build();
			mapper.map(incident, result);
			return result;
		} catch (IncidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public IncidentDTO getIncident(@RequestParam(value="incidentId", defaultValue="") String incidentId) {
        Incident incident;
		try {
			incident = incidentService.getIncident(incidentId);
			IncidentDTO result = IncidentDTO.getBuilder().build();
			mapper.map(incident, result);
			return result;
		} catch (IncidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
      
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public List<IncidentDTO> getPendingIncidents(@RequestParam(value="gardenId", defaultValue="") String gardenId) {
       
		try {
			List<Incident> incidents = incidentService.getIncidentsByGarden(gardenId, true);
			List<IncidentDTO> result = mapper.mapAsList(incidents, IncidentDTO.class);
			return result;
		} catch (IncidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
      
    }
	
	
	
}
