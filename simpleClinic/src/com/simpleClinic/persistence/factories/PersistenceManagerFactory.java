package com.simpleClinic.persistence.factories;

import java.util.HashMap;
import java.util.Map;

import com.simpleClinic.persistence.PersistenceManager;
import com.simpleClinic.persistence.SQLPersistenceManager;

public class PersistenceManagerFactory {

	private Map<String, PersistenceManager> _registry = new HashMap<String, PersistenceManager>();
	
	private PersistenceManagerFactory() {
		_registry.put("SQL", new SQLPersistenceManager());
	}
	
	private static final PersistenceManagerFactory _instance = new PersistenceManagerFactory();
	
	public static final PersistenceManagerFactory getInstance() {
		return _instance;
	}
	
	public PersistenceManager getManager(String managerType) {
		return _registry.get(managerType);
	}
	
	
}
