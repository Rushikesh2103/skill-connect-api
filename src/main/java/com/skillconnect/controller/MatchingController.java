package com.skillconnect.controller;

import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.Project;
import com.skillconnect.service.FreelancerProfileService;
import com.skillconnect.service.MatchingServiceImpl;
import com.skillconnect.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchingController {

    @Autowired
    private MatchingServiceImpl matchingService;
    @Autowired
    private FreelancerProfileService f;
    @GetMapping("/freelancers/{projectId}")
    public List<FreelancerProfile> getMatchingFreelancers(@PathVariable int projectId) {
        Project project = null;
		try {
			//project = ProjectService.getProjectById(projectId).orElseThrow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return matchingService.matchFreelancersToProject(project);
    }

//    @GetMapping("/projects/{freelancerId}")
//    public List<Project> getMatchingProjects(@PathVariable int freelancerId) {
//        Project freelancer = FreelancerProfileService.getProfileById(freelancerId).orElseThrow();
//        return matchingService.matchProjectsToFreelancer(freelancer);
//    }
}
