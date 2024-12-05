package project.dto;

import project.entity.Task;

import java.io.Serializable;
import java.util.List;

public class TagDTO implements Serializable {

    private long id;

    private  String name;

    private List<Task> tasks;

    public TagDTO(long id, String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public TagDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
