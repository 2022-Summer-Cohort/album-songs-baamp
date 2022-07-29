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
                            <a href="${song.linkUrl}" target="_blank"><h3 id="artist-name">Title: ${song.title}</h3></a>
                            <h4 id="record-label">Duration: ${song.duration}</h4>
                            <a href="#song-comments"><h4 id="avgRating">Rating: ${song.avgRating}<span id="gold">&#x272D;</span></h4></a>
                            <input type="hidden" class="song-id-field" value="${song.id}">
                        </div>
                        
                        <div id="song-comments"><br><br>
                            ${song.comments.map(comment => {
                                return `
                                <div class="album-comments">
                                    <section class="comment-box-items">
                                        <h1>${comment.username}</h1>
                                        <h3>${comment.rating} <span id="gold">&#x272D;</span></h3>
                                        <p>${comment.body}</p>
                                    </section>
                                </div>
                                `}).join("")
                            }
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