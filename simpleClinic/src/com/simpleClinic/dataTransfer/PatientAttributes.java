package com.simpleClinic.dataTransfer;


public class PatientAttributes implements AttributeGroup, Comparable<PatientAttributes> {
	
	private static final PatientAttributes _instance = new PatientAttributes();
	
	private PatientAttributes() {
	}
	
	public static PatientAttributes instance() {
		return _instance;
	}
	
	public final Attribute<PatientAttributes, String> id = Attribute.getInstance("id");
	public final Attribute<PatientAttributes, String> name = Attribute.getInstance("name");
	public final Attribute<PatientAttributes, Integer> queuePosition = Attribute.getInstance("queuePosition");

	@Override
	public int compareTo(PatientAttributes patientAttributes) {
		// TODO Auto-generated method stub
		return 0;
	}
}
