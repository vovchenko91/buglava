package buglava.buglava.DAO;

import buglava.buglava.entity.Project;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
public interface ProjectDao {

    Project getById(Integer id);

    List<Project> findAll();

    Project save(Project project);

    boolean delete(int projectId);
}
