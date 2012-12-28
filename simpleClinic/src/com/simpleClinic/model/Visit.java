package com.simpleClinic.model;

import java.util.Date;

public class Visit implements Comparable<Visit> {

	private final String _id;
	private final Date _visitDate;
	
	public Visit(String id, Date date) {
		this._id = id;
		this._visitDate = date;
	}
	
	public String getId() {
		return _id;
	}
	
	public String getVisitDate() {
		return _visitDate.toString();
	}

	@Override
	public int compareTo(Visit visit) {
		// TODO Auto-generated method stub
		Date visitDate = new Date();
		return this._visitDate.compareTo(visitDate);
	}
	
}
