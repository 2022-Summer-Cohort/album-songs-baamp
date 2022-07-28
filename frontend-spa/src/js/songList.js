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

                            <div>
                                <br>
                                <br>
                                ${album.albumComments.map(comment => {
                                    return `
                                    <div class="album-comments">
                                        <section class="comment-box-items">
                                            <h1>${comment.username}</h1>
                                            <h3>${comment.rating}</h3>
                                            <p>${comment.body}</p>
                                        </section>
                                    </div>
                                    `
                                }).join("")}
                            </div>

                            <br>
                            <br>

                            <h1 id="title">Add a comment!</h1>

                            <input id="comment-username" type="text" placeholder="Username...">
                            <input id="comment-rating" type="number" min="0" step="0.1" max="5" placeholder="Rating...">
                            <input id="comment-body" type="text" placeholder="Body...">
                       
                            <input id="submit-comment-button" type="submit">
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