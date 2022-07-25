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
                <a id="backbutton" href="#"><img id="backbuttonimg" src="/src/images/backbutton.png" alt=""></a>
                <section class="projects">
                    <div class="slider">
            <span class="album" style="--i:2;"><img class="album-cover" src="/src/images/ALLTHERIGHTREASONS.jpg"
                    onClick="document.getElementById('ALLTHERIGHTREASONS').scrollIntoView({behavior: 'smooth', block: 'start', inline: 'nearest'});">
                </a>
                <p class="artist-name-home">Nickleback</p>
                                <p class="album-name-home">All the Right Reasons</p>
            </span>
           
                    </div>
                </section>
            </div>
        </div>

    </div>
    <script src="/src/js/app.js"></script>
    <script src="/src/js/animation.js"></script>
</body>`
}