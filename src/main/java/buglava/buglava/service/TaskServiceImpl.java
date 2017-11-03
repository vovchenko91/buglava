package buglava.buglava.service;

import buglava.buglava.DAO.ProjectRepository;
import buglava.buglava.DAO.TaskRepository;
import buglava.buglava.entity.Project;
import buglava.buglava.entity.Status;
import buglava.buglava.entity.Task;
import buglava.buglava.entity.Type;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TaskRepository taskRepository;
    ProjectRepository projectRepository;

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByProjectId(int projectId) {
        return taskRepository.getTasksByProjectId(projectId);
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public Task addNewTask(Task task) {
        return taskRepository.save(task);
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
                        taskToUpdate.setPriority(Pri.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        watchRepository.save(watchToUpdate);
    }

    @Override
    public void removeTask(Integer taskId) {

    }
}
