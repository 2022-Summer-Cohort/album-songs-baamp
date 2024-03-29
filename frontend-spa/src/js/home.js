export default function home(albums) {
    let albumCount = 1;
    return `
    <div class="container">
        <div id="content">
            <div id="view-screen">
                <img class="logo" id="on-screen-logo" src="/src/images/SODASHOPLOGO.png" alt="">
                <img id="touchtunes" src="/src/images/BLANK-TOUCHTUNES.png" alt="">
                
                <section class="projects">
                    <div class="slider">
                        <span id="addAlbumButton" class="addAlbum" style="--i:1;">
                            <img class="add-album-cover" src="/src/images/addButtonVector.png">
                            <p class="artist-name-home">Add Album</p>
                        </span>
                    
                        ${albums.map(album => {
                            albumCount++;
                            return `
                                <span class="album" style="--i:${albumCount};">
                                    <figure>
                                        <img class="album-cover" src="${album.imgUrl}">
                                        <button id="deleteAlbumButton" class="delete-album-button">&#128465</button>
                                    </figure>
                                    <input type="hidden" class="id-field" value="${album.id}">
                                    
                                    <p class="artist-name-home">Artist: ${album.artistName}</p>
                                    <p class="album-name-home">Album: ${album.title}</p>
                                </span>
                            `}).join("")
                        }
                    </div>
                </section>
                
                <div class="popup" id="popup">
                    <button id="dismissButton" type="button">&#10006</button>
                    <h2>Add Album</h2>
                    <input id="album-title" class="rating-comment-submit" type="text" placeholder="Title...">
                    <br><br>
                    <input id="artist-name" class="rating-comment-submit" type="text" placeholder="Artist Name">
                    <br><br>
                    <input id="album-image-url" class="rating-comment-submit" type="text" placeholder="Image Link (URL)">
                    <br><br>
                    <input id="record-label" class="rating-comment-submit" type="text" 
                        placeholder="Record Label (optional)">
                    <br><br>
                    <input id="submitAlbumButton" type="submit">
                </div>
            </div>
        </div>
    </div>
`
}