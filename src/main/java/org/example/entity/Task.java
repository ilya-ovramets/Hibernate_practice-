package org.example.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    private  String title;

    @Column(name = "body")
    private  String body;

    @ManyToMany(mappedBy = "tasks")
    private List<User> performers;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name = "create_by")
    private long createBy;

    @ManyToOne
    @JoinColumn(name="status_id", nullable = false)
    private Status status;



    @ManyToMany
    @JoinTable(
            name = "tasks_tags",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    public Task(){

    }

    public Task(long id, String title, String body, List<User> performens, LocalDate startDate, LocalDate finishDate, long createBy, List<Tag> tags,Status status) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.performers = performens;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.createBy = createBy;
        this.tags = tags;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public List<User> getPerformers() {
        return performers;
    }


    public void setPerformers(List<User> performers) {
        this.performers = performers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", performers=" + performers +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", createBy=" + createBy +
                ", status=" + status +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && createBy == task.createBy && Objects.equals(title, task.title) && Objects.equals(body, task.body) && Objects.equals(performers, task.performers) && Objects.equals(startDate, task.startDate) && Objects.equals(finishDate, task.finishDate) && Objects.equals(status, task.status) && Objects.equals(tags, task.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, performers, startDate, finishDate, createBy, status, tags);
    }
}
