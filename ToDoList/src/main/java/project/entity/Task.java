package project.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    private  String title;

    @Column(name = "body")
    private  String body;

    @ManyToMany(mappedBy = "tasks")
    private List<User> performens;

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
        this.performens = performens;
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

    public List<User> getPerformens() {
        return performens;
    }

    public void setPerformens(List<User> performens) {
        this.performens = performens;
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
}
