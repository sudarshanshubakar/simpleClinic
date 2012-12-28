package com.simpleClinic.model.helpers;

public class VisitHelper {

	private static final VisitHelper _instance = new VisitHelper();
	
	private VisitHelper() {
	}
	
	public static VisitHelper getInstance() {
		return _instance;
	}
	
	public void save(VisitDTO visitDTO) {
		
	}
}
