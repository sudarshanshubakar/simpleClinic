package archive;

import java.util.Date;

import com.simpleClinic.exceptions.AlreadyInitializedClinicException;

public class VisitDTO implements Comparable<VisitDTO> {

	private String id = null;
	private final Date visitDate;
	private String visitComments;
	private final String relatedPatientId;
	
	public VisitDTO(Date visitDate, String relatedPatientId) {
		this.visitDate = visitDate;
		this.relatedPatientId = relatedPatientId;
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) throws AlreadyInitializedClinicException {
		if (id ==null) {
			this.id = id;
		}
		throw new AlreadyInitializedClinicException("Visit id already set.");
		
	}



	public String getVisitComments() {
		return visitComments;
	}



	public void setVisitComments(String visitComments) {
		this.visitComments = visitComments;
	}



	public Date getVisitDate() {
		return visitDate;
	}



	public String getRelatedPatientId() {
		return relatedPatientId;
	}



	@Override
	public int compareTo(VisitDTO visit) {
		// TODO Auto-generated method stub
		return visitDate.compareTo(visit.getVisitDate());
	}

	
	
}
