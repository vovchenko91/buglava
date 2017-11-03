package buglava.buglava.service;

import buglava.buglava.entity.Project;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
public interface ProjectService {

    List<Project> getAllProjects();

    Project getProjectById(Integer projectId);

/*    Project createProject(Project project);

    void updateProject(Project project);

    void deleteProject(long projectId);*/
}
