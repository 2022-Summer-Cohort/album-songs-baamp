export default function songList() {
    return `<body id="exposedbrickbackground">
    <div class="container">
        <input type="file" id="thefile" accept="audio/*" />
        <div id="content">

            <audio id="audio" controls></audio>
            <div id="view-screen">
                <img class="logo" id="on-screen-logo" src="/src/images/SODASHOPLOGO.png" alt="">
                <canvas id="canvas"></canvas>
                <img id="touchtunes" src="/src/images/BLANK-TOUCHTUNES.png" alt="">
                <canvas id="canvas"></canvas>
                <a id="backbutton" href="#"><img id="backbuttonimg" src="/src/images/backbutton.png" alt=""></a>
                <section class="projects">
                    <div class="scrolling-box">
                        <div id="album-info">
                            <h3 id="artist-name">Artist: Brand New</h3>
                            <h4 id="album-name">Album: Deja Entendu</h4>
                            <h4 id="record-label">Record Label: TripleCrown</h4>
                        </div>
                        <div>
                        <button class="change-album-name-button">Change Name</button>
                        <br>
                        <button class="delete-album-button">Delete Album</button>
                        <br>
                        <button class="add-song-to-album-button">Add Song to Album</button>
                    </div>
                    <br>
                    <br>
                    <div>
                        <section class="box-items">1: Play Crack the Sky</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">2: Glory Fades</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">3: The Quiet Things that No One Ever Knows</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">4: Me vs. Maradona vs. Elvis</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">5: I Will Play the Game Beneath the Spin Light</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">6: Jaws Theme Song</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">7: Okay I believe you, but my tommy gun don't</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <div>
                        <section class="box-items">8: Guernica</section>
                        <button class="change-song-name-button">Change Song Name</button>
                        <button class="delete-song-button">Delete Song</button>
                    </div>
                    <br>
                    <br>
                    <input id="comment-box" class="rating-comment-submit" type="text"
                        placeholder="write a comment here...">
                    <br>
                    <br>
                    <input id="rating-box" class="rating-comment-submit" type="number" min="0" max="5"
                        placeholder="Choose Rating">
                    <br>
                    <br>
                    <input id="submit-button" type="submit">

                    <!-- <div id="rating">
                            <input id="rating-stars" class="rating" min="0" max="5"
                                oninput="this.style.setProperty('--value', this.value)" step="0.5" type="range"
                                value="1" name="rating">
                            <p class="stars">
                                <span class="star-checked">&#9733;</span>
                                <span class="star-checked">&#9733;</span>
                                <span class="star-checked">&#9733;</span>
                                <span class="star">&#9733;</span>
                                <span class="star">&#9733;</span>
                            </p>
                            </input>
                        </div> -->
            </div>
            </section>
        </div>
    </div>

    </div>
    <script src="/src/js/app.js"></script>
    <script src="/src/js/animation.js"></script>

</body>`
}