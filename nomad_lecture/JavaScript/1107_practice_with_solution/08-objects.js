/*
  [Object 요소 접근 연습]
  
	주어진 객체에서 items의 첫번째 아이템의 name을 result 변수에 할당하세요.
*/
const data = {
  id: 42,
  items: [
    {
      id: 1,
      name: 'foo',
    },
    {
      id: 2,
      name: 'bar',
    },
  ],
}
const result = data.items[0].name
// const result = data['items'][0]['name']
console.log(result)


/*
[Object 축약 문법]

아래 변수들을 속성으로 가지는 Object를 축약문법을 활용하여 작성하세요.
*/
const username = 'hailey'
const contact = '010-1234-5678'

// ES6+
const user = {
  username,
  contact
}
console.log(user)


/*
[Object Destructuring]

주어진 함수를 Object 축약 문법과, destructuring을 사용하여 재작성하세요.
*/

const users = [
  {
    name: 'hailey',
    contact: '010-1234-5678',
  },
  {
    name: 'paul',
    contact: '010-5678-1234',
  },
]

function saveUserData (users) {
  const userData = users.map((user, index) => {
    return { id: index, name: user.name, contact: user.contact }
  })

  return userData
}

// 1 단계
function saveUserData (users) {
  const userData = users.map(( { name, contact }, index) => ({ id: index, name, contact }) )
  return userData
}

// 2 단계
function saveUserData (users) {
  return users.map(( { name, contact }, index) => ({ id: index, name, contact }))
}

