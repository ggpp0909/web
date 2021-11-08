// functionScope
function functionScope() {
  for (var x=1; x<5; x++) {
      console.log(x, 'in a for')
  }
  console.log(x)
}
functionScope()
​
// 1 'in a for'
// 2 'in a for'
// 3 'in a for'
// 4 'in a for'
// 5
​
​
// blockScope
function blockScope() {
  for (let x=1; x<5; x++) {
      console.log(x, 'in a for')
  }
  console.log(x)
}
blockScope()
​
// 1 'in a for'
// 2 'in a for'
// 3 'in a for'
// 4 'in a for'
// Uncaught ReferenceError: x is not defined
//    at block (<anonymous>:5:17)
//    at <anonymous>:1:1