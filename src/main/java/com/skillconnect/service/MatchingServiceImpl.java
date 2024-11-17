package com.skillconnect.service;

import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.Project;
import com.skillconnect.repository.FreelancerProfileRepository;
import com.skillconnect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchingServiceImpl implements MatchingService{

    @Autowired
    private FreelancerProfileRepository freelancerProfileRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<FreelancerProfile> matchFreelancersToProject(Project project) {
        List<FreelancerProfile> freelancers = freelancerProfileRepository.findAll();

        // Example matching logic
        return freelancers.stream()
            .filter(freelancer -> 
                freelancer.getSkills().containsAll(project.getRequiredSkills()) &&
                freelancer.getExperience() >= project.getRequiredExperience())
            .collect(Collectors.toList());
    }

	@Override
	public List<Project> matchProjectsToFreelancer(FreelancerProfile freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

//    public List<Project> matchProjectsToFreelancer(FreelancerProfile freelancer) {
//        List<Project> projects = projectRepository.findAll();
//
//        // Example matching logic
//        return projects.stream()
//            .filter(project -> 
//                project.getRequiredSkills().containsAll(freelancer.getSkills()) &&
//                freelancer.getExperience() >= project.getRequiredExperience())
//            .collect(Collectors.toList());
//    }



	
}
