package com.simpleClinic.model;

import com.simpleClinic.model.helpers.PatientDTO;
import com.simpleClinic.model.interfaces.QueuedPatient;

public class QueuedNormalPatient implements QueuedPatient{

	private final NormalPatient _patient;
	private final int _queuePosition;
	
	public QueuedNormalPatient(String id, String name, int queuePosition) {
		this._patient = new NormalPatient(id, name);
		this._queuePosition = queuePosition;
	}
	
	@Override
	public String getName() {
		return _patient.getName();
	}

	@Override
	public String getID() {
		return _patient.getID();
	}

	@Override
	public int getQueuePosition() {
		return _queuePosition;
	}

	@Override
	public int compareTo(QueuedPatient queuedPatient) {
		if(this._queuePosition > queuedPatient.getQueuePosition()) {
			return 1;
		} else if (this._queuePosition < queuedPatient.getQueuePosition()) {
			return -1;
		}
		return 0;
	}

	@Override
	public PatientDTO getDTO() {
		// TODO Auto-generated method stub
		return new PatientDTO(getID(), getName(), getQueuePosition());
	}

}
