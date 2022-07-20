package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.SongComment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@RestController
@RequestMapping("/api/albums/{name}/")
public class SongController {
    private AlbumRepository albumRepo;
    private SongCommentRepository commentRepo;
    private SongRepository songRepo;

    public SongController(AlbumRepository albumRepo, SongCommentRepository commentRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.commentRepo = commentRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("/{title}")
    public Song getSongByName(@PathVariable String name){
        return songRepo.findByNameIgnoreCase(name).get();
    }

    @PatchMapping("/{title}")
    public Song editSongTitle(@RequestBody String newTitle, @PathVariable Long id) {
        Song songToChange = songRepo.findById(id).get();
        songToChange.changeTitle(newTitle);
        songRepo.save(songToChange);
        return songToChange;
    }
    @PatchMapping("/{title}")
    public Song editSongLink(@RequestBody String newUrl, @PathVariable String name) {
        Song songToChange = songRepo.findByNameIgnoreCase(name).get();
        songToChange.changeUrl(newUrl);
        songRepo.save(songToChange);
        return songToChange;
    }

    @PostMapping("/{title}/{id}")
    public Song addCommentToSong(@RequestBody SongComment songCommentToAdd, @PathVariable String name, @PathVariable Long id) {
        Song songToAddCommentTo = songRepo.findByNameIgnoreCase(name).get();
        songToAddCommentTo.addCommentToSong(songCommentToAdd);
        songRepo.save(songToAddCommentTo);
        return songToAddCommentTo;
    }

}
