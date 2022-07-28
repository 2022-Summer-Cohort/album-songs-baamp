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

function makeHomeView() {
  fetch("http://localhost:8080/api/albums")
    .then(res => res.json())
    .then(albums => {
      makeHomeViewFromJson(albums)
    })
}
function makeHomeViewFromJson(albums) {
  console.log(albums);
  container.innerHTML = header();
  container.innerHTML += home(albums);
  container.innerHTML += footer();

  const albumEL = container.querySelectorAll(".album");
  albumEL.forEach(album => {
    const albumCoverEl = album.querySelector(".album-cover")
    let albumIdEl = album.querySelector(".id-field");
    albumCoverEl.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`)
      .then(res => res.json())
      .then(album => {
        makeSongListView(album)
      })
    })

    const deleteAlbumButton = album.querySelector(".delete-album-button")
    deleteAlbumButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`,{
        method: 'DELETE'

      } )
      .then(res => res.json())
      .then(newAlbums => {
        makeHomeViewFromJson(newAlbums);
      })
      
    })


 

}

);
const albumTitleIn = container.querySelector("#album-title");
const artistNameIn = container.querySelector("#artist-name");
const albumImageURLIn = container.querySelector("#album-image-url");
const recordLabelIn = container.querySelector("#record-label");

const submitAlbumButton = container.querySelector("#submitAlbumButton");
submitAlbumButton.addEventListener("click", () => {
  
  const newAlbumJson = {
    "title": albumTitleIn.value,
    "artistName": artistNameIn.value,
    "imgUrl": albumImageURLIn.value,
    "recordLabel": recordLabelIn.value,
  }

  fetch(`http://localhost:8080/api/albums/addAlbum`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newAlbumJson)
  })
    .then(res => res.json())
    .then(album => {
      // 
      // makeSongListView(newAlbumJson)
      makeHomeView(albums)
    })
})

const addAlbumButton = container.querySelector("#addAlbumButton")
addAlbumButton.addEventListener("click", () => {
  
  popup.classList.add("open-popup");
  
})
const dismissButton = container.querySelector("#dismissButton")
dismissButton.addEventListener("click", () => {
  popup.classList.remove("open-popup");
})
}


// const changeAlbumNameButton = container.querySelector(".change-album-name-button");
// const changeAlbumNameText = container.querySelector("#popup");
// console.log(changeAlbumNameButton)
// changeAlbumNameButton.addEventListener("click", () => {
//   changeAlbumNameText.classList.toggle("hide");
//   changeAlbumNameText.classList.toggle("show");
// })







function makeSongListView(album) {
  console.log(album);
  container.innerHTML = header();
  container.innerHTML += songList(album);
  container.innerHTML += footer();

  const albuminfoEl = container.querySelectorAll(".box-items");
// let popup = container.querySelector(".popup")
// let songIdEl = song.querySelector(".song-id-field");
  albuminfoEl.forEach(song => {
    let songIdEl = song.querySelector(".song-id-field");
    

    const deleteSongButton = song.querySelector(".delete-song-button")
    deleteSongButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/songs/${songIdEl.value}`,{
        method: 'DELETE'
      })
        .then(res => res.json())
        .then(newAlbum => {
          makeSongListView(newAlbum)
        })
    })

 


    
    
  });
  const submitSongTitleButton = container.querySelector("#submitSongTitleButton");
  const songDivs = container.querySelectorAll(".songDiv")
    songDivs.forEach(songDiv => {
      const songIdEl = songDiv.querySelector(".song-id-field")
      const editSongButton = songDiv.querySelector(".edit-song-button")
      editSongButton.addEventListener("click", () => {
        const selectedSongIn = container.querySelector(".selected-song")
        songPopup.classList.add("open-popup");
        selectedSongIn.value = songIdEl.value;
      })
    })
 
    
    
  submitSongTitleButton.addEventListener("click", () => {
    
    const selectedSongIn = container.querySelector(".selected-song")
    const newSongTitleIn = container.querySelector("#new-song-title");
   console.log(selectedSongIn)
    fetch(`http://localhost:8080/api/songs/${selectedSongIn.value}/editSongTitle`, {
      method: 'PATCH',
      body: newSongTitleIn.value
    })
    .then(res => res.json())
    .then(newAlbum => {
      console.log(newAlbum)
      makeSongListView(newAlbum)
    })
  
  })


  
  
  let songPopup = container.querySelector("#edit-song-title-popup")

  
  const dismissButton = container.querySelector("#dismissButton")
  dismissButton.addEventListener("click", () => {
    songPopup.classList.remove("open-popup");
  })

  const backbutton = container.querySelector("#backbutton");
  backbutton.addEventListener("click", () => {
    makeHomeView();
  })
  
  }

  



makeHomeView()












//   const changeAlbumNameButton = container.querySelector(".change-album-name-button");
//   const changeAlbumNameText = container.querySelector("#popup");
//   console.log(changeAlbumNameText)
//   changeAlbumNameButton.addEventListener("click", () => {
//     changeAlbumNameText.classList.toggle("hide");
//     changeAlbumNameText.classList.toggle("show");
//   })

//   const deleteAlbumButton = container.querySelector(".delete-album-button");
//   deleteAlbumButton.addEventListener("click", () => {
//     fetch(`HTTP MAPPING FOR DELETE${albumElId.value}`, {
//       method: 'DELETE'
//     })
//       .then(res => res.json())
//       .then(newAlbums => {
//         makeHomeViewFromJson(newAlbums);
//         //TODO review this code
//       })
//   })

//   const titleIn = container.querySelector(".titleNameInput");
//   const linkURLIn = container.querySelector(".linkURLInput");
//   const durationIn = container.querySelector(".durationInput");
//   const albumIn = container.querySelector(".albumInput");
//   const addSongToAlbumButton = songs.querySelector(".add-song-to-album-button");
//   addSongToAlbumButton.addEventListener("click", () => {
//     const newSongJson = {
//       "title": titleIn.value,
//       "linkURL": linkURLIn.value,
//       "duration": durationIn.value,
//       "album": albumIn.value,
//     }
//     // fetch(`HTTP MAPPING FOR ADD/${song.id}/addSong`,
//     // method: "POST"
//     // )
//   })

//   changeSongNameButton = songs.querySelector(".change-song-name-button");
//   const deleteSongButton = songs.querySelector(".delete-song-button");
//   deleteSongButton.addEventListener

// }





// // makeSingleSongView(song) {

// // }
