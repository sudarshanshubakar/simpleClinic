package com.simpleClinic.model;

import com.simpleClinic.model.interfaces.Patient;

public class NormalPatient implements Patient {

	private String _name = "";
	private String _ID = "";
	
	public NormalPatient(String name) {
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
