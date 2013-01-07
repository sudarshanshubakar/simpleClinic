package com.simpleClinic.model.interfaces;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;

public interface Patient {

	public String getName();
	
	public String getID();
	
	public DTO<PatientAttributes> getDTO();
	
}
