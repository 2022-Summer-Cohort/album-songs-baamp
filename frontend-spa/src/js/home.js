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
                        <span style="--i:1;"><img src="/src/images/Amon_Amarth_-_Twlight_of_the_Thunder_God.jpeg"
                                onClick="document.getElementById('album-site').scrollIntoView();">
                            </a>
                        </span>
                        <span style="--i:2;"><img src="/src/images/ALLTHERIGHTREASONS.jpg"
                                onClick="document.getElementById('cookie-clicker').scrollIntoView({behavior: 'smooth', block: 'start', inline: 'nearest'});">
                            </a>
                        </span>
                        <span style="--i:3;"><img src="/src/images/DEJAENTENDU.jpg"
                                onClick="document.getElementById('review-site').scrollIntoView();">
                            </a>
                        </span>
                        <span style="--i:4;"><img src="/src/images/AMERICANHEARTBREAK.jpg"
                                onClick="document.getElementById('virtual-pet').scrollIntoView();">
                            </a>
                        </span>
                        <span style="--i:5;"><img src="/src/images/WageWar_Blueprints.jpeg"
                                onClick="document.getElementById('wordle-solver').scrollIntoView();">
                            </a>
                        </span>
                        <span style="--i:6;"><img src="/src/images/Oh,Sleeper_COF.jpeg"
                                onClick="document.getElementById('wordle-solver').scrollIntoView();">
                            </a>
                        </span>
                        <!-- <span style="--i:7;"><img src="/src/images/WageWar_Blueprints.jpeg"
                            onClick="document.getElementById('wordle-solver').scrollIntoView();">
                        </a>
                        </span> -->
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