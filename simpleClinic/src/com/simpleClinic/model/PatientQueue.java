package com.simpleClinic.model;

import java.util.HashMap;
import java.util.Map;

import com.simpleClinic.persistence.PersistenceManager;
import com.simpleClinic.persistence.factories.PersistenceManagerFactory;

public class PatientQueue {

	private static PatientQueue _queue = new PatientQueue();
	private final PersistenceManager _persManager;
	private PatientQueue() {
		this._persManager = PersistenceManagerFactory.getInstance().getManager("SQL");
	}

	public static PatientQueue getQueue() {
		// TODO Auto-generated method stub
		return _queue;
	}
	
	public void addPatient(String id) {
		Map<String, String> valueMap = new HashMap<String, String>();
		valueMap.put("id", id);
		_persManager.create("patientQueue", valueMap);
	}

	public String getNextPatient() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
