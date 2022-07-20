export default function home() {
    return `
    <body id="exposedbrickbackground">
    <!-- <source src="/src/js/audio/Safari-Song.mp3">
    </source> -->
    <div class="container">
        <div id="content">
            <input type="file" id="thefile" accept="audio/*" />
            <canvas id="canvas"></canvas>
            <audio id="audio" controls></audio>
            <img id="touchtunes" src="/src/js/images/BLANK-TOUCHTUNES.png" alt="">
        </div>
        
    </div>
    <script src="/src/js/app.js"></script>
    <script src="/src/js/animation.js"></script>
</body>`
}