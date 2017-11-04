package buglava.buglava.DAO.springdata;

import buglava.buglava.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task getById(Integer id);

    List<Task> getAllByProjectId(Integer projectId);

    void deleteAllTasksByProjectId(Integer projectId);

    List<Task> findAll();

    Task save(Task task);

    void delete(Task task);
}
