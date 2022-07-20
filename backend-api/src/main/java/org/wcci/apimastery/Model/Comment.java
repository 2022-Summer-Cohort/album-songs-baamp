package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private double rating;
    @Lob
    private String body;

    @ManyToOne
    @JsonIgnore
    private Song song;

    @ManyToOne
    @JsonIgnore
    private Album album;

    public Comment(String username, double rating, String body) {
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Comment() {
    }

    public double getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBody() {
        return body;
    }

    public Song getSong() {
        return song;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Double.compare(comment.getRating(), getRating()) == 0 && Objects.equals(getId(), comment.getId()) && Objects.equals(getUsername(), comment.getUsername()) && Objects.equals(getBody(), comment.getBody()) && Objects.equals(getSong(), comment.getSong()) && Objects.equals(getAlbum(), comment.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRating(), getBody(), getSong(), getAlbum());
    }
}