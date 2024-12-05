package project.dto;

import project.entity.Task;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StatusDTO implements Serializable {
    private long id;

    private String statusName;

    private List<Task> tasks;

    public StatusDTO() {

    }

    public StatusDTO(long id, String statusName, List<Task> tasks) {
        this.id = id;
        this.statusName = statusName;
        this.tasks = tasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return id == statusDTO.id && Objects.equals(statusName, statusDTO.statusName) && Objects.equals(tasks, statusDTO.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusName, tasks);
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
