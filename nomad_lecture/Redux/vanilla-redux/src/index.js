const add = document.querySelector("#add");
const minus = document.querySelector("#minus");
const number = document.querySelector("#number");

let count = 0;
number.innerText = count;

const updateText = () => {
  number.innerText = count;
}

const handleAdd = () => {
  count = count + 1;
  updateText();
}
const handleminus = () => {
  count = count - 1;
  updateText();
}

add.addEventListener("click", handleAdd);
minus.addEventListener("click", handleminus);

