package com.skillconnect.model;

import jakarta.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    
    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;
    
    @ManyToOne
    @JoinColumn(name = "freelancer_profile_id")
    private FreelancerProfile freelancerProfile;

    private double amount;
    private String timeline;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(User freelancer) {
		this.freelancer = freelancer;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FreelancerProfile getFreelancerProfile() {
		return freelancerProfile;
	}
	public void setFreelancerProfile(FreelancerProfile freelancerProfile) {
		this.freelancerProfile = freelancerProfile;
	}
	

    // Getters and Setters
    
}
