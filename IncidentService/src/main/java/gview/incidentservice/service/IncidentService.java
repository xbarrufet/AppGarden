package gview.incidentservice.service;

import java.util.List;

import gview.incidentservice.IncidentServiceException;
import gview.incidentservice.model.Incident;

public interface IncidentService {

	
	
	public Incident addIncident(Incident incident) throws IncidentServiceException;
	public Incident updateIncident(Incident incident) throws IncidentServiceException;
	public void deleteIncident(String incidentId) throws IncidentServiceException;
	public Incident completeIncident(String incidentId) throws IncidentServiceException;
	public Incident getIncident(String gardenId) throws IncidentServiceException;
	public List<Incident> getIncidentsByGarden(String gardenId,boolean onlyPending ) throws IncidentServiceException;
	
}
