package com.simpleClinic.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.AttributeGroup;
import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;
import com.simpleClinic.dataTransfer.PatientDTOComparator;
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

	//@SuppressWarnings("unchecked")
	public DTO<PatientAttributes> getNextPatient() {

		List<DTO<? extends AttributeGroup>> dtos = _persManager.read("patientQueue", null);

		Collections.sort(dtos, PatientDTOComparator.getInstance());
		
		
		@SuppressWarnings("unchecked")
		DTO<PatientAttributes> patient = (DTO<PatientAttributes>) dtos.get(0);
		
		_persManager.delete("patientQueue", patient.get(PatientAttributes.instance().id));
		
		return patient;
	}
	
	
}
