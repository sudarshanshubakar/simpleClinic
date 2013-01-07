package com.simpleClinic.dataTransfer;

import java.util.Comparator;

public class PatientDTOComparator<G extends AttributeGroup> implements Comparator<DTO<AttributeGroup>> {

	private static final PatientDTOComparator<AttributeGroup> _INSTANCE = new PatientDTOComparator<AttributeGroup>();
	
	public static PatientDTOComparator getInstance() {
		return _INSTANCE;
	}
	
	@Override
	public int compare(DTO<AttributeGroup> dto1, DTO<AttributeGroup> dto2) {
		// TODO Auto-generated method stub
//		if (dto1.get(PatientAttributes.instance().queuePosition) > dto2
//				.get(PatientAttributes.instance().queuePosition)) {
//			return 1;
//		} else if (dto1.get(PatientAttributes.instance().queuePosition) < dto2
//				.get(PatientAttributes.instance().queuePosition)) {
//			return -1;
//		}
		return 0;
	}
}
