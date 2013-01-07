package com.simpleClinic.dataTransfer;

import java.util.Comparator;

public class VisitDTOComparator implements Comparator<DTO<VisitAttributes>> {

	@Override
	public int compare(DTO<VisitAttributes> dto1, DTO<VisitAttributes> dto2) {
		// TODO Auto-generated method stub
		VisitAttributes va = VisitAttributes.instance();
		int compareResult = dto1.get(va.date).compareTo(dto2.get(va.date));
		return compareResult;
	}

}
