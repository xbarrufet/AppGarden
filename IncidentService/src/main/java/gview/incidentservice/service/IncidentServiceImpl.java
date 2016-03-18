package gview.incidentservice.service;

import java.util.List;

import gview.incidentservice.IncidentServiceException;
import gview.incidentservice.model.Incident;
import gview.incidentservice.repository.IncidentRepository;

public class IncidentServiceImpl implements IncidentService {

	IncidentRepository repository;
	
	
	public Incident addIncident(Incident incident) throws IncidentServiceException {
		return repository.save(incident);
		
	}

	public Incident updateIncident(Incident incident) throws IncidentServiceException {
		if(this.repository.findOne(incident.getIncidenceId())==null)
			throw new IncidentServiceException("incident doesn't exists");
		return this.repository.save(incident);
	}

	public void deleteIncident(String incidentId) throws IncidentServiceException {
		repository.delete(this.repository.findOne(incidentId));
	}

	public Incident completeIncident(String incidentId) throws IncidentServiceException {
		Incident incident = this.repository.findOne(incidentId);
		if(incident==null)
			throw new IncidentServiceException("incident doesn't exists");
		incident.setStatus(Incident.STATUS_COMPLETED);
		return this.repository.save(incident);
		
	}

	public Incident getIncident(String incidentId) throws IncidentServiceException {
		return this.repository.findOne(incidentId);
	}

	public List<Incident> getIncidentsByGarden(String gardenId, boolean onlyPending) throws IncidentServiceException {
		if(onlyPending)
			return this.repository.findByGardenId(gardenId);
		else
			return this.repository.findByGardenIdAndStatus(gardenId, Incident.STATUS_PENDING);
		
	}

}
