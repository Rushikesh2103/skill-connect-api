package com.skillconnect.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
//@Table(name="",uniqueConstraints = @UniqueConstraint((email,role))
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    
    private String role; // Add role field

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FreelancerProfile freelancerProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BusinessProfile businessProfile;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL)
    private List<Bid> bids;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NDA> ndas;

  

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<MentorshipProgram> mentorPrograms;

    @OneToMany(mappedBy = "mentee", cascade = CascadeType.ALL)
    private List<MentorshipProgram> menteePrograms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public FreelancerProfile getFreelancerProfile() {
		return freelancerProfile;
	}

	public void setFreelancerProfile(FreelancerProfile freelancerProfile) {
		this.freelancerProfile = freelancerProfile;
	}

	public BusinessProfile getBusinessProfile() {
		return businessProfile;
	}

	public void setBusinessProfile(BusinessProfile businessProfile) {
		this.businessProfile = businessProfile;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<NDA> getNdas() {
		return ndas;
	}

	public void setNdas(List<NDA> ndas) {
		this.ndas = ndas;
	}

	

	public List<MentorshipProgram> getMentorPrograms() {
		return mentorPrograms;
	}

	public void setMentorPrograms(List<MentorshipProgram> mentorPrograms) {
		this.mentorPrograms = mentorPrograms;
	}

	public List<MentorshipProgram> getMenteePrograms() {
		return menteePrograms;
	}

	public void setMenteePrograms(List<MentorshipProgram> menteePrograms) {
		this.menteePrograms = menteePrograms;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

    
}
