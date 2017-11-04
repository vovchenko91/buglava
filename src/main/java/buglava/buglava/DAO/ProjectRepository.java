package buglava.buglava.DAO;

import buglava.buglava.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
public interface ProjectRepository extends CrudRepository<Project, Long>{

    Project getById(Integer id);

    List<Project> findAll();

    Project save(Project project);

    void delete(Project project);
}
