package com.simpleClinic.model.factories;

import java.util.HashMap;
import java.util.Map;

import com.simpleClinic.model.NormalPatient;
import com.simpleClinic.model.interfaces.Patient;
import com.simpleClinic.persistence.PersistenceManager;
import com.simpleClinic.persistence.factories.PersistenceManagerFactory;

public class PatientFactory {
	private static final PatientFactory _instance = new PatientFactory();
	private final PersistenceManager _persManager;
	private PatientFactory() {
		this._persManager = PersistenceManagerFactory.getInstance().getManager("SQL");
	}

	public static PatientFactory getPatientFactory() {
		return _instance;
	}
	 
	public Patient createPatient(String name)  {
		Map<String, String> values = new HashMap<String, String>();
		values.put("name", name);
		String id = _persManager.create("patient", values);
		return new NormalPatient(id, name);
	}
	
	public void savePatientDetails(Map<String, String> patientDetails) {
		
	}
	
}
