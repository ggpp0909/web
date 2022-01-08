const loginForm = document.querySelector("#login-form");
const loginInput = loginForm.querySelector("input")
const greeting = document.querySelector("#greeting")

function onLoginSubmit(event) {
  event.preventDefault()
  console.log(loginInput.value)
  const username = loginInput.value
  localStorage.setItem("username", username)

  loginForm.classList.add("hidden")
  // greeting.innerText = "Hello " + username

  // greeting.classList.remove("hidden")
  paintGreetings(username)
}

function paintGreetings(username) {
  greeting.innerText = `Hello ${username}`
  greeting.classList.remove("hidden")
}

const savedUsername = localStorage.getItem("username")

if(savedUsername === null) {
  loginForm.classList.remove("hidden")
  loginForm.addEventListener("submit", onLoginSubmit)
} else {
  // greeting.innerText = `Hello ${savedUsername}`
  // greeting.classList.remove("hidden")
  paintGreetings(savedUsername)
}