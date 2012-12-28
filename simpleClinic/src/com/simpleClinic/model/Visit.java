package com.simpleClinic.model;

import java.util.Date;

import com.simpleClinic.exceptions.AlreadyInitializedClinicException;

public class Visit implements Comparable<Visit> {

	private String _id;
	private final Date _visitDate;
	private final String _visitComments;
	private final String _relatedPatientId;
	
	public Visit(String id, Date date, String comments, String patientId) {
		this._id = id;
		this._visitDate = date;
		this._visitComments = comments;
		this._relatedPatientId = patientId;
	}
	
	public String getId() {
		return _id;
	}
	
	public void setId(String id) throws AlreadyInitializedClinicException {
		if(this._id !=null) {
			throw new AlreadyInitializedClinicException("Cannot reset id of visit.");
		}
		this._id = id;
	}
	
	public String getVisitDate() {
		return _visitDate.toString();
	}
	

	public String getVisitComments() {
		return _visitComments;
	}
	
	public String getPatientId() {
		return _relatedPatientId;
	}

	@Override
	public int compareTo(Visit visit) {
		// TODO Auto-generated method stub
		Date visitDate = new Date();
		return this._visitDate.compareTo(visitDate);
	}
	
}
