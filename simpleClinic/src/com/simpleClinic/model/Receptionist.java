package com.simpleClinic.model;

import java.util.Queue;

public class Receptionist {

	private Queue<Patient> _inQueue;
	
	
	public String getNextPatient() {
		return _inQueue.poll().getName();
	}
	
	public void addPatient(Patient patient) {
		this._inQueue.add(patient);
	}
}
