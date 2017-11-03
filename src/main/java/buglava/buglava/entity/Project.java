package buglava.buglava.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vovchenko Denis on 11/3/2017.
 */

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Project {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
