package com.skillconnect.model;

import jakarta.persistence.*;

@Entity
public class EarningsTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double totalEarnings;
    private double monthlyEarnings;
    private String goals;
    @OneToOne
    @JoinColumn(name = "freelancer_profile_id")
    private FreelancerProfile freelancerProfile;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public double getMonthlyEarnings() {
		return monthlyEarnings;
	}
	public void setMonthlyEarnings(double monthlyEarnings) {
		this.monthlyEarnings = monthlyEarnings;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}

    // Getters and Setters
    
}
