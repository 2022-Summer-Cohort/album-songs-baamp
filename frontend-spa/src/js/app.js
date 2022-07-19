const modal = document.querySelector(".modal")
const companyBtn = document.querySelector(".sub-btn");
companyBtn.addEventListener("click", () => {
modal.classList.add("active")
})

const closeBtn = document.querySelector(".close-modal");
closeBtn.addEventListener("click", () => {
  modal.classList.remove("active")
})