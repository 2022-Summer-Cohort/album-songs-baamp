import header from "./header.js";
import home from "./home.js";
import songList from "./songList.js";
import singleSong from "./singleSong.js";
import animation from "./animation.js";
import footer from "./footer.js";
const container = document.querySelector(".container");

// Default homepage
function makeHomeView() {
  fetch("http://localhost:8080/api/albums")
  .then(res => res.json())
  .then(albums => {
    makeHomeViewFromJson(albums);
  })
}

// Displaying the albums on the home page
function makeHomeViewFromJson(albums) {
  console.log(albums);
  container.innerHTML = header();
  container.innerHTML += home(albums);
  container.innerHTML += footer();

  const albumEL = container.querySelectorAll(".album");
  albumEL.forEach(album => {

    // Show a specific album
    const albumCoverEl = album.querySelector(".album-cover")
    let albumIdEl = album.querySelector(".id-field");
    albumCoverEl.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`)
      .then(res => res.json())
      .then(album => {
        makeSongListView(album)
      })
    });


    // Delete an album from the home page
    const deleteAlbumButton = album.querySelector(".delete-album-button")
    deleteAlbumButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`, {
        method: 'DELETE'
      })
      .then(res => res.json())
      .then(newAlbums => {
        makeHomeViewFromJson(newAlbums);
      })
    });

  });

  // Create a new album on the home page
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
    .then(albums => {
      makeHomeView(albums)
    });
  });

  // When add album is clicked, show the popup to input the information
  const addAlbumButton = container.querySelector("#addAlbumButton")
  addAlbumButton.addEventListener("click", () => {
    popup.classList.add("open-popup");
  });
  // Make the popup no longer visible
  const dismissButton = container.querySelector("#dismissButton")
  dismissButton.addEventListener("click", () => {
    popup.classList.remove("open-popup");
  });
}

// Show the songs and information for a single album
function makeSongListView(album) {
  console.log(album);
  container.innerHTML = header();
  container.innerHTML += songList(album);
  container.innerHTML += footer();

  const albumInfoEl = container.querySelectorAll(".box-items");
  albumInfoEl.forEach(song => {
    let songIdEl = song.querySelector(".song-id-field");

    // Delete a song from the album
    const deleteSongButton = song.querySelector(".delete-song-button")
    deleteSongButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/songs/${songIdEl.value}`, {
        method: 'DELETE'
      })
      .then(res => res.json())
      .then(newAlbum => {
        makeSongListView(newAlbum)
      });
    });

    // When the play button or the song title is clicked, show page for that single song
    const songPlayButton = song.querySelector(".show-song");
    songPlayButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/songs/${songIdEl.value}`)
      .then(res => res.json())
      .then(selectedSong => {
        makeSongView(selectedSong);
      });
    });

  });

  // Editing the song title for each song
  const submitSongTitleButton = container.querySelector("#submitSongTitleButton");

  const songDivs = container.querySelectorAll(".songDiv")
  songDivs.forEach(songDiv => {
    const songIdEl = songDiv.querySelector(".song-id-field")
    const editSongButton = songDiv.querySelector(".edit-song-button")
    editSongButton.addEventListener("click", () => {
      const selectedSongIn = container.querySelector(".selected-song")
      songPopup.classList.add("open-popup");
      selectedSongIn.value = songIdEl.value;
    });
  });

  // Submitting the new song title
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
      makeSongListView(newAlbum)
    });
  });

  let songPopup = container.querySelector("#edit-song-title-popup")

  // Dismiss button (when editing song title)
  const dismissButton = container.querySelector("#dismissButton")
  dismissButton.addEventListener("click", () => {
    songPopup.classList.remove("open-popup");
  })

  // Submitting the new album title and showing the album song list again with the new album info
  const submitAlbumTitleButton = container.querySelector("#submit-album-title-button")
  let albumIdEl = container.querySelector(".album-id-field")
  submitAlbumTitleButton.addEventListener("click", () => {
    const updateAlbumTitle = container.querySelector("#new-album-title")
    fetch(`http://localhost:8080/api/albums/${albumIdEl.value}/newAlbumTitle`, {
      method: 'PATCH',
      body: updateAlbumTitle.value
    })
    .then(res => res.json())
    .then(newAlbum => {
      makeSongListView(newAlbum);
    });
  });

  // Editing the album title
  const editAlbumTitleButton = container.querySelector(".change-album-name-button")
  let albumTitlePopup = container.querySelector("#edit-album-popup")
  editAlbumTitleButton.addEventListener("click", () => {
    albumTitlePopup.classList.add("open-popup")
  });

  // Dismiss button (when editing album title)
  const dismissAlbumButton = container.querySelector("#dismissAlbumButton")
  dismissAlbumButton.addEventListener("click", () => {
    albumTitlePopup.classList.remove("open-popup");
  });

  // Back button to return to the home page
  const backButton = container.querySelector("#backbutton");
  backButton.addEventListener("click", () => {
    makeHomeView();
  });

  // Add a comment to the album
  const albumCommentUsername = container.querySelector("#comment-username");
  const albumCommentRating = container.querySelector("#comment-rating");
  const albumCommentBody = container.querySelector("#comment-body");
  const submitNewCommentButton = container.querySelector("#submit-comment-button");
  const albumIdElement = container.querySelector(".album-id-field");
  submitNewCommentButton.addEventListener("click", () => {
    const newAlbumComment = {
      "username": albumCommentUsername.value,
      "rating": albumCommentRating.value,
      "body": albumCommentBody.value,
    }
    fetch(`http://localhost:8080/api/albums/${albumIdElement.value}/newComment`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newAlbumComment)
    })
    .then(res => res.json())
    .then(album => {
      makeSongListView(album);
    });
  });

  // Add a song to the album
  const songTitleIn = container.querySelector("#song-title-in");
  const songUrlIn = container.querySelector("#song-url-in");
  const songDurationIn = container.querySelector("#song-duration-in");
  const submitNewSongButton = container.querySelector("#submit-song-button");
  submitNewSongButton.addEventListener("click", () => {
    const newSong = {
      "title": songTitleIn.value,
      "linkUrl": songUrlIn.value,
      "duration": songDurationIn.value,
    }
    fetch(`http://localhost:8080/api/albums/${albumIdElement.value}/addSongToAlbum`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newSong)
    })
    .then(res => res.json())
    .then(album => {
      makeSongListView(album);
    });
  });
}

// Displaying a single song
function makeSongView(song) {
  console.log(song);
  container.innerHTML = header();
  container.innerHTML += singleSong(song);
  container.innerHTML += footer();

  // Back button **CHANGE TO SHOW ALBUM?**
  const backbutton = container.querySelector("#backbutton");
  backbutton.addEventListener("click", () => {
    makeHomeView();
  });
}

makeHomeView();