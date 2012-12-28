package com.simpleClinic.model.helpers;

public class PatientDTO {

	private final String _id;
	private final String _name;
	private final int _queuePosition;
	public PatientDTO(String _id, String _name, int _queuePosition) {
		this._id = _id;
		this._name = _name;
		this._queuePosition = _queuePosition;
	}
	public String get_id() {
		return _id;
	}
	public String get_name() {
		return _name;
	}
	public int get_queuePosition() {
		return _queuePosition;
	}
	
	
}
