import styled from "styled-components";

const Container = styled.div<ContainerProps>`
  width: 200px;
  height: 200px;
  background-color: ${(props) => props.bgColor};
  border-radius: 100px;
  border: 1px solid ${(props) => props.borderColor};
`;
interface ContainerProps {
  bgColor: string;
  borderColor: string;

}
interface CircleProps {
  bgColor: string;
  borderColor?: string;
  text?: string;
}

const Circle = ({bgColor, borderColor, text = "default text"}: CircleProps) => {
  // bordercolor가 있으면 사용하고 없으면 default값으로 이것을 사용하세요 라는뜻
  return (
    <Container bgColor={bgColor} borderColor={borderColor ?? "yellow"}>
      {text}
    </Container>
  );
}

export default Circle