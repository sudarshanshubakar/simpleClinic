package com.simpleClinic.dataTransfer;

import java.util.Comparator;

public class PatientDTOComparator<G extends AttributeGroup> implements Comparator<DTO<G>> {

	
	@SuppressWarnings("unchecked")
	@Override
	public  int compare(DTO<G> dto1, DTO<G> dto2) {
		// TODO Auto-generated method stub
		if (dto1.get((Attribute<G, Integer>) PatientAttributes.instance().queuePosition) > dto2
				.get((Attribute<G, Integer>) PatientAttributes.instance().queuePosition)) {
			return 1;
		} else if (dto1.get((Attribute<G, Integer>) PatientAttributes.instance().queuePosition) < dto2
				.get((Attribute<G, Integer>) PatientAttributes.instance().queuePosition)) {
			return -1;
		}
		return 0;
	}
}
