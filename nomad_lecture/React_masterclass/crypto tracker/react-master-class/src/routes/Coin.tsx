import React, { useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import styled from "styled-components";


const Title = styled.h1`
  color: ${(props) => props.theme.accentColor};
  font-size: 48px;
`;

const Container = styled.div`
  padding: 0px 20px;
  max-width: 480px;
  margin: 0 auto;
`

const Header = styled.header`
  height: 10vh;
  display: flex;
  justify-content: center;
  align-items: center;
`
const Loader = styled.div`
  text-align: center;
  display: block;
`
interface RouterState {
  state: {
    name: string;
  };
}

const Coin = () => {
  const {coinId} = useParams();
  const [loading, setLoading] = useState(true)
  const location = useLocation()
  const { state } = useLocation() as RouterState;
  console.log(state.name)

  return (
    <Container>
      <Header>
        <Title>{state?.name || "Loading.."}</Title>
      </Header>
      {loading ? <Loader>"Loading..."</Loader> : null}
    </Container>
  );
}

export default Coin;