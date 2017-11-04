package buglava.buglava.DAO;

import buglava.buglava.entity.Project;
import buglava.buglava.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task getById(Integer id);

    List<Task> getAllByProjectId(Integer projectId);
/*
    @Query("delete from task t where t.project_id = :projectId")
    void deleteAllTasksByProjectId(@Param("projectId") Project project);*/

    void deleteAllTasksByProjectId(Integer projectId);

    List<Task> findAll();

    Task save(Task task);

    void delete(Task task);
}
