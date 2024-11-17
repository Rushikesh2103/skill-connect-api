package com.skillconnect.service;

import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.Project;

import java.util.List;

public interface MatchingService {
    List<FreelancerProfile> matchFreelancersToProject(Project project);
    List<Project> matchProjectsToFreelancer(FreelancerProfile freelancer);
}
