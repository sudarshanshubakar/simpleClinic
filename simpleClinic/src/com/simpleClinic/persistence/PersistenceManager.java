package com.simpleClinic.persistence;

import java.util.List;
import java.util.Map;

import com.simpleClinic.model.helpers.PatientDTO;

public interface PersistenceManager {

	public String create(String entityType, Map<String, String> values);
	
	public List<PatientDTO> read(String entity, Map<String, String> whereConditions);
	
	public void update(String entityType, String entityId, Map<String, String> values);
	
	public void delete(String entityType, String entityId);
	
}
