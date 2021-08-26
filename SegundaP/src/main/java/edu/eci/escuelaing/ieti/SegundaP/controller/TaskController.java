package edu.eci.escuelaing.ieti.SegundaP.controller;


import edu.eci.escuelaing.ieti.SegundaP.data.Task;
import edu.eci.escuelaing.ieti.SegundaP.dto.TaskDto;
import edu.eci.escuelaing.ieti.SegundaP.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "/v2/task" )
public class TaskController
{

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService)
    {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
        return new ResponseEntity<List<Task>>(taskService.all(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id )
    {
        Task taskMatch = taskService.findById(id);
        if(taskMatch ==null){
            return new ResponseEntity<Task> (HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Task>(taskMatch, HttpStatus.FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto )
    {
        Task newTask =new Task(UUID.randomUUID().toString(), taskDto.getDescription(), Task.StatusT.DOING,taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.getCreated());
        taskService.create(newTask);
        return new ResponseEntity<Task>(newTask, HttpStatus.OK);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id )
    {
        Task taskToPut =new Task (taskDto.getName(),taskDto.getDescription(),Task.StatusT.DOING,taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.getCreated());
        taskService.update(taskToPut, id);
        return new ResponseEntity<Task>(taskToPut, HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        if(taskService.findById(id)==null){
            return new ResponseEntity<Boolean> (HttpStatus.NOT_FOUND);
        }else{
            taskService.deleteById(id);
            return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
        }
    }
}