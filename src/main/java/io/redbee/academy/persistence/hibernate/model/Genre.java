package io.redbee.academy.persistence.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "creation_user")
    private String creationUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", creationUser='" + creationUser + '\'' +
                '}';
    }

}
