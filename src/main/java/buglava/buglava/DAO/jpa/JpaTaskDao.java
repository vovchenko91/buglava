package buglava.buglava.DAO.jpa;

import buglava.buglava.DAO.TaskDao;
import buglava.buglava.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
@Repository
public class JpaTaskDao implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task getById(Integer id) {
        Task task = entityManager.find(Task.class, id);
        return task;
    }

    @Override
    public List<Task> getAllByProjectId(Integer projectId) {
        return entityManager.createQuery("SELECT t FROM Task t WHERE t.project.id = :project_id", Task.class)
                .setParameter("project_id", projectId)
                .getResultList();
    }

    @Override
    public boolean deleteAllTasksByProjectId(Integer projectId) {
        Query query = entityManager.createQuery("DELETE FROM Task AS t WHERE t.project.id = :project_id");
        query.setParameter("project_id", projectId);

        return query.executeUpdate() != 0;
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Task save(Task task) {
        if (task.getId() == null) {
            entityManager.persist(task);
            return task;
        } else {
            return entityManager.merge(task);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer taskId) {
        Query query = entityManager.createQuery("DELETE FROM Task AS t WHERE t.id = :task_id");
        query.setParameter("task_id", taskId);

        return query.executeUpdate() != 0;
    }
}
