import { DragDropContext, Draggable, Droppable } from "react-beautiful-dnd";

function App() {
  const onDragEnd = () => {};
  return (
    // 드래그 앤 드롭 컨텍스트는 onDrageEnd(드래그가 끝나는 시점에 실행될 함수)와 children이 필수
    <DragDropContext onDragEnd={onDragEnd}>
      <div>
        {/* droppableId 필수, droppable은 드롭할 수 있는 영역이 여러개일수 있기 때문에. 
        droppable, draggable의 children은 funtion이어야함 */}
        <Droppable droppableId="one">
          {() => (
            <ul>
              {/* draggable은 draggableId, index 필수 */}
              <Draggable draggableId="first" index={0}>
                {() => <li>One</li>}
              </Draggable>
              <Draggable draggableId="second" index={1}>
                {() => <li>Two</li>}
              </Draggable>
            </ul>
          )}
        </Droppable>
      </div>
    </DragDropContext>
  );
}

export default App;
