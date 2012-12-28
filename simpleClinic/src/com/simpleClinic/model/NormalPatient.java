package com.simpleClinic.model;

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

}
