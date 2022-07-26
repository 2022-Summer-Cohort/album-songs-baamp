export default function home() {
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
                    <span id="addAlbumButton" class="album" style="--i:1;"><img class="album-cover" src="/src/images/add-album-button.png"
                            onClick="document.getElementById('COF').scrollIntoView();">
                        </a>
                    </span>
            <span class="album" style="--i:${};"><img class="album-cover" src="/src/images/ALLTHERIGHTREASONS.jpg"
                    onClick="document.getElementById('ALLTHERIGHTREASONS').scrollIntoView({behavior: 'smooth', block: 'start', inline: 'nearest'});">
                </a>
                <p class="artist-name-home">Nickleback</p>
                                <p class="album-name-home">All the Right Reasons</p>
            </span>
           
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
                    
                    
                    <button type="button" onclick="hideSocials()">Dismiss</button>
                </div>
</div>
        </div>

    </div>
    <script src="/src/js/app.js"></script>
    <script src="/src/js/animation.js"></script>
</body>`
}