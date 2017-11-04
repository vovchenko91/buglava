package buglava.buglava.service;

import buglava.buglava.entity.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskService {

    List<Task> getAllTask();

    List<Task> getAllByProjectId(int projectId);

    void removeAllTaskByProjectId(Integer projectById);

    Task getTaskById(int taskId);

    Task addNewTask(Task task);

    void updateTask(Integer taskId, Map<String, String> mapWithProps);

    boolean removeTask(Integer taskId);
}
