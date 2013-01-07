package com.simpleClinic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;
import com.simpleClinic.dataTransfer.VisitAttributes;
import com.simpleClinic.model.helpers.PatientHelper;
import com.simpleClinic.model.helpers.VisitHelper;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicController {
	private final PatientHelper _patientHelper = PatientHelper.getInstance();
	private final VisitHelper _visitHelper = VisitHelper.getInstance();
	public ClinicResponse createPatient(ClinicRequest request) {
		String name = (String) request.getAttribute("name");
		DTO<PatientAttributes> patient = _patientHelper.create(name);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("operationResult" , patient.get(PatientAttributes.instance().id));
		return response;
	}
	
	public ClinicResponse addPatientToQueue(ClinicRequest request) {
		String id = (String) request.getAttribute("id");
		_patientHelper.addPatientToQueue(id);
	
		return null;
	}
	
	public ClinicResponse findPatient(ClinicRequest request) {
		String findBy = (String) request.getAttribute("findBy");
		String criteria = (String) request.getAttribute("criteria");
		String patientId = _patientHelper.find(findBy, criteria).get(PatientAttributes.instance().id);
		
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId", patientId);
		return response;
	}
	
	public ClinicResponse getNextPatient(ClinicRequest request) {
		DTO<PatientAttributes> patient = _patientHelper.getNextPatientFromQueue();
		String id = patient.get(PatientAttributes.instance().id);
		int queuePosition = patient.get(PatientAttributes.instance().queuePosition);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId" , id);
		response.setAttribute("patientQueuePosition", queuePosition);
		return response;
	}
	
	public ClinicResponse savePatientVisit(ClinicRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, String> visitMap = (Map<String, String>) request.getAttribute("visitMap");
		String id = (String) request.getAttribute("patientId");
//		VisitDTO visitDTO = new VisitDTO(new Date(), id);
//		visitDTO.setVisitComments(visitMap.get("comments"));
		DTO<VisitAttributes> visitDTO = DTO.getInstance(VisitAttributes.class);
		visitDTO.set(VisitAttributes.instance().visitComments, visitMap.get("comments"));
		visitDTO.set(VisitAttributes.instance().relatedPatientId, id);
		
		String visitId = _visitHelper.save(visitDTO);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("visitId", visitId);
		return response;
	}
	
	public ClinicResponse getPatientVisitHistory(ClinicRequest request) {
		String id = (String) request.getAttribute("id");
		List<DTO<VisitAttributes>> patientVisits = _patientHelper.getVisitHistory(id);
		List<Map<String,String>> visitList = new ArrayList<Map<String,String>>();
		for(DTO<VisitAttributes> visitDTO : patientVisits) {
			Map<String, String> visitMap = new HashMap<String, String>();
			visitMap.put(visitDTO.get(VisitAttributes.instance().id), visitDTO.get(VisitAttributes.instance().date).toString());
			visitList.add(visitMap);
		}
		
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientVisits", visitList);
		return response;
	}
	
	public ClinicResponse getPatientVisitDetails(ClinicRequest request) {
		
		
		return null;
	}
	
}
