package com.simpleClinic.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.simpleClinic.controller.ClinicController;
import com.simpleClinic.exceptions.ClinicException;
import com.simpleClinic.protocol.ClinicRequest;
import com.simpleClinic.protocol.ClinicResponse;

public class ClinicControllerTest {

	private final ClinicController controller = new ClinicController();
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=ClinicException.class)
	public final void testCreatePatient_nullRequest() throws ClinicException {
		controller.createPatient(null);
	}
	
	@Test(expected=ClinicException.class)
	public final void testCreatePatient_invalidParams() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		request.setAttribute("test", "00001");
		controller.createPatient(request);
	}
	
	@Test
	public final void testCreatePatient_validParams() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		request.setAttribute("name", "Sudarshan");
		ClinicResponse response = controller.createPatient(request);
		String patientId = (String) response.getAttribute("patientId");
		assertNotNull("null patientId returned. Should not be null.", patientId);
	}

	@Test(expected=ClinicException.class)
	public final void testAddPatientToQueue_nullRequest() throws ClinicException {
		controller.addPatientToQueue(null);
	}
	
	@Test(expected=ClinicException.class)
	public final void testAddPatientToQueue_invalidParams() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		request.setAttribute("test", "00001");
		controller.addPatientToQueue(request);
	}
	
	@Test
	public final void testAddPatientToQueue_validParams() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		
		String patientId = "00001";
		request.setAttribute("patientId", patientId);
		controller.addPatientToQueue(request);
		
		ClinicResponse response = controller.getNextPatient();
		String nextPatientId = (String) response.getAttribute("patientId");
		assertEquals("Patient not added to queue or not Retrived from queue correctly", patientId, nextPatientId);
	}	

	@Test(expected=ClinicException.class)
	public final void testFindPatient_nullRequest() throws ClinicException {
		controller.findPatient(null);
	}

	@Test(expected=ClinicException.class)
	public final void testFindPatient_emptyRequest() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		controller.findPatient(request);
	}

	@Test(expected=ClinicException.class)
	public final void testFindPatient_invalidRequestParams() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		request.setAttribute("test", "test");
		request.setAttribute("test1", "test1");
		controller.findPatient(request);
	}
	
	@Test
	public final void testFindPatient_validReqParams_resNotNull() throws ClinicException {
		ClinicRequest request = new ClinicRequest();
		request.setAttribute("findBy", "name");
		request.setAttribute("criteria", "Sudarshan");
		ClinicResponse response = controller.findPatient(request);
		assertNotNull("Response is null.", response);
	}
	
	
	
	
	
	
	
	@Test
	public final void testGetNextPatient() throws ClinicException {
		testAddPatientToQueue_validParams();
	}

	@Test
	public final void testSavePatientVisit() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetPatientVisitHistory() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetPatientVisitDetails() {
		fail("Not yet implemented");
	}

}
