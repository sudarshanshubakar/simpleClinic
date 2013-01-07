package com.simpleClinic.dataTransfer;

import java.util.Date;


public class VisitAttributes implements AttributeGroup {
	
	private static final VisitAttributes _instance = new VisitAttributes();
	
	private VisitAttributes() {
	}
	
	public static VisitAttributes instance() {
		return _instance;
	}
	
	public final Attribute<VisitAttributes, String> id = Attribute.getInstance("id");
	public final Attribute<VisitAttributes, Date> date = Attribute.getInstance("date");
	public final Attribute<VisitAttributes, String> visitComments = Attribute.getInstance("visitComments");
	public final Attribute<VisitAttributes, String> relatedPatientId = Attribute.getInstance("relatedPatientId");


}
