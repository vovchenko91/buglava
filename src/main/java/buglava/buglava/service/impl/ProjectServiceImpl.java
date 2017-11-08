package buglava.buglava.service.impl;

import buglava.buglava.DAO.ProjectDao;
import buglava.buglava.DAO.springdata.ProjectRepository;
import buglava.buglava.entity.Project;
import buglava.buglava.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Integer projectId) {
        return projectRepository.getById(projectId);
    }

    @Override
    public Project addNewProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void updateProject(Integer projectId, Map<String, String> mapWithProps) {
        Project projectToUpdate = getProjectById(projectId);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "name":
                        projectToUpdate.setName(entry.getValue());
                        break;
                }
            }
        }

        projectRepository.save(projectToUpdate);
    }

    @Override
    public boolean removeProject(Integer projectId) {
        try {
            Project project = projectRepository.getById(projectId);
            projectRepository.delete(project);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
