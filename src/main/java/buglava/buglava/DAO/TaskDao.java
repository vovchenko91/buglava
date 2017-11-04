package buglava.buglava.DAO;

import buglava.buglava.entity.Task;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskDao {

    Task getById(Integer id);

    List<Task> getAllByProjectId(Integer projectId);

    boolean deleteAllTasksByProjectId(Integer projectId);

    List<Task> findAll();

    Task save(Task task);

    boolean delete(Integer taskId);
}
