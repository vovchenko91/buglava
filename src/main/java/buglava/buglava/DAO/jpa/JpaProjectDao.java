package buglava.buglava.DAO.jpa;

import buglava.buglava.DAO.ProjectDao;
import buglava.buglava.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.ProcessingEnvironment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaProjectDao implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Project getById(Integer id) {
        Project project = entityManager.find(Project.class, id);
        return project;
    }

    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("SELECT p FROM Project p", Project.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Project save(Project project) {
        if (project.getId() == null) {
            entityManager.persist(project);
            return project;
        } else {
            return entityManager.merge(project);
        }
    }

    @Override
    @Transactional
    public boolean delete(int projectId) {
        Query query = entityManager.createQuery("DELETE FROM Project p WHERE p.id = :project_id");
        query.setParameter("project_id", projectId);

        return query.executeUpdate() != 0;
    }
}
