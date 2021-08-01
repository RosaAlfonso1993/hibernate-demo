package io.redbee.academy.persistence.hibernate.model;

import java.io.Serializable;

public class Genre implements Serializable {

    private Integer id;
    private String description;
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
