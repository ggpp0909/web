import { atom, selector } from "recoil";

export interface IToDo {
  text: string;
  category: "TO_DO" | "DOING" | "DONE"; // 단순한 string이 아니라 세개만 된다고 제한 하는 방법
  id: number;
}

export const toDoState = atom<IToDo[]>({
  key: "toDo",
  default: [], // atom은 단순히 빈 array를 줄 뿐, atom의 output을 변형시키는 건 selector.
});

export const toDoSelector = selector({
  // key, get필요
  key: "toDoSelector",
  get: ({ get }) => {
    const toDos = get(toDoState);
    return [
      toDos.filter((toDo) => toDo.category === "TO_DO"),
      toDos.filter((toDo) => toDo.category === "DOING"),
      toDos.filter((toDo) => toDo.category === "DONE"),
    ];
  },
});
