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

    public Populator(AlbumRepository albumRepo, AlbumCommentRepository albumCommentRepo,
                     SongRepository songRepo, SongCommentRepository songCommentRepo) {
        this.albumRepo = albumRepo;
        this.albumCommentRepo = albumCommentRepo;
        this.songRepo = songRepo;
        this.songCommentRepo = songCommentRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        AlbumComment test = new AlbumComment("t", 4.5, "t");
        AlbumComment test2 = new AlbumComment("t", 3.0, "t");
        AlbumComment test3 = new AlbumComment("t", 1.5, "t");


        Album dejaEntendu = new Album("Deja Entendu", "Brand New",
                "https://upload.wikimedia.org/wikipedia/en/e/e0/BrandNew_SicTransitGloria.jpg", test, test2, test3);
        dejaEntendu.addRecordLabel("Sore Point");
        albumRepo.save(dejaEntendu);

        test.setAlbum(dejaEntendu);
        test2.setAlbum(dejaEntendu);
        test3.setAlbum(dejaEntendu);

        albumCommentRepo.save(test);
        albumCommentRepo.save(test2);
        albumCommentRepo.save(test3);


        Album americanHeartbreak = new Album("American Heartbreak", "Zach Bryan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/0/08/Zach_Bryan_-_American_Heartbreak.png/220px-Zach_Bryan_-_American_Heartbreak.png");
        albumRepo.save(americanHeartbreak);
        Album allTheRightReasons = new Album("All the Right Reasons", "Nickelback",
                "https://dancingbear.hr/wp-content/uploads/2018/07/nickl-78.jpeg.jpg");
        allTheRightReasons.addRecordLabel("Roadrunner");
        albumRepo.save(allTheRightReasons);
        Song song1 = new Song("Tautou", "#", "1:42");
        song1.setAlbum(dejaEntendu);
        Song song4 = new Song("Okay I Believe You, but My Tommy Gun Don't", "#", "5:35");
        song4.setAlbum(dejaEntendu);
        Song song7 = new Song("Jaws Theme Swimming", "#", "4:34");
        song7.setAlbum(dejaEntendu);
        Song song2 = new Song("Sic Transit Gloria...Glory Fades", "#", "3:06");
        song2.setAlbum(dejaEntendu);
        Song song5 = new Song("The Quiet Things That No One Ever Knows", "#", "4:02");
        song5.setAlbum(dejaEntendu);
        Song song8 = new Song("Me vs. Maradona vs. Elvis", "#", "5:19");
        song8.setAlbum(dejaEntendu);
        Song song3 = new Song("I Will Play My Game Beneath The Spin Light", "#", "3:57");
        song3.setAlbum(dejaEntendu);
        Song song6 = new Song("The Boy Who Blocked His Own Shot", "#", "4:39");
        song6.setAlbum(dejaEntendu);
        Song song9 = new Song("Guernica", "#", "3:24");
        song9.setAlbum(dejaEntendu);
        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
        songRepo.save(song4);
        songRepo.save(song5);
        songRepo.save(song6);
        songRepo.save(song7);
        songRepo.save(song8);
        songRepo.save(song9);
//        Song aH1 = new Song("Late July", "#", "2:59", americanHeartbreak);
//        Song aH2 = new Song("Heavy Eyes", "#", "3:11", americanHeartbreak);
//        Song aH3 = new Song("Mine Again", "#", "3:45", americanHeartbreak);
//        Song aH4 = new Song("Happy Instead", "#", "4:10", americanHeartbreak);
//        Song aH5 = new Song("Younger Years", "#", "3:26", americanHeartbreak);
//        Song aH6 = new Song("Tishomingo", "#", "3:09", americanHeartbreak);
//        songRepo.save(aH1);
//        songRepo.save(aH2);
//        songRepo.save(aH3);
//        songRepo.save(aH4);
//        songRepo.save(aH5);
//        songRepo.save(aH6);
//        Song nbSong1 = new Song("Follow You Home", "#", "4:20", allTheRightReasons);
//        Song nbSong2 = new Song("Fight for All the Wrong Reasons", "#", "3:44", allTheRightReasons);
//        Song nbSong3 = new Song("Photograph", "#", "4:19", allTheRightReasons);
//        Song nbSong4 = new Song("Animals", "#", "3:07", allTheRightReasons);
//        Song nbSong5 = new Song("Savin' Me", "#", "3:38", allTheRightReasons);
//        Song nbSong6 = new Song("Far Away", "#", "3:58", allTheRightReasons);
//        Song nbSong7 = new Song("Next Contestant", "#", "3:35", allTheRightReasons);
//        Song nbSong8 = new Song("Side of a Bullet", "#", "3:01", allTheRightReasons);
//        Song nbSong9 = new Song("If Everyone Cared", "#", "3:38", allTheRightReasons);
//        Song nbSong10 = new Song("Someone that You're With", "#", "4:02", allTheRightReasons);
//        Song nbSong11 = new Song("Rockstar", "#", "4:15", allTheRightReasons);
//        songRepo.save(nbSong1);
//        songRepo.save(nbSong2);
//        songRepo.save(nbSong3);
//        songRepo.save(nbSong4);
//        songRepo.save(nbSong5);
//        songRepo.save(nbSong6);
//        songRepo.save(nbSong7);
//        songRepo.save(nbSong8);
//        songRepo.save(nbSong9);
//        songRepo.save(nbSong10);
//        songRepo.save(nbSong11);
        SongComment sC1 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!");
        sC1.setSong(song1);


        SongComment sC2 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!");
        sC2.setSong(song2);
        SongComment sC3 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song3);
        SongComment sC4 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song4);
        SongComment sC5 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song5);
        SongComment sC6 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song6);
        SongComment sC7 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song7);
        SongComment sC8 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song8);
        SongComment sC9 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", song9);
        SongComment sC10 = new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH1);
        SongComment sC11= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH2);
        SongComment sC12= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH3);
        SongComment sC13= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH4);
        SongComment sC14= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH5);
        SongComment sC15= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", aH6);
        SongComment sC16= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong1);
        SongComment sC17= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong2);
        SongComment sC18= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong3);
        SongComment sC19= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong4);
        SongComment sC20= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong5);
        SongComment sC21= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong6);
        SongComment sC22= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong7);
        SongComment sC23= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong8);
        SongComment sC24= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong9);
        SongComment sC25= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong10);
        SongComment sC26= new SongComment("Bubba", 3.5, "This song was life changing!" +
                "We played it at my son's barmitzvah!", nbSong11);
        songCommentRepo.save(sC1);
