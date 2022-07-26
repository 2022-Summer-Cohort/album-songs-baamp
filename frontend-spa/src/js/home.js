export default function home(albums) {
    let albumCount = 1;
    return `
    <body id="exposedbrickbackground">
    <div class="container">
        <input type="file" id="thefile" accept="audio/*" />
        <div id="content">
            <audio id="audio" controls></audio>
           
            <div id="view-screen">
                <img class="logo" id="on-screen-logo" src="/src/images/SODASHOPLOGO.png" alt="">
                <canvas id="canvas"></canvas>
                <canvas id="canvas"></canvas>
                <img id="touchtunes" src="/src/images/BLANK-TOUCHTUNES.png" alt="">
                <canvas id="canvas"></canvas>
                <a id="backbutton" href="#"><img id="backbuttonimg" src="/src/images/backbutton.png" alt="Neon Back Button"></a>
                
                <section class="projects">
                    <div class="slider">
                    <span id="addAlbumButton" class="album" style="--i:1;"><img class="album-cover" src="/src/images/add-album-button.png">
                        </a>
                        <p class="artist-name-home">Add Album</p>
                    </span>
                    ${albums.map(album => {
                        albumCount++;
                        return `
                        <span class="album" style="--i:${albumCount};"><img class="album-cover" src="${album.imgUrl}">
                </a>
                <p class="artist-name-home">Artist: ${album.artistName}</p>
                                <p class="album-name-home">Album: ${album.title}</p>
            </span>
                        `
    
                    })
                .join("")
                }
            
           
                    </div>
                </section>
                <div class="popup" id="popup">
                    
                    <h2>Add Album</h2>
                    <input id="album-title" class="rating-comment-submit" type="text"
                        placeholder="Title...">
                    <br>
                    <br>
                    <input id="artist-name" class="rating-comment-submit" type="text" 
                        placeholder="Artist Name">
                    <br>
                    <br>
                    <input id="album-image-url" class="rating-comment-submit" type="text" 
                        placeholder="Image Link (URL)">
                    <br>
                    <br>
                    <input id="record-label" class="rating-comment-submit" type="text" 
                        placeholder="Record Label (optional)">
                    <br>
                    <br>
                    <input id="submitAlbumButton" type="submit">
                    
                    
                    <button id="dismissButton" type="button">Dismiss</button>
                </div>
            </div>
        </div>
`
}