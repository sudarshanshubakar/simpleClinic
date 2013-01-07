package com.simpleClinic.model;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;
import com.simpleClinic.model.interfaces.Patient;

public class NormalPatient implements Patient {

	private final String _name;
	private final String _ID;
	
	public NormalPatient(String id, String name) {
		this._ID = id;
		this._name = name;
	}
	
	public String getName() {
		return _name;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return _ID;
	}

	@Override
	public DTO<PatientAttributes> getDTO() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public PatientDTO getDTO() {
//		// TODO Auto-generated method stub
//		return new PatientDTO(_ID, _name, 0);
//	}



}
