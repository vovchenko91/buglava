package buglava.buglava.controller;

import buglava.buglava.entity.Task;
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
 * Created by Vovchenko Denis on 11/4/2017.
 */
@RestController
@RequestMapping("/lava/task")
public class TaskController {
    private ObjectMapper mapper = new ObjectMapper();

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTaskById(@PathVariable("id") Integer id) throws JsonProcessingException {
        Task taskById = taskService.getTaskById(id);
        return mapper.writeValueAsString(taskById);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeTask(@PathVariable("id") Integer id) {
        taskService.removeTask(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewTask(@RequestBody JsonNode newTask) throws JsonProcessingException {
        Task task = mapper.treeToValue(newTask, Task.class);
        if (taskService.addNewTask(task) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateTask(@PathVariable("id") Integer id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Map<String, String> mapWithProps = mapper.treeToValue(detailsToUpdate, Map.class);

        taskService.updateTask(id, mapWithProps);
    }
}
