import styled from "styled-components";

const Container = styled.div<ContainerProps>`
  width: 200px;
  height: 200px;
  background-color: ${(props) => props.bgColor};
  border-radius: 100px;
`;
interface ContainerProps {
  bgColor: string;

}
interface CircleProps {
  bgColor: string;

}

const Circle = ({bgColor}: CircleProps) => {
  return <Container bgColor={bgColor}></Container>
}

export default Circle