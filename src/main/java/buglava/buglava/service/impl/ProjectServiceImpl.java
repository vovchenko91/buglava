package buglava.buglava.service.impl;

import buglava.buglava.DAO.ProjectDao;
import buglava.buglava.entity.Project;
import buglava.buglava.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
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

    private ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    @Override
    public Project getProjectById(Integer projectId) {
        return projectDao.getById(projectId);
    }

    @Override
    public Project addNewProject(Project project) {
        return projectDao.save(project);
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

        projectDao.save(projectToUpdate);
    }

    @Override
    public boolean removeProject(Integer projectId) {
        try {
            projectDao.delete(projectId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
