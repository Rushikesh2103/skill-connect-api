package com.skillconnect.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private User business;
    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;
    private String title;
    private String description;
    private double budget;
    private String deadline;
    private String projectType; // e.g., FIXED_PRICE, BIDDING
    
    private String status;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Bid> bids;

    

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<NDA> ndas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getBusiness() {
		return business;
	}

	public void setBusiness(User business) {
		this.business = business;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<NDA> getNdas() {
		return ndas;
	}

	public void setNdas(List<NDA> ndas) {
		this.ndas = ndas;
	}



	public int getRequiredExperience() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<FreelancerProfile> getRequiredSkills() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRequiredSkills(List<FreelancerProfile> requiredSkills) {
		// TODO Auto-generated method stub
		
	}

    
}
