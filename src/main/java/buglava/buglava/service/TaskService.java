package buglava.buglava.service;

import buglava.buglava.entity.Task;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskService {

    List<Task> getAllTask();

    List<Task> getAllByProjectId(int projectId);

    Task getTaskById(int taskId);

    Task addNewTask(Task task);

    void updateTask(Task task);

    void removeTask(Integer taskId);
}
