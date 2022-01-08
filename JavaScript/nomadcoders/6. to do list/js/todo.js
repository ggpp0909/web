const todoForm = document.querySelector("#todo-form")
const todoList = document.querySelector("#todo-list")
const todoInput = todoForm.querySelector("#todo-form input")

let toDos = []

function saveToDos () {
  localStorage.setItem("todos", JSON.stringify(toDos))
}

function deleteToDO(event) {
  // console.dir(event.target.parentElement)
  const li = event.target.parentElement
  li.remove()
  toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id))
  saveToDos()
}

function paintToDo(newTodo) {
  const li = document.createElement("li")
  const span = document.createElement("span")
  span.innerText = newTodo

  const button = document.createElement("button")
  button.innerText = "❌"
  button.addEventListener("click", deleteToDO)

  li.appendChild(span)
  li.appendChild(button)
  // console.log(li)
  // console.log(todoList)
  todoList.appendChild(li)
}

function handleToDoSubmit(event) {
  event.preventDefault()
  // console.log(todoInput.value)
  const newTodo = todoInput.value
  todoInput.value = ""
  const newTodoObj = {
    text:newTodo,
    id: Date.now(),
  }
  toDos.push(newTodoObj)
  paintToDo(newTodo)
  saveToDos()
}

todoForm.addEventListener("submit", handleToDoSubmit)


const savedTodos = localStorage.getItem("todos")
// console.log(savedTodos)
if (savedTodos !== null) {
  const parsedTodos = JSON.parse(savedTodos)
  // console.log(parsedTodos)
  toDos = parsedTodos
  parsedTodos.forEach(paintToDo)
}