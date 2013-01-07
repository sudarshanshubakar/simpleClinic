package archive;

public class PatientDTO implements Comparable<PatientDTO> {

	private final String _id;
	private final String _name;
	private final int _queuePosition;
	public PatientDTO(String _id, String _name, int _queuePosition) {
		this._id = _id;
		this._name = _name;
		this._queuePosition = _queuePosition;
	}
	
	
	
	public String getId() {
		return _id;
	}
	public String getName() {
		return _name;
	}
	public int getQueuePosition() {
		return _queuePosition;
	}



	@Override
	public int compareTo(PatientDTO patientDTO) {
		// TODO Auto-generated method stub
		if (_queuePosition > patientDTO.getQueuePosition()) {
			return 1;
		} else if(_queuePosition < patientDTO.getQueuePosition()) {
			return -1;
		}
			
		return 0;
	}
	
	
}
