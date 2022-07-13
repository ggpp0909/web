import { atom } from "recoil";

export interface IToDo {
  text: string;
  category: "TO_DO" | "DOING" | "DONE"; // 단순한 string이 아니라 세개만 된다고 제한 하는 방법
  id: number;
}

export const toDoState = atom<IToDo[]>({
  key: "toDo",
  default: [],
});
