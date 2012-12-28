package com.simpleClinic.model.interfaces;

import com.simpleClinic.model.helpers.PatientDTO;

public interface Patient {

	public String getName();
	
	public String getID();
	
	public PatientDTO getDTO();
	
}
