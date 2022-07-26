package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
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

    @ManyToOne @JsonIgnore
    private Album album;
    @OneToMany(mappedBy = "song",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<SongComment> songComments;

    public Song(String title, String linkUrl, String duration, SongComment... comments) {
        this.title = title;
        this.linkUrl = linkUrl;
        this.duration = duration;
        this.songComments = Arrays.asList(comments);

        this.avgRating = updateAverageRating();
    }

    private double updateAverageRating() {
        double sumRating = 0;

        for (SongComment songComment : songComments) {
            sumRating += songComment.getRating();
        }

        avgRating = sumRating / songComments.size();
        avgRating = Math.round(avgRating *10.0) / 10.0;

        return avgRating;
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

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void addComments(Collection<SongComment> newComments) {
        songComments = newComments;
    }

    public Album getAlbum() {
        return album;
    }

    public Collection<SongComment> getComments() {
        return songComments;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public void addCommentToSong(SongComment newSongComment) {
        songComments.add(newSongComment);
    }

    public void changeUrl(String newUrl) {
        linkUrl = newUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Double.compare(song.getAvgRating(), getAvgRating()) == 0 && Objects.equals(getId(), song.getId()) && Objects.equals(getTitle(), song.getTitle()) && Objects.equals(getLinkUrl(), song.getLinkUrl()) && Objects.equals(getDuration(), song.getDuration()) && Objects.equals(getAlbum(), song.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLinkUrl(), getDuration(), getAvgRating(), getAlbum());
    }
}