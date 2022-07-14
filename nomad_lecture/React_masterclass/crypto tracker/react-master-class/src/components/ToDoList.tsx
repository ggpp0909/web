import { useRecoilValue } from "recoil";
import { toDoState } from "../atoms";
import CreateToDo from "./CreateToDo";
import ToDo from "./ToDo";

function ToDoList() {
  // const value = useRecoilValue(toDoState) // 리코일에서 값을 불러오는법
  // const modifierFn = useSetRecoilState(toDoState) // 리코일에서 값을 변경하는법, useState의 value와 setValue와 유사
  const toDos = useRecoilValue(toDoState); // 위 두개를 한번에 해주기
  console.log(toDos);

  return (
    <div>
      <h1>To Dos</h1>
      <hr />
      <CreateToDo />
      <ul>
        {toDos.map((toDo) => (
          <ToDo key={toDo.id} {...toDo} />
        ))}
      </ul>
    </div>
  );
}

export default ToDoList;
