export default function singleSong(song){
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
                        <section class="box-items">Playing:</section>
                        <section class="box-items">${song.title}</section>
                        <br>
                    <br>
                    <input id="comment-box" class="rating-comment-submit" type="text" placeholder="write a comment here...">
                    <br>
                    <br>
                    <input id="rating-box" class="rating-comment-submit" type="number" min="0" max="5" placeholder="Choose Rating">
                    <br>
                    <br>
                    <input id="submit-button" type="submit">
                    </div>
                    
                </section>
                
                
                
            </div>
        </div>

    </div>
    <script src="/src/js/app.js" type="module"></script>
    <script src="/src/js/animation.js"></script>
    
</body>`
}