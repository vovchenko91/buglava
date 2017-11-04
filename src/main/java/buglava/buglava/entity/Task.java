package buglava.buglava.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;
    @NotNull
    private String name;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;
    private String description;

    public Task() {

    }

    public Task(String name, Type type, Status status, Priority priority, String description) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
