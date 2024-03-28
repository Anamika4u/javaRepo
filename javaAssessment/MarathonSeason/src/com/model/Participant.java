package com.model;

import java.util.Date;

public class Participant {

	private String participantId;
	private String participantName;
	private int participantAge;
	private String address;
	private Date marathonDate;
	private String participantCategory;
	public Participant() {
		super();
	}
	public Participant(String participantId, String participantName, String address,
			Date marathonDate, String participantCategory) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.participantAge = participantAge;
		this.address = address;
		this.marathonDate = marathonDate;
		this.participantCategory = participantCategory;
	}
	public String getParticipantId() {
		return participantId;
	}
	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public int getParticipantAge() {
		return participantAge;
	}
	public void setParticipantAge(int participantAge) {
		this.participantAge = participantAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getMarathonDate() {
		return marathonDate;
	}
	public void setMarathonDate(Date marathonDate) {
		this.marathonDate = marathonDate;
	}
	public String getParticipantCategory() {
		return participantCategory;
	}
	public void setParticipantCategory(String participantCategory) {
		this.participantCategory = participantCategory;
	}
	
}
