package buglava.buglava.service.impl;

import buglava.buglava.DAO.ProjectDao;
import buglava.buglava.DAO.TaskDao;
import buglava.buglava.entity.*;
import buglava.buglava.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;
    private ProjectDao projectDao;

    public TaskServiceImpl(TaskDao taskDao, ProjectDao projectDao) {
        this.taskDao = taskDao;
        this.projectDao = projectDao;
    }

    @Override
    public List<Task> getAllTask() {
        return taskDao.findAll();
    }

    @Override
    public List<Task> getAllByProjectId(int projectId) {
        return taskDao.getAllByProjectId(projectId);
    }

    @Override
    public void removeAllTaskByProjectId(Integer projectId) {
        taskDao.deleteAllTasksByProjectId(projectId);
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskDao.getById(taskId);
    }

    @Override
    public Task addNewTask(Task task) {
        try {
            Project project = task.getProject();
            projectDao.getById(project.getId());
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return taskDao.save(task);
    }

    @Override
    public void updateTask(Integer id, Map<String, String> mapWithProps) {
        Task taskToUpdate = getTaskById(id);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "name":
                        taskToUpdate.setName(entry.getValue());
                        break;
                    case "type":
                        taskToUpdate.setType(Type.valueOf(entry.getValue()));
                        break;
                    case "status":
                        taskToUpdate.setStatus(Status.valueOf(entry.getValue()));
                        break;
                    case "priority":
                        taskToUpdate.setPriority(Priority.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        taskDao.save(taskToUpdate);
    }

    @Override
    public boolean removeTask(Integer taskId) {
        try {
            taskDao.delete(taskId);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
