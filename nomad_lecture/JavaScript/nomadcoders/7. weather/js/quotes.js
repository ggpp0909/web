const quotes = [{
  quote: "작은 고추가 맵다",
  author: "윤관"
},
{
  quote: "배고프다",
  author: "장영남",
},
{
  quote: "엥",
  author: "장원종",
},
{
  quote: "5시까지 다들어오래이",
  author: "최소희",
},
{
  quote: "뮤지컬 구경오세요",
  author: "이우철",
},
]

const quote = document.querySelector("#quote span:first-child")
const author = document.querySelector("#quote span:last-child")

const todaysQuote = quotes[Math.floor(Math.random() * quotes.length)]

quote.innerText = todaysQuote.quote
author.innerText = todaysQuote.author