package com.skillconnect.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "freelancer_profile_id")
    private FreelancerProfile freelancerProfile;

    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public FreelancerProfile getFreelancerProfile() {
		return freelancerProfile;
	}

	public void setFreelancerProfile(FreelancerProfile freelancerProfile) {
		this.freelancerProfile = freelancerProfile;
	}

	public boolean containsAll(List<FreelancerProfile> requiredSkills) {
		// TODO Auto-generated method stub
		return false;
	}

    // Getters and Setters
    
}
