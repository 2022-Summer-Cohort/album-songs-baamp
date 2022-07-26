package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.AlbumComment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Model.SongComment;
import org.wcci.apimastery.repos.AlbumCommentRepository;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongCommentRepository;
import org.wcci.apimastery.repos.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    private AlbumRepository albumRepo;
    private AlbumCommentRepository albumCommentRepo;
    private SongRepository songRepo;
    private SongCommentRepository songCommentRepo;

    public Populator(AlbumRepository albumRepo, AlbumCommentRepository albumCommentRepo, SongRepository songRepo, SongCommentRepository songCommentRepo) {
        this.albumRepo = albumRepo;
        this.albumCommentRepo = albumCommentRepo;
        this.songRepo = songRepo;
        this.songCommentRepo = songCommentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        AlbumComment dEComment = new AlbumComment("Ali Shutler", 4.5, "In 2003 Brand New were just another pop-punk band from Long Island. Then came 'Deja Entendu'. Smart, sexy and bleak, it didn't just push the band into becoming the spotlight-shunning superstars that we both hate and adore today; it redefined a genre.");
        AlbumComment dEComment2 = new AlbumComment("Ali Shutler", 5.0, "In 2003 Brand New were just another pop-punk band from Long Island. Then came 'Deja Entendu'. Smart, sexy and bleak, it didn't just push the band into becoming the spotlight-shunning superstars that we both hate and adore today; it redefined a genre.");
        AlbumComment dEComment3 = new AlbumComment("Ali Shutler", 2.3, "In 2003 Brand New were just another pop-punk band from Long Island. Then came 'Deja Entendu'. Smart, sexy and bleak, it didn't just push the band into becoming the spotlight-shunning superstars that we both hate and adore today; it redefined a genre.");
        AlbumComment dEComment4 = new AlbumComment("Ali Shutler", 1.0, "In 2003 Brand New were just another pop-punk band from Long Island. Then came 'Deja Entendu'. Smart, sexy and bleak, it didn't just push the band into becoming the spotlight-shunning superstars that we both hate and adore today; it redefined a genre.");
        Song song1 = new Song("Tautou", "#", "1:42");
        Song song4 = new Song("Okay I Believe You, but My Tommy Gun Don't", "#", "5:35");
        Song song7 = new Song("Jaws Theme Swimming", "#", "4:34");
        Song song2 = new Song("Sic Transit Gloria...Glory Fades", "#", "3:06");
        Song song5 = new Song("The Quiet Things That No One Ever Knows", "#", "4:02");
        Song song8 = new Song("Me vs. Maradona vs. Elvis", "#", "5:19");
        Song song3 = new Song("I Will Play My Game Beneath The Spin Light", "#", "3:57");
        Song song6 = new Song("The Boy Who Blocked His Own Shot", "#", "4:39");
        Song song9 = new Song("Guernica", "#", "3:24");
        SongComment sC1 = new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC2 = new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC3 = new SongComment("Bubba", 1.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC4 = new SongComment("Bubba", 2.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC5 = new SongComment("Bubba", 5.0, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC6 = new SongComment("Bubba", 4.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC7 = new SongComment("Bubba", 2.3, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC8 = new SongComment("Bubba", 4.1, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC9 = new SongComment("Bubba", 1.7, "This song was life changing! We played it at my son's barmitzvah!");

        Album dejaEntendu = new Album("Deja Entendu", "Brand New", "https://upload.wikimedia.org/wikipedia/en/e/e0/BrandNew_SicTransitGloria.jpg", dEComment, dEComment2, dEComment3, dEComment4);
        dejaEntendu.addRecordLabel("Sore Point");

        // Save the album
        albumRepo.save(dejaEntendu);
        // Set the SongComment album
        dEComment.setAlbum(dejaEntendu);
        dEComment2.setAlbum(dejaEntendu);
        dEComment3.setAlbum(dejaEntendu);
        dEComment4.setAlbum(dejaEntendu);
        // Set Songs albums
        song1.setAlbum(dejaEntendu);
        song4.setAlbum(dejaEntendu);
        song7.setAlbum(dejaEntendu);
        song2.setAlbum(dejaEntendu);
        song5.setAlbum(dejaEntendu);
        song8.setAlbum(dejaEntendu);
        song3.setAlbum(dejaEntendu);
        song6.setAlbum(dejaEntendu);
        song9.setAlbum(dejaEntendu);
        // Set SongComments song
        sC1.setSong(song1);
        sC2.setSong(song2);
        sC3.setSong(song3);
        sC4.setSong(song4);
        sC5.setSong(song5);
        sC6.setSong(song6);
        sC7.setSong(song7);
        sC8.setSong(song8);
        sC9.setSong(song9);
        // Save AlbumComments
        albumCommentRepo.save(dEComment);
        albumCommentRepo.save(dEComment2);
        albumCommentRepo.save(dEComment3);
        albumCommentRepo.save(dEComment4);
        // Save Songs
        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
        songRepo.save(song4);
        songRepo.save(song5);
        songRepo.save(song6);
        songRepo.save(song7);
        songRepo.save(song8);
        songRepo.save(song9);
        // Save SongComments
        songCommentRepo.save(sC1);
        songCommentRepo.save(sC2);
        songCommentRepo.save(sC3);
        songCommentRepo.save(sC4);
        songCommentRepo.save(sC5);
        songCommentRepo.save(sC6);
        songCommentRepo.save(sC7);
        songCommentRepo.save(sC8);
        songCommentRepo.save(sC9);
//      --------------------------------------------------------------------------------
        AlbumComment aHComment = new AlbumComment("Holler Country", 4, "American Heartbreak sculpts the entire breadth of human experience, as Bryan stitches together songs of love, loss and life's fleeting nature with brilliant command.");
        Song aH1 = new Song("Late July", "#", "2:59");
        Song aH2 = new Song("Heavy Eyes", "#", "3:11");
        Song aH3 = new Song("Mine Again", "#", "3:45");
        Song aH4 = new Song("Happy Instead", "#", "4:10");
        Song aH5 = new Song("Younger Years", "#", "3:26");
        Song aH6 = new Song("Tishomingo", "#", "3:09");
        SongComment sC10 = new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC11= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC12= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC13 = new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC14= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC15= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");

        Album americanHeartbreak = new Album("American Heartbreak", "Zach Bryan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/0/08/Zach_Bryan_-_American_Heartbreak.png/220px-Zach_Bryan_-_American_Heartbreak.png", aHComment);
        albumRepo.save(americanHeartbreak);

        aHComment.setAlbum(americanHeartbreak);
        aH1.setAlbum(americanHeartbreak);
        aH2.setAlbum(americanHeartbreak);
        aH3.setAlbum(americanHeartbreak);
        aH4.setAlbum(americanHeartbreak);
        aH5.setAlbum(americanHeartbreak);
        aH6.setAlbum(americanHeartbreak);
        sC10.setSong(aH1);
        sC11.setSong(aH2);
        sC12.setSong(aH3);
        sC13.setSong(aH4);
        sC14.setSong(aH5);
        sC15.setSong(aH6);
        albumCommentRepo.save(aHComment);
        songRepo.save(aH1);
        songRepo.save(aH2);
        songRepo.save(aH3);
        songRepo.save(aH4);
        songRepo.save(aH5);
        songRepo.save(aH6);
        songCommentRepo.save(sC10);
        songCommentRepo.save(sC11);
        songCommentRepo.save(sC12);
        songCommentRepo.save(sC13);
        songCommentRepo.save(sC14);
        songCommentRepo.save(sC15);
//        --------------------------------------------------------------------------------
        AlbumComment nbComment = new AlbumComment("Rolling Stone", 1.5, "Nickelback's fifth disc consists of eleven giant-chorused songs about prisons of the mind, wanting to be a rock star and how it's hard to up and leave when she's going down on you. The band's wordy hooks and big riffs are as meticulously arranged as a thousand-dollar Nativity scene, but – with the exception of the sleekly rocking Animals and some hope-and-faith platitudes – All the Right Reasons is so depressing, you're almost glad Kurt's not around to hear it.");
        Song nbSong1 = new Song("Follow You Home", "#", "4:20");
        Song nbSong2 = new Song("Fight for All the Wrong Reasons", "#", "3:44");
        Song nbSong3 = new Song("Photograph", "#", "4:19");
        Song nbSong4 = new Song("Animals", "#", "3:07");
        Song nbSong5 = new Song("Savin' Me", "#", "3:38");
        Song nbSong6 = new Song("Far Away", "#", "3:58");
        Song nbSong7 = new Song("Next Contestant", "#", "3:35");
        Song nbSong8 = new Song("Side of a Bullet", "#", "3:01");
        Song nbSong9 = new Song("If Everyone Cared", "#", "3:38");
        Song nbSong10 = new Song("Someone that You're With", "#", "4:02");
        Song nbSong11 = new Song("Rockstar", "#", "4:15");
        SongComment sC16= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC17= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC18= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC19= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC20= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC21= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC22= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC23= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC24= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC25= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");
        SongComment sC26= new SongComment("Bubba", 3.5, "This song was life changing! We played it at my son's barmitzvah!");

        Album allTheRightReasons = new Album("All the Right Reasons", "Nickelback",
                "https://dancingbear.hr/wp-content/uploads/2018/07/nickl-78.jpeg.jpg", nbComment);
        allTheRightReasons.addRecordLabel("Roadrunner");

        nbComment.setAlbum(allTheRightReasons);
        nbSong1.setAlbum(allTheRightReasons);
        nbSong2.setAlbum(allTheRightReasons);
        nbSong3.setAlbum(allTheRightReasons);
        nbSong4.setAlbum(allTheRightReasons);
        nbSong5.setAlbum(allTheRightReasons);
        nbSong6.setAlbum(allTheRightReasons);
        nbSong7.setAlbum(allTheRightReasons);
        nbSong8.setAlbum(allTheRightReasons);
        nbSong9.setAlbum(allTheRightReasons);
        nbSong10.setAlbum(allTheRightReasons);
        nbSong11.setAlbum(allTheRightReasons);
        sC16.setSong(nbSong1);
        sC17.setSong(nbSong2);
        sC18.setSong(nbSong3);
        sC19.setSong(nbSong4);
        sC20.setSong(nbSong5);
        sC21.setSong(nbSong6);
        sC22.setSong(nbSong7);
        sC23.setSong(nbSong8);
        sC24.setSong(nbSong9);
        sC25.setSong(nbSong10);
        sC26.setSong(nbSong11);
        albumRepo.save(allTheRightReasons);
        songRepo.save(nbSong1);
        songRepo.save(nbSong2);
        songRepo.save(nbSong3);
        songRepo.save(nbSong4);
        songRepo.save(nbSong5);
        songRepo.save(nbSong6);
        songRepo.save(nbSong7);
        songRepo.save(nbSong8);
        songRepo.save(nbSong9);
        songRepo.save(nbSong10);
        songRepo.save(nbSong11);
        songCommentRepo.save(sC16);
        songCommentRepo.save(sC17);
        songCommentRepo.save(sC18);
        songCommentRepo.save(sC19);
        songCommentRepo.save(sC20);
        songCommentRepo.save(sC21);
        songCommentRepo.save(sC22);
        songCommentRepo.save(sC23);
        songCommentRepo.save(sC24);
        songCommentRepo.save(sC25);
        songCommentRepo.save(sC26);
//      --------------------------------------------------------------------------------------
    }
}
