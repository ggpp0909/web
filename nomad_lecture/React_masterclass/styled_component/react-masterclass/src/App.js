import styled, { keyframes } from "styled-components";


const Wrapper = styled.div`
  display: flex;
`
const animation = keyframes`
  0% {
    transform: rotate(0deg);
    border-radius: 0px;
  } 
  50% {
    transform: rotate(360deg);
    border-radius: 100px;
  } 
  100% {
    transform: rotate(0deg);
    border-radius: 0px;
  }
`
const Emoji = styled.span`
  font-size: 36px;
`

const Box = styled.div`
  height: 100px;
  width: 100px;
  background-color: tomato;
  display: flex;
  justify-content: center;
  align-items: center;
  animation: ${animation} 1s linear infinite;
  ${Emoji} {
    &:hover {
      font-size: 98px;
    }
  }
`

function App() {
  return (
    <Wrapper>
      <Box>
        {/* Box에서 p태그여도 Emoji 태그에 적용시키도록 했기때문에 잘 작동함  */}
        <Emoji as="p">ㅎㅎ</Emoji>
      </Box>
      <Emoji as="p">ㅋㅋ</Emoji>
    </Wrapper>
  )
}

export default App;
