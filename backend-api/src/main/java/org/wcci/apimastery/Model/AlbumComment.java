package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AlbumComment {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private double rating;
    @Lob
    private String body;

    @ManyToOne
    private Album album;

    public AlbumComment(String username, double rating, String body, Album album) {
        this.username = username;
        this.rating = rating;
        this.body = body;
        this.album = album;
    }

    public AlbumComment() {
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

    public Album getAlbum() {
        return album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumComment)) return false;
        AlbumComment that = (AlbumComment) o;
        return Double.compare(that.getRating(), getRating()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getBody(), that.getBody()) && Objects.equals(getAlbum(), that.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRating(), getBody(), getAlbum());
    }
}