//        songCommentRepo.save(sC2);
//        songCommentRepo.save(sC3);
//        songCommentRepo.save(sC4);
//        songCommentRepo.save(sC5);
//        songCommentRepo.save(sC6);
//        songCommentRepo.save(sC7);
//        songCommentRepo.save(sC8);
//        songCommentRepo.save(sC9);
//        songCommentRepo.save(sC10);
//        songCommentRepo.save(sC11);
//        songCommentRepo.save(sC12);
//        songCommentRepo.save(sC13);
//        songCommentRepo.save(sC14);
//        songCommentRepo.save(sC15);
//        songCommentRepo.save(sC16);
//        songCommentRepo.save(sC17);
//        songCommentRepo.save(sC18);
//        songCommentRepo.save(sC19);
//        songCommentRepo.save(sC20);
//        songCommentRepo.save(sC21);
//        songCommentRepo.save(sC22);
//        songCommentRepo.save(sC23);
//        songCommentRepo.save(sC24);
//        songCommentRepo.save(sC25);
//        songCommentRepo.save(sC26);
//        AlbumComment nbComment = new AlbumComment("Rolling Stone", 1.5, "Nickelback's fifth disc consists of eleven giant-chorused songs about prisons of the mind, wanting to be a rock star and how it's hard to up and leave when she's going down on you. The band's wordy hooks and big riffs are as meticulously arranged as a thousand-dollar Nativity scene, but – with the exception of the sleekly rocking Animals and some hope-and-faith platitudes – All the Right Reasons is so depressing, you're almost glad Kurt's not around to hear it.", allTheRightReasons);
//        AlbumComment dEComment = new AlbumComment("Ali Shutler", 4.5, "In 2003 Brand New were just another pop-punk band from Long Island. Then came 'Deja Entendu'. Smart, sexy and bleak, it didn't just push the band into becoming the spotlight-shunning superstars that we both hate and adore today; it redefined a genre.", dejaEntendu);
//        AlbumComment aHComment = new AlbumComment("Holler Country", 4, "American Heartbreak sculpts the entire breadth of human experience, as Bryan stitches together songs of love, loss and life's fleeting nature with brilliant command.", americanHeartbreak);
//        albumCommentRepo.save(nbComment);
//        albumCommentRepo.save(dEComment);
//        albumCommentRepo.save(aHComment);
    }
}
