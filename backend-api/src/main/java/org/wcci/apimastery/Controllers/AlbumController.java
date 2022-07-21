package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@RestController
@RequestMapping("/api/albums/")
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private SongCommentRepository commentRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, SongCommentRepository commentRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.commentRepo = commentRepo;
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

}
