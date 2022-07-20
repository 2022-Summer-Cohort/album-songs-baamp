package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.RecordLabelRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private SongCommentRepository commentRepo;
    private RecordLabelRepository recordLabelRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, SongCommentRepository commentRepo, RecordLabelRepository recordLabelRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.commentRepo = commentRepo;
        this.recordLabelRepo = recordLabelRepo;
    }

    @GetMapping("")
    public Iterable<Album> getAllAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/{name}")
    public Album getAlbumByName(@PathVariable String name) {
        return albumRepo.findByNameIgnoreCase(name).get();
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



    @PatchMapping("/{name}/")
    public Album albumToChangeTitle(@RequestBody String newTitle, @PathVariable String name) {
        Album albumToChange = albumRepo.findByNameIgnoreCase(name).get();
        albumToChange.changeTitle(newTitle);
        albumRepo.save(albumToChange);
        return albumToChange;
    }


}
