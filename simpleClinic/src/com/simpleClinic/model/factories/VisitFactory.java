package com.simpleClinic.model.factories;

import java.util.Date;
import java.util.List;

import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.VisitAttributes;
import com.simpleClinic.model.Visit;

public class VisitFactory {

	private static final VisitFactory _instance = new VisitFactory();
	
	private VisitFactory() {
		
	}
	
	public static VisitFactory getInstance() {
		return _instance;
	}
	
	public final String createVisit(String id, Date visitDate, String comments, String patientId) {
		
		Visit visit = new Visit(id, visitDate, comments, patientId);
		return visit.getId();
		
	}
	
	public final List<DTO<VisitAttributes>> getVisitsForPatient(String id) {
		return null;
	}
	
}
