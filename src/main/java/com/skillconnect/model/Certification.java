package com.skillconnect.model;

import jakarta.persistence.*;

@Entity
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private FreelancerProfile freelancerProfile;

    private String name;
    private String issuedBy;
    private String issuedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FreelancerProfile getFreelancerProfile() {
		return freelancerProfile;
	}
	public void setFreelancerProfile(FreelancerProfile freelancerProfile) {
		this.freelancerProfile = freelancerProfile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	public String getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

        
}
