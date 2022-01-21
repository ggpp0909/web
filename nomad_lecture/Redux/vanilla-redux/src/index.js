import { createStore } from "redux";

const add = document.querySelector("#add");
const minus = document.querySelector("#minus");
const number = document.querySelector("#number");

const ADD = "ADD" // string으로 오타나면 오류 말해주지 않으므로 이렇게 변경 (안전하게)
const MINUS = "MINUS"

const countModifier = (count = 0, action) => {
  // if (action.type === "ADD") {
  //   return count + 1;
  // } else if (action.type === "MINUS") {
  //   return count - 1;
  // } else {
  //   return count;
  // }
  switch (action.type) {
    case ADD:
      return count + 1;
    case MINUS:
      return count - 1;
    default:
      return count;
  }
};

const countStore = createStore(countModifier);
const onChange = () => {
  number.innerText = countStore.getState()
}
countStore.subscribe(onChange)
add.addEventListener("click", () => countStore.dispatch({type:ADD}))
minus.addEventListener("click", () => countStore.dispatch({type:MINUS}))

