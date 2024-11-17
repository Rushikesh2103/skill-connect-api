package com.skillconnect.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FreelancerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String location;
    private int experience; // in years
    @OneToOne(mappedBy = "freelancerProfile", cascade = CascadeType.ALL)
    private EarningsTracker earningsTracker;
//    @OneToMany
//    private Skill skills;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "freelancerProfile")
    private Set<Skill> skills;

    
    @OneToMany(mappedBy = "freelancerProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Certification> certifications;
//    @OneToMany
//    private Certification certifications;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    
    
    @OneToMany(mappedBy = "freelancerProfile", cascade = CascadeType.ALL)
    private Set<Bid> bids;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public EarningsTracker getEarningsTracker() {
		return earningsTracker;
	}


	public void setEarningsTracker(EarningsTracker earningsTracker) {
		this.earningsTracker = earningsTracker;
	}



	







	public Set<Skill> getSkills() {
		return skills;
	}


	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}


	public List<Certification> getCertifications() {
		return certifications;
	}


	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Bid> getBids() {
		return bids;
	}


	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

    
}
