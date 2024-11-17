package com.skillconnect.controller;

import com.skillconnect.dto.ProjectDTO;
import com.skillconnect.model.Project;
import com.skillconnect.model.User;
import com.skillconnect.service.ProjectService;
import com.skillconnect.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectDTO> projectDTOs = projects.stream().map(project -> {
            ProjectDTO dto = new ProjectDTO();
            dto.setId(project.getId());
            dto.setTitle(project.getTitle());
            dto.setDescription(project.getDescription());
            dto.setBudget(project.getBudget());
            dto.setDeadline(project.getDeadline());
            dto.setProjectType(project.getProjectType());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(projectDTOs);
    }

    @GetMapping("/api/projects/{id}")
    public ResponseEntity<ProjectDTO> getProjectDetails(@PathVariable int id) {
    	System.out.println("idddd"+id);
    	Optional<Project> projectop = projectService.getProjectById(id);

        if (projectop.isPresent()) {
            Project project = projectop.get();

            // Assuming your User entity has a related FreelancerProfile entity with the needed details
            ProjectDTO dto = new ProjectDTO();
            dto.setId(project.getId());
            dto.setTitle(project.getTitle());
            dto.setDescription(project.getDescription());
            dto.setBudget(project.getBudget());
            dto.setDeadline(project.getDeadline());
            dto.setProjectType(project.getProjectType());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        // Convert ProjectDTO to Project entity
        Project project = new Project();
        project.setBudget(projectDTO.getBudget());
        project.setDeadline(projectDTO.getDeadline());
        project.setDescription(projectDTO.getDescription());
        project.setProjectType(projectDTO.getProjectType());
        project.setStatus(projectDTO.getStatus());
        project.setTitle(projectDTO.getTitle());

     
        User business = userService.findById(projectDTO.getBusinessId());
        if (business == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Or a suitable error response
        }
        project.setBusiness(business);

       
        Project createdProject = projectService.saveProject(project);

        // Convert the saved Project entity back to ProjectDTO
        ProjectDTO createdProjectDTO = new ProjectDTO();
        createdProjectDTO.setId(createdProject.getId());
        createdProjectDTO.setBudget(createdProject.getBudget());
        createdProjectDTO.setDeadline(createdProject.getDeadline());
        createdProjectDTO.setDescription(createdProject.getDescription());
        createdProjectDTO.setProjectType(createdProject.getProjectType());
        createdProjectDTO.setStatus(createdProject.getStatus());
        createdProjectDTO.setTitle(createdProject.getTitle());
        createdProjectDTO.setBusinessId(createdProject.getBusiness().getId());

        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjectDTO);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
//        if (!ProjectService.getProjectById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        project.setId(id);
//        return ResponseEntity.ok(projectService.saveProject(project));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
//        if (!ProjectService.getProjectById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        projectService.deleteProject(id);
//        return ResponseEntity.noContent().build();
//    }
}
