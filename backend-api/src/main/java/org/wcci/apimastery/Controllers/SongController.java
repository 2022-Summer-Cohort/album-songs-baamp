package org.wcci.apimastery.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.CommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@RestController
@RequestMapping("/api/albums/{name}/")
public class SongController {
    private AlbumRepository albumRepo;
    private CommentRepository commentRepo;
    private SongRepository songRepo;

    public SongController(AlbumRepository albumRepo, CommentRepository commentRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.commentRepo = commentRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("")
    public Iterable<Song> getAllSongs(){
    }

}
