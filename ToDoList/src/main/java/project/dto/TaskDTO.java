package project.dto;

import project.entity.Status;
import project.entity.Tag;
import project.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class TaskDTO implements Serializable {

    private long id;

    private  String title;

    private  String body;

    private List<User> performens;

    private LocalDate startDate;

    private LocalDate finishDate;

    private long createBy;

    private Status status;

    private List<Tag> tags;

    public TaskDTO() {
    }

    public TaskDTO(long id, String title, String body, List<User> performens, LocalDate startDate, LocalDate finishDate, long createBy, Status status, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.performens = performens;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.createBy = createBy;
        this.status = status;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<User> getPerformens() {
        return performens;
    }

    public void setPerformens(List<User> performens) {
        this.performens = performens;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
