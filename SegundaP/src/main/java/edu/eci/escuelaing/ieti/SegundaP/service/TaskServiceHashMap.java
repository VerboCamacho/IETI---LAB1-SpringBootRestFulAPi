package edu.eci.escuelaing.ieti.SegundaP.service;
import edu.eci.escuelaing.ieti.SegundaP.data.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class TaskServiceHashMap implements edu.eci.escuelaing.ieti.SegundaP.service.TaskService {

    private HashMap<String, Task> TaskHash = new HashMap<String, Task>();


    @Override
    public Task create(Task task) {
        Task createdTask=new Task(task.getName(), task.getDescription(), task.getStatus(), task.getAssignedTo(), task.getDueDate(), task.getCreated());
        TaskHash.put(createdTask.getId(), createdTask);
        return createdTask;
    }

    @Override
    public Task findById(String id) {
        Task TaskMatch = null;
        TaskHash.get(id);
        return TaskMatch;
    }

    @Override
    public List<Task> all() {
        ArrayList<Task> List=new ArrayList<Task>(TaskHash.values());
        return List;
    }

    @Override
    public void deleteById(String id) {
        TaskHash.remove(id);

    }

    @Override
    public Task update(Task task, String id) {
        Task MatchTask = findById(id);
        if(MatchTask!=null){
            TaskHash.put(id, task);
        }
        return MatchTask;
    }
}
