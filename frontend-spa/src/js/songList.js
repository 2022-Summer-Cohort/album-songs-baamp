export default function songList(album) {
    return `
    <body id="exposedbrickbackground">
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
                                <input type="hidden" class="album-id-field" value="${album.id}">
                                <button class="change-album-name-button">&#x270E</button>
                            </div>
                            <div>
                                <br>
                                <br>
                                ${album.songs.map(song => {
                                    return `
                                    <div>
                                        <section class="box-items"><a href="#"><img class="play-arrow" src="/src/images/play-arrow.webp" alt="">${song.title} <p class="song-duration"> ${song.duration}</p></a> 
                                            
                                            <div class="songDiv">    
                                                <input type="hidden" class="song-id-field" value="${song.id}">
                                                <button class="edit-song-button">&#x270E</button>
                                                <button class="delete-song-button">&#128465</button>
                                            </div>
                                        </section>
                                    </div>
                                    <br>`
                                }).join("")
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
                    <div class="popup" id="edit-song-title-popup">
                        <button id="dismissButton" type="button">&#10006</button>
                        <h2>Edit Song Title</h2>
                        <input id="new-song-title" type="text" placeholder="New Song Title">
                        <br>
                        <br>
                        <input id="submitSongTitleButton" type="submit">
                        <input class="selected-song" type="hidden" value="-1" >
                    </div>
                    <div class="popup" id="edit-album-popup">
                        <button id="dismissAlbumButton" type="button">&#10006</button>
                        <h2>Edit Album Title</h2>
                        <input id="new-album-title" type="text" placeholder="New Album Title">
                        <br>
                        <br>
                        <input id="submit-album-title-button" type="submit">
                        <input class="selected-album-title" type="hidden" value="${album.id}" >
                    </div>
                </div>
            </div>
        </div>
    </body>`
}