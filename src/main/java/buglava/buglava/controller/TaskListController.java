package buglava.buglava.controller;

import buglava.buglava.entity.Task;
import buglava.buglava.service.ProjectService;
import buglava.buglava.service.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vovchenko Denis on 11/4/2017.
 */
@RestController
@RequestMapping("/lava/tasks")
public class TaskListController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllTasks() {
        return mapper.valueToTree(taskService.getAllTask());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonNode getTaskListByProjectId(@PathVariable("id") Integer id) throws JsonProcessingException {
        List<Task> tasksListByProjectId = taskService.getAllByProjectId(id);
        return mapper.valueToTree(tasksListByProjectId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeTask(@PathVariable("id") Integer id) {
        taskService.removeAllTaskByProjectId(id);
    }
}
