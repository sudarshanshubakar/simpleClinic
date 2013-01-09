package com.simpleClinic.dataTransfer;

import com.simpleClinic.exceptions.ClinicException;
import com.simpleClinic.model.QueuedNormalPatient;
import com.simpleClinic.model.interfaces.Patient;

public class PatientDTOAssembler {
	
	public static final PatientDTOAssembler getInstance() {
		return new PatientDTOAssembler();
	}
	
	public final DTO<PatientAttributes> createPatientDTO(Patient patient) throws ClinicException {
		if (patient == null) {
			throw new ClinicException("Patient Object is null. DTO cannot be created.");
		}
		DTO<PatientAttributes> patientDTO = DTO.getInstance(PatientAttributes.class);
		patientDTO.set(PatientAttributes.instance().id, patient.getID());
		patientDTO.set(PatientAttributes.instance().name, patient.getName());
		
		if (patient instanceof QueuedNormalPatient) {
			patientDTO.set(PatientAttributes.instance().queuePosition, ((QueuedNormalPatient)patient).getQueuePosition());
		}
		
		return patientDTO;
	}
}
