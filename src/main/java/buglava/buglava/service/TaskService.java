package buglava.buglava.service;

import buglava.buglava.entity.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskService {

    List<Task> getAllTask();

    Task getTaskById(int taskId);

    Task addNewTask(Task task);

    void updateTask(Integer taskId, Map<String, String> mapWithProps);

    void removeTask(Integer taskId);
}
