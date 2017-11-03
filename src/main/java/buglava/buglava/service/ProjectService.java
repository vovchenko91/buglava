package buglava.buglava.service;

import buglava.buglava.entity.Project;

import java.util.List;
import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
public interface ProjectService {

    List<Project> getAllProjects();

    Project getProjectById(Integer projectId);

    Project addNewProject(Project project);

    void updateProject(Integer project, Map<String, String> mapWithProps);

    boolean removeProject(Integer projectId);
}
