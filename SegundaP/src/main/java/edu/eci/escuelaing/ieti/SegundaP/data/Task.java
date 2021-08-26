package edu.eci.escuelaing.ieti.SegundaP.data;

import edu.eci.escuelaing.ieti.SegundaP.dto.TaskDto;

import java.sql.Date;
import java.sql.Timestamp;

public class Task {
    private String id;
    private String name;
    private String description;
    public enum StatusT
    {
        TODO, DOING, REVIEW, DONE
    };
    private StatusT status;
    private String assignedTo;
    private java.sql.Date dueDate;
    private java.sql.Date created;
    public Task(String name, String description, StatusT status, String assignedTo, Date dueDate,Date created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
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

    public StatusT getStatus() {
        return status;
    }

    public void setStatus(StatusT status) {
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
