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

    @ManyToOne @JsonIgnore
    private Song song;

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

    public void changeRating(double newRating) {
        rating = newRating;
    }

    public void changeBody(String newBody) {
        body = newBody;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SongComment)) return false;
        SongComment that = (SongComment) o;
        return Double.compare(that.getRating(), getRating()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getBody(), that.getBody()) && Objects.equals(getSong(), that.getSong());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRating(), getBody(), getSong());
    }
}