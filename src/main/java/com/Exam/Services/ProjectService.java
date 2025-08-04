package com.Exam.Services;

import com.Exam.Entitys.Project;
import com.Exam.Repository.ProjectRepository;

public class ProjectService {

    private ProjectRepository projectRepository = new ProjectRepository();

    public Project getProjectByName(String projectName) {
        return projectRepository.getProjectByName(projectName);
    }
}
