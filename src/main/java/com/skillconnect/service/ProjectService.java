package com.skillconnect.service;

import com.skillconnect.model.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects();
     Optional<Project> getProjectById(int id);
    Project saveProject(Project project);
    void deleteProject(int id);
}
