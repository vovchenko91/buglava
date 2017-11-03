package buglava.buglava.controller;

import buglava.buglava.entity.Project;
import buglava.buglava.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
@RestController
@RequestMapping("/lava/project")
public class ProjectController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProjectById(@PathVariable("id") Integer id) throws JsonProcessingException {
        Project projectById = projectService.getProjectById(id);
        return mapper.writeValueAsString(projectById);
    }
}
