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
@RequestMapping("/api/albums")
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
    public Album getAlbumById(@PathVariable Long id) {
        return albumRepo.findById(id).get();
    }

    @GetMapping("/{id}/songs")
    public Iterable<Song> getSongsByAlbumId(@PathVariable Long id) {
        return albumRepo.findById(id).get().getSongs();
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

    @PostMapping("/addAlbum")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd) {
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }

    @PostMapping("/{id}/addSongToAlbum")
    public Album addSongToAlbum(@PathVariable Long id, @RequestBody Song songToAdd) {
        Album album = albumRepo.findById(id).get();
        songToAdd.setAlbum(album);
        songRepo.save(songToAdd);

        return album;
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
        AlbumComment newAlbumComment = new AlbumComment(newComment.getUsername(), newComment.getRating(), newComment.getBody());
        newAlbumComment.setAlbum(albumToEdit);
        albumToEdit.updateAverageRating();

        albumCommentRepo.save(newAlbumComment);
        albumToEdit.addComment(newAlbumComment);

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

    @DeleteMapping("/{id}")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id){
        albumRepo.deleteById(id);
        return albumRepo.findAll();
    }

}
