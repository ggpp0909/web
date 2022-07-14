import { useSetRecoilState } from "recoil";
import { IToDo, toDoState } from "../atoms";

function ToDo({ text, category, id }: IToDo) {
  const setToDos = useSetRecoilState(toDoState);

  const onClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    const {
      currentTarget: { name },
    } = event;
    setToDos((oldToDos) => {
      const targetIndex = oldToDos.findIndex((toDo) => toDo.id === id); // 프롭으로 온 id와 같은 todo의 인덱스를 찾아줌
      console.log(targetIndex);
      const oldToDo = oldToDos[targetIndex];
      const newToDo = { text, id, category: name };
      return oldToDos;
    });
  };

  return (
    <li>
      <span>{text}</span>
      {category !== "DOING" && <button onClick={onClick}>Doing</button>}
      {category !== "TO_DO" && <button onClick={onClick}>To Do</button>}
      {category !== "DONE" && <button onClick={onClick}>Done</button>}
    </li>
  );
}

export default ToDo;
