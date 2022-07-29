export default function singleSong(song){
    return `
    <div class="container">
        <div id="content">
            <div id="view-screen">
                <img class="logo" id="on-screen-logo" src="/src/images/SODASHOPLOGO.png" alt="">
                <img id="touchtunes" src="/src/images/BLANK-TOUCHTUNES.png" alt="">
                
                <a id="backbutton" href="#">
                    <img id="backbuttonimg" src="/src/images/backbutton.png" alt="">
                </a>
                
                <section class="projects">
                    <div class="scrolling-box">
                        <div id="album-info">
                            <h3 id="artist-name">Title: ${song.title}</h3>
                            <h4 id="album-name">URL: <a href="${song.linkUrl}" target="_blank">${song.linkUrl}</a></h4>
                            <h4 id="record-label">Record Label: ${song.duration}</h4>
                            <input type="hidden" class="song-id-field" value="${song.id}">
                            <button class="change-album-name-button">&#x270E</button>
                        </div>

                        <h1 id="title">Add a comment!</h1>

                        <input id="comment-username" type="text" placeholder="Username...">
                        <input id="comment-rating" type="number" min="0" step="0.1" max="5" placeholder="Rating...">
                        <input id="comment-body" type="text" placeholder="Body...">
                   
                        <input id="submit-comment-button" type="submit">
                    </div>
                </section>
            </div>
        </div>
    </div>
`
}