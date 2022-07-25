// const modal = document.querySelector(".modal")
// const companyBtn = document.querySelector(".sub-btn");
// companyBtn.addEventListener("click", () => {
// modal.classList.add("active")
// })

// const closeBtn = document.querySelector(".close-modal");
// closeBtn.addEventListener("click", () => {
//   modal.classList.remove("active")
// })
import header from "./header.js";
import home from "./home.js";
import songList from "./songList.js";
import singleSong from "./singleSong.js";
import animation from "./animation.js";
import footer from "./footer.js";
const container = document.querySelector(".container");

const changeAlbumNameButton = document.querySelector(".change-album-name-button");
const changeAlbumNameText = container.querySelector("#popup");
console.log(changeAlbumNameButton)
changeAlbumNameButton.addEventListener("click", () =>{
  changeAlbumNameText.classList.toggle("hide");
  changeAlbumNameText.classList.toggle("show");
})

function makeHomeView() {
  // fetch(LOCALHOST MAPPING HERE!!!!!!!!)
  //   .then(res => res.json())
  //   .then(albums => {
      makeHomeViewFromJson({})
    // })
}

function makeHomeViewFromJson(albums) {
  console.log(albums);
  container.innerHTML += header();
  container.innerHTML += home(albums);
  container.innerHTML += footer();

  const albumEL = container.querySelectorAll(".album");

  albumEL.forEach(album => {
    let albumCoverEl = album.querySelector(".album-cover")
    let albumElId = album.querySelector(".album-name-home");
    const artistEL = album.querySelector(".artist-name-home");
    albumCoverEl.addEventListener("click", () => {
      albums.forEach(albumJson => {
        makeSongListView(albumJson)
      })
    })


  })
}

function makeSongListView(songs) {
  console.log(songs);
  container.innerHTML += header();
  container.innerHTML += songList(songs);
  container.innerHTML += footer();

  const albuminfoEl = container.querySelectorAll(".album-info");


  albuminfoEl.forEach(album => {
    album.addEventListener("click", () => {
      let artistNameEL = album.querySelector("#artist-name");
      let albumNameEl = album.querySelector("#album-name");
      let recordLabelEl = album.querySelector("#record-label");
      let songNameEl = album.querySelector(".box-item");
      let playArrowEl = album.querySelector(".play-arrow")
      songElement.forEach(song=> {
        playArrowEl.addEventListener("click", () =>{
          let singleSong = song.querySelector(".play-arrow");
          makeSingleSongView(songJson);
      })
      
        
      })
    })
  })
const backbutton = container.querySelector("#backbutton");
backbutton.addEventListener("click", () =>{
  makeHomeView();
})

const changeAlbumNameButton = container.querySelector(".change-album-name-button");
const changeAlbumNameText = container.querySelector("#popup");
console.log(changeAlbumNameText)
changeAlbumNameButton.addEventListener("click", () =>{
  changeAlbumNameText.classList.toggle("hide");
  changeAlbumNameText.classList.toggle("show");
})

const deleteAlbumButton = container.querySelector(".delete-album-button");
deleteAlbumButton.addEventListener("click", () => {
  fetch(`HTTP MAPPING FOR DELETE${albumElId.value}`,{
    method: 'DELETE'
  })
  .then(res => res.json())
  .then(newAlbums => {
makeHomeViewFromJson(newAlbums);
//TODO review this code
  })
})

const titleIn = container.querySelector(".titleNameInput");
const linkURLIn = container.querySelector(".linkURLInput");
const durationIn = container.querySelector(".durationInput");
const albumIn = container.querySelector(".albumInput");
const addSongToAlbumButton = songs.querySelector(".add-song-to-album-button");
addSongToAlbumButton.addEventListener("click", () => {
  const newSongJson = {
    "title": titleIn.value,
    "linkURL": linkURLIn.value,
    "duration": durationIn.value,
    "album": albumIn.value,
  }
  // fetch(`HTTP MAPPING FOR ADD/${song.id}/addSong`,
  // method: "POST"
  // )
})

changeSongNameButton = songs.querySelector(".change-song-name-button");
  const deleteSongButton = songs.querySelector(".delete-song-button");
  deleteSongButton.addEventListener
  
}


// makeSingleSongView(song) {

// }

makeHomeView();