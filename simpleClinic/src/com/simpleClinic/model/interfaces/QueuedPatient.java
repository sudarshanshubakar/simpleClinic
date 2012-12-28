package com.simpleClinic.model.interfaces;

public interface QueuedPatient extends Patient, Comparable<QueuedPatient>{

	public int getQueuePosition();
}
