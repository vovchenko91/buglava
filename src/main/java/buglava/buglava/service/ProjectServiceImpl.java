package buglava.buglava.service;

import buglava.buglava.DAO.ProjectRepository;
import buglava.buglava.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Integer projectId) {
        return projectRepository.getProjectById(projectId);
    }

/*    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.update(project);
    }

    @Override
    public void deleteProject(long projectId) {
        projectRepository.delete(projectId);
    }*/
}
