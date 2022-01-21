import { createStore } from "redux";

const add = document.querySelector("#add");
const minus = document.querySelector("#minus");
const number = document.querySelector("#number");

const countModifier = (count = 0, action) => {
  if (action.type === "ADD") {
    return count + 1;
  } else if (action.type === "MINUS") {
    return count - 1;
  } else {
    return count;
  }
};

const countStore = createStore(countModifier);
const onChange = () => {
  number.innerText = countStore.getState()
}
countStore.subscribe(onChange)
add.addEventListener("click", () => countStore.dispatch({type:"ADD"}))
minus.addEventListener("click", () => countStore.dispatch({type:"MINUS"}))

