/*
 [배열 관련 주요 메서드 연습 심화 1]
 
 속력(distance/time)을 저장하는 배열 speeds를 만드세요.
*/
const trips = [
  { distance: 34, time: 10 },
  { distance: 90, time: 50 },
  { distance: 59, time: 25 },
]

// let result = []
// for (let trip of trips) {
//   result.push(trip.distance / trip.time)
// }
// console.log(result)

// map
const speeds = trips.map(function (trip) {
  return trip.distance / trip.time
})

// 1 단계
const speeds = trips.map((trip) => {
  return trip.distance / trip.time
})

// 2 단계
const speeds = trips.map(trip => trip.distance / trip.time)
console.log(speeds)

/*
 [배열 관련 주요 메서드 연습 심화 2]
 
 주어진 배열의 요소 중 특정 문자(query)가 포함되는 요소만 모아서 새로운 배열을 반환하세요.
*/
const languages = ['python', 'javascript', 'html', 'java']
const query = 'java'

const result = languages.filter(function (language) {
  // 표현식이 참인 요소들만 모아서 새로운 배열로 반환
  return language.includes(query)
})

// Arrow Function
const result = languages.filter(language => language.includes(query))

console.log(result)

/*
 [배열 관련 주요 메서드 연습 심화 3]
 
 주어진 배열을 사용하여 다음과 같은 객체를 만드세요.
 {
   smith: 90,
   peter: 80,
   anna: 85,
 }
*/
const scores = [
  { name: 'smith', score: 90 },
  { name: 'peter', score: 80 },
  { name: 'anna', score: 85 },
]

const result = {}

scores.forEach(function (score) {
  result[score.name] = score.score
})

scores.forEach(score => {
  result[score.name] = score.score
})


console.log(result)

// reduce
const result = scores.reduce(function (acc, score) {
  acc[score.name] = score.score
  return acc
}, {})

const result = scores.reduce((acc, score) => {
  acc[score.name] = score.score
  return acc
}, {})
console.log(result)



/*
 [배열 관련 주요 메서드 연습 심화 4]
 
 주어진 accounts 배열에서 balance가 24,000인 사람을 찾으세요.
*/
const accounts = [
	{ name: 'justin', balance: 1200 },
	{ name: 'harry', balance: 50000 },
	{ name: 'jason', balance: 24000 },
  { name: 'jhon', balance: 24000 }
]

const result = accounts.find(function (account) {
  return account.balance === 24000
})

const result = accounts.find(account => account.balance === 24000)

console.log(result)


/*
 [배열 관련 주요 메서드 연습 심화 5]
 
 주어진 requests 배열에서 status가 pending인 요청이 있는지 확인하세요.
*/
const requests = [
  { url: '/photos', status: 'complete' },
  { url: '/albums', status: 'pending' },
  { url: '/users', status: 'failed' },
]

const isPending = requests.some(function (request) {
  return request.status === 'pending'
})

const isPending = requests.some(request => request.status === 'pending')
console.log(isPending)



/*
 [배열 관련 주요 메서드 연습 심화 6]
 
 주어진 users 배열을 통해 모든 유저의 상태가 submmited인지 여부를 확인하세요.
*/
const users = [
  { name: 'Harry', submitted: true },
  { name: 'Eric', submitted: true },
  { name: 'Tony', submitted: false },
]

const result = users.every(function (user) {
  return user.submitted
})

const result = users.every(user => user.submitted)

console.log(result)