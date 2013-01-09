package com.simpleClinic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.PatientAttributes;
import com.simpleClinic.dataTransfer.VisitAttributes;
import com.simpleClinic.exceptions.ClinicException;
import com.simpleClinic.model.helpers.PatientHelper;
import com.simpleClinic.model.helpers.VisitHelper;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicController {
	private final PatientHelper _patientHelper = PatientHelper.getInstance();
	private final VisitHelper _visitHelper = VisitHelper.getInstance();

	private final void checkRequest(ClinicRequest request) throws ClinicException {
		if (request == null) {
			throw new ClinicException("Request cannot be null.");
		}
	}
	
	public ClinicResponse createPatient(ClinicRequest request) throws ClinicException {
		checkRequest(request);
		String name = (String) request.getAttribute("name");
		if (name == null) {
			throw new ClinicException("Request should contain name");
		}
		DTO<PatientAttributes> patient = _patientHelper.create(name);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId",
				patient.get(PatientAttributes.instance().id));
		return response;
	}

	public void addPatientToQueue(ClinicRequest request) throws ClinicException {
		checkRequest(request);
		String id = (String) request.getAttribute("patientId");
		if (id == null) {
			throw new ClinicException("Request should contain id.");
		}
		_patientHelper.addPatientToQueue(id);
	}

	public ClinicResponse findPatient(ClinicRequest request)
			throws ClinicException {
		checkRequest(request);
		String findBy = (String) request.getAttribute("findBy");
		String criteria = (String) request.getAttribute("criteria");

		if (findBy == null && criteria == null) {
			throw new ClinicException(
					"Request should contain findBy and criteria attributes.");
		}

		DTO<PatientAttributes> patientDTO = _patientHelper.find(findBy,
				criteria);
		String patientId = patientDTO.get(PatientAttributes.instance().id);

		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId", patientId);
		return response;
	}

	public ClinicResponse getNextPatient() {
		DTO<PatientAttributes> patient = _patientHelper
				.getNextPatientFromQueue();
		String id = patient.get(PatientAttributes.instance().id);
		Integer queuePosition = patient
				.get(PatientAttributes.instance().queuePosition);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientId", id);
		response.setAttribute("patientQueuePosition", queuePosition);
		return response;
	}

	public ClinicResponse savePatientVisit(ClinicRequest request) throws ClinicException {
		checkRequest(request);
		@SuppressWarnings("unchecked")
		Map<String, String> visitMap = (Map<String, String>) request
				.getAttribute("visitMap");
		String id = (String) request.getAttribute("patientId");

		DTO<VisitAttributes> visitDTO = DTO.getInstance(VisitAttributes.class);
		visitDTO.set(VisitAttributes.instance().visitComments,
				visitMap.get("comments"));
		visitDTO.set(VisitAttributes.instance().relatedPatientId, id);

		String visitId = _visitHelper.save(visitDTO);
		ClinicResponse response = new ClinicResponse();
		response.setAttribute("visitId", visitId);
		return response;
	}

	public ClinicResponse getPatientVisitHistory(ClinicRequest request) throws ClinicException {
		checkRequest(request);
		String id = (String) request.getAttribute("id");
		if (id == null) {
			throw new ClinicException("Request should contain id.");
		}
		List<DTO<VisitAttributes>> patientVisits = _patientHelper
				.getVisitHistory(id);
		List<Map<String, String>> visitList = new ArrayList<Map<String, String>>();
		for (DTO<VisitAttributes> visitDTO : patientVisits) {
			Map<String, String> visitMap = new HashMap<String, String>();
			visitMap.put(visitDTO.get(VisitAttributes.instance().id), visitDTO
					.get(VisitAttributes.instance().date).toString());
			visitList.add(visitMap);
		}

		ClinicResponse response = new ClinicResponse();
		response.setAttribute("patientVisits", visitList);
		return response;
	}

	public ClinicResponse getPatientVisitDetails(ClinicRequest request) throws ClinicException {
		checkRequest(request);
		return null;
	}

}
