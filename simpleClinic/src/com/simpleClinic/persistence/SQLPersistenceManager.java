package com.simpleClinic.persistence;

import java.util.ArrayList;
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

//	@Override
//	public List<DTO<? extends AttributeGroup>> read(String entity, Map<String, String> whereConditions) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void update(String entityType, String entityId,
			Map<String, String> values) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String entityType, String entityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends AttributeGroup> List<DTO<T>> read(String entity,
			Map<String, String> whereConditions, Class<T> clazz) {
		// TODO Auto-generated method stub
		List<DTO<T>> returnList = new ArrayList<DTO<T>>();
		DTO<T> dto1 = DTO.getInstance(clazz);
		returnList.add(dto1);
		return returnList;
	}



//	@Override
//	public <T> List<T> read(String entity, Map<String, String> whereConditions) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
