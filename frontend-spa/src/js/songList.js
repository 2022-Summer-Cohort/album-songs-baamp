export default function songList(album) {
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
                            <h3 id="artist-name">Artist: ${album.artistName}</h3>
                            <h4 id="album-name">Album: ${album.title}</h4>
                            <h4 id="record-label">Record Label: ${album.recordLabel}</h4>
                        </div>
                        <div>
                        <button class="change-album-name-button">&#x270E</button>
                        <input type="text" name="popup" id="popup" class="hide">
                       
                        <br>
                        <br>
                        
                        ${album.songs.map(song => {
                            return `<div>
                            <section class="box-items"><a href="#"><img class="play-arrow" src="/src/images/play-arrow.webp" alt="">${song.title}</a>
                            <input type="hidden" class="song-id-field" value="${song.id}">
                            <div>    
                            <button class="edit-song-button">&#x270E</button>
                                <button class="delete-song-button">&#128465</button>
                                </div>
                            </section>
                        </div>`
                        })
                        .join("")
                    }
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
   

</body>`
}