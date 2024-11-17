package com.skillconnect.dto;

public class BidDTO {
    private int id;
    private int projectId;
    private int freelancerId;
    private double amount;
    private String timeline;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
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

	@Override
	public String toString() {
		return "BidDTO [id=" + id + ", projectId=" + projectId + ", freelancerId=" + freelancerId + ", amount=" + amount
				+ ", timeline=" + timeline + "]";
	}
    
}
