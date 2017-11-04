package buglava.buglava.controller;

import buglava.buglava.entity.Project;
import buglava.buglava.service.ProjectService;
import buglava.buglava.service.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
@RestController
@RequestMapping("/lava/project")
public class ProjectController {
    private ObjectMapper mapper = new ObjectMapper();

    private ProjectService projectService;
    private TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProjectById(@PathVariable("id") Integer id) throws JsonProcessingException {
        Project projectById = projectService.getProjectById(id);
        return mapper.writeValueAsString(projectById);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeProject(@PathVariable("id") Integer id) {
        taskService.removeAllTaskByProjectId(id);
        projectService.removeProject(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewProject(@RequestBody JsonNode newProject) throws JsonProcessingException {
        Project project = mapper.treeToValue(newProject, Project.class);
        if (projectService.addNewProject(project) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateProject(@PathVariable("id") Integer id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Map<String, String> mapWithProps = mapper.treeToValue(detailsToUpdate, Map.class);

        projectService.updateProject(id, mapWithProps);
    }
}
