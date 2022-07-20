package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SongComment {
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

    public SongComment(String username, double rating, String body) {
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public SongComment() {
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
        if (!(o instanceof SongComment)) return false;
        SongComment songComment = (SongComment) o;
        return Double.compare(songComment.getRating(), getRating()) == 0 && Objects.equals(getId(), songComment.getId()) && Objects.equals(getUsername(), songComment.getUsername()) && Objects.equals(getBody(), songComment.getBody()) && Objects.equals(getSong(), songComment.getSong()) && Objects.equals(getAlbum(), songComment.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRating(), getBody(), getSong(), getAlbum());
    }
}