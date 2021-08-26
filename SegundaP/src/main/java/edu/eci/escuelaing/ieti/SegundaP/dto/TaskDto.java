package edu.eci.escuelaing.ieti.SegundaP.dto;

import edu.eci.escuelaing.ieti.SegundaP.data.Task;

import java.sql.Date;
import java.util.UUID;

public class TaskDto {
    private String id;
    private String name;
    private String description;

    private Task.StatusT status;
    private String assignedTo;
    private Date dueDate;
    private Date created;

    public TaskDto(String name, String description, Task.StatusT status, String assignedTo, Date dueDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = new Date(System.currentTimeMillis());
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task.StatusT getStatus() {
        return status;
    }

    public void setStatus(Task.StatusT status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }




}
