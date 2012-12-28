package com.simpleClinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simpleClinic.model.helpers.PatientDTO;
import com.simpleClinic.model.interfaces.QueuedPatient;
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

	public QueuedPatient getNextPatient() {

		List<PatientDTO> dtos = _persManager.read("patientQueue", null);
		List<QueuedPatient> patients = new ArrayList<QueuedPatient>();
		for (PatientDTO pDTO : dtos) {
			patients.add(new QueuedNormalPatient(pDTO.get_id(), pDTO.get_name(), pDTO.get_queuePosition()));
		}
		Collections.sort(patients);
		
		
		QueuedPatient patient = patients.get(0);
		
		_persManager.delete("patientQueue", patient.getID());
		
		return patient;
	}
	
	
}
