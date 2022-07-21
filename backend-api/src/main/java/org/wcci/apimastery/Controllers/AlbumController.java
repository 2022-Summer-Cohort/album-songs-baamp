package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.AlbumComment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Model.SongComment;
import org.wcci.apimastery.repos.AlbumCommentRepository;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@RestController
@RequestMapping("/api/albums/")
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private AlbumCommentRepository albumCommentRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, AlbumCommentRepository albumCommentRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.albumCommentRepo = albumCommentRepo;
    }

    @GetMapping("")
    public Iterable<Album> getAllAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/{id}")
    public Album getAlbumByName(@PathVariable Long id) {
        return albumRepo.findById(id).get();
    }

    // Put to replace songs, etc.
    // Patch to edit part of song, etc.
    // Post to add a new song, etc.
    // Get to show song, etc.
    // Delete to delete songs, etc.

    @PatchMapping("/{id}/newRecordLabel")
    public Album albumToChangeRecordLabel(@RequestBody String newRecordLabel, @PathVariable Long id) {
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeRecordLabel(newRecordLabel);
        albumRepo.save(albumToChange);
        return albumToChange;
    }

    @PostMapping("")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd) {
        if (!albumRepo.findByNameIgnoreCase(albumToAdd.getTitle()).isPresent()) {
            albumRepo.save(albumToAdd);
        }
        return albumRepo.findAll();
    }

    @PostMapping("")
    public Iterable<Song> addSongToAlbum(@RequestBody Song songToAdd) {
        if(!songRepo.findByNameIgnoreCase(songToAdd.getTitle()).isPresent()) {
            songRepo.save(songToAdd);
        }
        return songRepo.findAll();
    }

    @PatchMapping("/{id}/newAlbumTitle")
    public Album albumToChangeTitle(@RequestBody String newTitle, @PathVariable Long id) {
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeTitle(newTitle);
        albumRepo.save(albumToChange);
        return albumToChange;
    }

    @PatchMapping("/{id}/newAlbumImg")
    public Album albumToChangeImg(@RequestBody String newImgUrl, @PathVariable Long id) {
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeUrl(newImgUrl);
        albumRepo.save(albumToChange);
        return albumToChange;
    }

    @PostMapping("/{id}/newComment")
    public Album addCommentToAlbum(@RequestBody AlbumComment newComment, @PathVariable Long id) {
        Album albumToEdit = albumRepo.findById(id).get();
        AlbumComment newAlbumComment = new AlbumComment(newComment.getUsername(), newComment.getRating(), newComment.getBody(), albumToEdit);
        albumCommentRepo.save(newAlbumComment);

        return albumRepo.findById(id).get();
    }

    @PatchMapping("/{id}/editAlbumCommentRating")
    public Iterable<AlbumComment> changeRatingOnAlbumComment(@RequestBody double newRating, @PathVariable Long id) {
        AlbumComment albumCommentToEdit = albumCommentRepo.findById(id).get();
        albumCommentToEdit.changeRating(newRating);
        albumCommentRepo.save(albumCommentToEdit);

        return albumCommentRepo.findAll();
    }

    @PatchMapping("/{id}/editAlbumCommentBody")
    public Iterable<AlbumComment> changeBodyOnAlbumComment(@RequestBody String newBody, @PathVariable Long id) {
        AlbumComment albumCommentToEdit = albumCommentRepo.findById(id).get();
        albumCommentToEdit.changeBody(newBody);
        albumCommentRepo.save(albumCommentToEdit);

        return albumCommentRepo.findAll();
    }

}
