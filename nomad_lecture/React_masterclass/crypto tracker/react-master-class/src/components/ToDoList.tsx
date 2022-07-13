import { useForm } from "react-hook-form";
import {
  atom,
  useRecoilState,
  useRecoilValue,
  useSetRecoilState,
} from "recoil";

const toDoState = atom<IToDo[]>({
  key: "toDo",
  default: [],
});

interface IForm {
  toDo: string;
}

interface IToDo {
  text: string;
  category: "TO_DO" | "DOING" | "DONE"; // 단순한 string이 아니라 세개만 된다고 제한 하는 방법
  id: number;
}

function ToDoList() {
  // const value = useRecoilValue(toDoState) // 리코일에서 값을 불러오는법
  // const modifierFn = useSetRecoilState(toDoState) // 리코일에서 값을 변경하는법, useState의 value와 setValue와 유사
  const [toDos, setToDos] = useRecoilState(toDoState); // 위 두개를 한번에 해주기

  const { register, handleSubmit, setValue } = useForm<IForm>();
  const handleValid = ({ toDo }: IForm) => {
    console.log("add to do", toDo);
    setToDos((oldToDos) => [
      { text: toDo, id: Date.now(), category: "TO_DO" },
      ...oldToDos,
    ]); // 기존 setState와 마찬가지로 그냥 값을 넣을수도 있지만 함수를 넣어서 리턴값으로 해줄수도있음 + 인자로 쉽게 현재상태에 접근가능
    setValue("toDo", "");
  };

  console.log(toDos);

  return (
    <div>
      <h1>To Dos</h1>
      <hr />
      <form onSubmit={handleSubmit(handleValid)}>
        <input
          {...register("toDo", {
            required: "Please write a To Do",
          })}
          placeholder="Write a to do"
        />
        <button>Add</button>
      </form>
      <ul>
        {toDos.map((toDo) => (
          <li key={toDo.id}>{toDo.text}</li>
        ))}
      </ul>
    </div>
  );
}

export default ToDoList;
