package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String linkUrl;
    private String duration;
    private double avgRating;
    @OneToMany
    private Collection<Comment> comments;

    public Song(String title, String linkUrl, String duration, double avgRating, Collection<Comment> comments) {
        this.title = title;
        this.linkUrl = linkUrl;
        this.duration = duration;
        this.avgRating = avgRating;
        this.comments = comments;
    }

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public String getDuration() {
        return duration;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public Collection<Comment> getComments() {
        return comments;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Double.compare(song.getAvgRating(), getAvgRating()) == 0 && Objects.equals(getId(), song.getId()) && Objects.equals(getTitle(), song.getTitle()) && Objects.equals(getLinkUrl(), song.getLinkUrl()) && Objects.equals(getDuration(), song.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLinkUrl(), getDuration(), getAvgRating());
    }

    public void changeUrl(String newUrl) {
        linkUrl = newUrl;
    }
}