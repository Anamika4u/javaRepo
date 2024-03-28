package com.model;

import java.util.Date;

public class Applicant {
	
	private String personalId;
	private String applicantName;
	private Date dateOfApplication;
	private int applicantAge;
	private double monthlyIncome;
	private String applicationStatus;
	
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public Date getDateOfApplication() {
		return dateOfApplication;
	}
	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
	public int getApplicantAge() {
		return applicantAge;
	}
	public void setApplicantAge(int applicantAge) {
		this.applicantAge = applicantAge;
	}
	public double getMonthlyIncome() {	 	  	      		      	   	     	     	 	
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public Applicant(String personalId, String applicantName, Date dateOfApplication, int applicantAge,
			double monthlyIncome, String applicationStatus) {
		super();
		this.personalId = personalId;
		this.applicantName = applicantName;
		this.dateOfApplication = dateOfApplication;
		this.applicantAge = applicantAge;
		this.monthlyIncome = monthlyIncome;
		this.applicationStatus = applicationStatus;
	}
	
	public Applicant() {
		super();
	}
}
