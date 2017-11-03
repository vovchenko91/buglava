package buglava.buglava.DAO;

import buglava.buglava.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
public interface ProjectRepository extends CrudRepository<Project, Long>{

    /*Project getById(long id);*/

    @Query("select p from Project p where p.id = :id")
    Project getProjectById(@Param("id") Integer id);

    List<Project> findAll();

/*    Project save(Project project);

    void update(Project project);

    void delete(Long projectId);*/
}
