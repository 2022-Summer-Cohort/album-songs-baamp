package org.wcci.apimastery.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue()
    private Long id;
    private String title;
    private String imgUrl;
    private double avgRating;

    @ManyToOne
    private RecordLabel recordLabel;
    @OneToMany
    private Collection<Song> songs;
    @OneToMany
    private Collection<Comment> comments;

    public Album(String title, String imgUrl, double avgRating, Collection<Song> songs, Collection<Comment> comments) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.avgRating = avgRating;
        this.songs = songs;
        this.comments = comments;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public RecordLabel getRecordLabel() {
        return recordLabel;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void updateAverageRating() {
        int sumRating = 0;

        for (Comment comment : comments) {
            sumRating += comment.getRating();
        }

        avgRating = sumRating / comments.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return Double.compare(album.getAvgRating(), getAvgRating()) == 0 && Objects.equals(getId(), album.getId()) && Objects.equals(getTitle(), album.getTitle()) && Objects.equals(getImgUrl(), album.getImgUrl()) && Objects.equals(getRecordLabel(), album.getRecordLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getImgUrl(), getAvgRating(), getRecordLabel());
    }
}
