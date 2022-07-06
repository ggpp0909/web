import React, { useState } from "react";
import { useForm } from "react-hook-form";

const ToDoList = () => {
  const { register, watch } = useForm();

  return (
    <div>
      <form>
        <input {...register("toDo")} placeholder="Write a to do" />
        <button>ADD</button>
      </form>
    </div>
  );
};

/* const ToDoList = () => {
  const [toDo, setTodo] = useState<string>("");
  const onChange = (event: React.FormEvent<HTMLInputElement>) => {
    const {
      currentTarget: { value },
    } = event;
    setTodo(value);
  };
  const onSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(toDo);
  };

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input onChange={onChange} value={toDo} placeholder="Write a to do" />
        <button>ADD</button>
      </form>
    </div>
  );
}; */

export default ToDoList;
