package buglava.buglava.controller;

import buglava.buglava.service.ProjectService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
@RestController
@RequestMapping("/b1/projects")
public class ProjectListController {

    private ObjectMapper mapper = new ObjectMapper();

    private ProjectService projectService;

    @Autowired
    public ProjectListController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllProjects() {
        return mapper.valueToTree(projectService.getAllProjects());
    }
}
