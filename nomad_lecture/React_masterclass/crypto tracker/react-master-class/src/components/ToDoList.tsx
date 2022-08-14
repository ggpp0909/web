import React from "react";
import { useRecoilState, useRecoilValue } from "recoil";
import {
  Categories,
  categoryState,
  IToDo,
  toDoSelector,
  toDoState,
} from "../atoms";
import CreateToDo from "./CreateToDo";
import ToDo from "./ToDo";

function ToDoList() {
  // const value = useRecoilValue(toDoState) // 리코일에서 값을 불러오는법
  // const modifierFn = useSetRecoilState(toDoState) // 리코일에서 값을 변경하는법, useState의 value와 setValue와 유사
  // const toDos = useRecoilValue(toDoState);
  const toDos = useRecoilValue(toDoSelector);
  const [category, setCategory] = useRecoilState(categoryState);
  const onInput = (e: React.FocusEvent<HTMLSelectElement>) => {
    setCategory(e.currentTarget.value as IToDo["category"]);
  };
  return (
    <div>
      <h1>To Dos</h1>
      <hr />
      <select value={category} onChange={onInput}>
        <option value={Categories.TO_DO}>To Do</option>
        <option value={Categories.DOING}>Doing</option>
        <option value={Categories.DONE}>Done</option>
      </select>
      <CreateToDo />
      {toDos?.map((toDo) => (
        <ToDo key={toDo.id} {...toDo}></ToDo>
      ))}
    </div>
  );
}

export default ToDoList;
