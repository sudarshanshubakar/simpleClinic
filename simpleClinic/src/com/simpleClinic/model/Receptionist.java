package com.simpleClinic.model;

import java.util.Queue;

public class Receptionist {

	private Queue<NormalPatient> _inQueue;
	
	
	public String getNextPatient() {
		return _inQueue.poll().getName();
	}
	
	public void addPatient(NormalPatient patient) {
		this._inQueue.add(patient);
	}
}
