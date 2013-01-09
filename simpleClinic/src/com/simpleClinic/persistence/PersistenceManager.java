package com.simpleClinic.persistence;

import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.AttributeGroup;
import com.simpleClinic.dataTransfer.DTO;


public interface PersistenceManager {

	public String create(String entityType, Map<String, String> values);
	
//	public List<DTO<? extends AttributeGroup>> read(String entity, Map<String, String> whereConditions);
	public <T extends AttributeGroup> List<DTO<T>> read(String entity, Map<String, String> whereConditions, Class<T> clazz);
	
	public void update(String entityType, String entityId, Map<String, String> values);
	
	public void delete(String entityType, String entityId);
	
}
