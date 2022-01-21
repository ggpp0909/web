import { createStore } from "redux";

const add = document.querySelector("#add");
const minus = document.querySelector("#minus");
const number = document.querySelector("#number");

const countModifier = (state = 0) => {
  return state
};
const countStore = createStore(countModifier)
console.log(countStore.getState())

