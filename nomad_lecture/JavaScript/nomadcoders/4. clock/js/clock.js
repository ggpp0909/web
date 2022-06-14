const clock = document.querySelector("#clock")

function getClock() {
  const date = new Date();
  const hours = String(date.getHours()).padStart(2,"0")
  const minutes = String(date.getMinutes()).padStart(2,"0")
  const seconds = String(date.getSeconds()).padStart(2,"0")
  clock.innerText = `${hours}:${minutes}:${seconds}`
}

// setInterval(sayHello, 5000) 5초마다 계속 실행
getClock() // 웹사이트가 로드되자마자 바로 보이게
setInterval(getClock, 1000)