package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.AlbumComment;
import org.wcci.apimastery.Model.SongComment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private AlbumRepository albumRepo;
    private SongCommentRepository songCommentRepo;
    private SongRepository songRepo;

    public SongController(AlbumRepository albumRepo, SongCommentRepository songCommentRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songCommentRepo = songCommentRepo;
        this.songRepo = songRepo;
    }
    @GetMapping("")
    public Iterable<Song> getAllSongs() {
        return songRepo.findAll();
    }
    @GetMapping("/{id}")
    public Song getSongByName(@PathVariable Long id){
        return songRepo.findById(id).get();
    }

//    @PostMapping("/addSong")
//    public Iterable<Song> addSongToAlbum(@PathVariable Long id, @RequestBody Song songToAdd) {
//        songRepo.save(songToAdd);
//        return albumRepo.findById(id).get().getSongs();
//    }

    @PatchMapping("/{id}/editTitle")
    public Song editSongTitle(@RequestBody String newTitle, @PathVariable Long id) {
        Song songToChange = songRepo.findById(id).get();
        songToChange.changeTitle(newTitle);
        songRepo.save(songToChange);
        return songToChange;
    }

    @PatchMapping("/{id}/editLink")
    public Song editSongLink(@RequestBody String newUrl, @PathVariable Long id) {
        Song songToChange = songRepo.findById(id).get();
        songToChange.changeUrl(newUrl);
        songRepo.save(songToChange);
        return songToChange;
    }

    @PostMapping("/{id}/newComment")
    public Song addCommentToSong(@RequestBody SongComment newComment, @PathVariable Long id) {
        Song songToEdit = songRepo.findById(id).get();
        SongComment newSongComment = new SongComment(newComment.getUsername(), newComment.getRating(), newComment.getBody());
        newSongComment.setSong(songToEdit);
        songCommentRepo.save(newSongComment);
        return songRepo.findById(id).get();
    }

    @PatchMapping("/{id}/editSongCommentRating")
    public Iterable<SongComment> changeRatingOnSongComment(@RequestBody double newRating, @PathVariable Long id) {
        SongComment songCommentToEdit = songCommentRepo.findById(id).get();
        songCommentToEdit.changeRating(newRating);
        songCommentRepo.save(songCommentToEdit);

        return songCommentRepo.findAll();
    }

    @PatchMapping("/{id}/editSongCommentBody")
    public Iterable<SongComment> changeBodyOnSongComment(@RequestBody String newBody, @PathVariable Long id) {
        SongComment songCommentToEdit = songCommentRepo.findById(id).get();
        songCommentToEdit.changeBody(newBody);
        songCommentRepo.save(songCommentToEdit);

        return songCommentRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public Album deleteSongFromAlbum(@PathVariable Long id) {
        Album album = songRepo.findById(id).get().getAlbum();
        songRepo.deleteById(id);
        return album;
    }

}
