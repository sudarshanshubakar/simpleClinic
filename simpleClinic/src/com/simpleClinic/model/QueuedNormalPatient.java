package com.simpleClinic.model;

import com.simpleClinic.model.interfaces.QueuedPatient;

public class QueuedNormalPatient implements QueuedPatient {

	private final NormalPatient _patient;
	private final int _queuePosition;
	
	public QueuedNormalPatient(String name, int queuePosition) {
		this._patient = new NormalPatient(name);
		this._queuePosition = queuePosition;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _patient.getName();
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _patient.getID();
	}

	@Override
	public int getQueuePosition() {
		// TODO Auto-generated method stub
		return _queuePosition;
	}

}
