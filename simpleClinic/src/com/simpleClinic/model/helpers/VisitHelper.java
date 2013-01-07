package com.simpleClinic.model.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simpleClinic.dataTransfer.AttributeGroup;
import com.simpleClinic.dataTransfer.DTO;
import com.simpleClinic.dataTransfer.VisitAttributes;
import com.simpleClinic.model.factories.VisitFactory;
import com.simpleClinic.persistence.PersistenceManager;
import com.simpleClinic.persistence.factories.PersistenceManagerFactory;

public class VisitHelper {

	private static final VisitHelper _instance = new VisitHelper();
	
	private final PersistenceManager _persManager = PersistenceManagerFactory.getInstance().getManager("SQL");
	private final VisitAttributes visitAttrInstance = VisitAttributes.instance();
	
	private VisitHelper() {
	}

	public static VisitHelper getInstance() {
		return _instance;
	}

	public final String save(final DTO<VisitAttributes> visitDTO) {
		Date visitDate = visitDTO.get(visitAttrInstance.date);
		String visitComments = visitDTO.get(visitAttrInstance.visitComments);
		String relatedPatientId = visitDTO.get(visitAttrInstance.relatedPatientId);
		String visitId = VisitFactory.getInstance().createVisit(null,
				visitDate, visitComments,
				relatedPatientId);
		return visitId;
	}
	
	public final List<DTO<? extends AttributeGroup>> getVisitsForPatient(String patientId) {
		Map<String, String> whereConditions = new HashMap<String, String>();
		whereConditions.put("relatedPatientId", patientId);
		List<DTO<? extends AttributeGroup>> visitList = _persManager.read("visit", whereConditions);
		return visitList;
	}
}
