package org.wcci.apimastery.Model;

import javax.persistence.*;
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
    @ManyToOne
    private Album album;
    @OneToMany(mappedBy = "comments")
    private Collection<SongComment> songComments;

    public Song(String title, String linkUrl, String duration, double avgRating, Album album, Collection<SongComment> songComments) {
        this.title = title;
        this.linkUrl = linkUrl;
        this.duration = duration;
        this.avgRating = avgRating;
        this.album = album;
        this.songComments = songComments;
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