package com.simpleClinic.protocol;

import java.util.HashMap;
import java.util.Map;

public class ClinicRequest {

	Map<String, Object> _attributeMap = new HashMap<String, Object>();
	
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return _attributeMap.get(name);
	}
	
	public void setAttribute(String name, Object value) {
		_attributeMap.put(name, value);
	}

}
