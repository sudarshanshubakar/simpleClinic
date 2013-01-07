package com.simpleClinic.persistence;

import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.AttributeGroup;
import com.simpleClinic.dataTransfer.DTO;

public class SQLPersistenceManager implements PersistenceManager {

	@Override
	public String create(String entityType, Map<String, String> values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO<? extends AttributeGroup>> read(String entity, Map<String, String> whereConditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String entityType, String entityId,
			Map<String, String> values) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String entityType, String entityId) {
		// TODO Auto-generated method stub

	}

}
