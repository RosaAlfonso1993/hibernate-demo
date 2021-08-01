package io.redbee.academy.persistence.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

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

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = Collections.emptySet();

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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
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
