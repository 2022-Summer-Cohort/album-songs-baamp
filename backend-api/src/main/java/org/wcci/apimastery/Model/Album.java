package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue()
    private Long id;
    private String title;
    private String artistName;
    private String imgUrl;
    private double avgRating;
    private String recordLabel;

    @OneToMany
    private Collection<Song> songs;
    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private Collection<AlbumComment> albumComments;

    public Album(String title, String artistName, String imgUrl, Song... songs) {
        this.title = title;
        this.artistName = artistName;
        this.imgUrl = imgUrl;
        this.songs = Set.of(songs);
    }


    public Album() {
    }

    public void addRecordLabel(String newRecordLabel) { recordLabel = newRecordLabel; }
    public String getArtistName() {
        return artistName;
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

    public String getRecordLabel() {
        return recordLabel;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Collection<AlbumComment> getAlbumComments() {
        return albumComments;
    }

    public void updateAverageRating() {
        double sumRating = 0;

        for (AlbumComment albumComment : albumComments) {
            sumRating += albumComment.getRating();
        }

        avgRating = sumRating / albumComments.size();
        avgRating = Math.round(avgRating *10.0) / 10.0;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public void changeRecordLabel(String newRecordLabel) {
        recordLabel = newRecordLabel;
    }

    public void changeUrl(String newImgUrl) {
        imgUrl = newImgUrl;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return Double.compare(album.getAvgRating(), getAvgRating()) == 0 && Objects.equals(getId(), album.getId()) && Objects.equals(getTitle(), album.getTitle()) && Objects.equals(getArtistName(), album.getArtistName()) && Objects.equals(getImgUrl(), album.getImgUrl()) && Objects.equals(getRecordLabel(), album.getRecordLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getArtistName(), getImgUrl(), getAvgRating(), getRecordLabel());
    }
}