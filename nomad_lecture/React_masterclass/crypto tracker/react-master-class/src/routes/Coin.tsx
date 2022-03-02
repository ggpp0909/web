import React, { useEffect, useState } from "react";
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
  const { state } = useLocation() as RouterState;
  const [info, setInfo] = useState({})
  const [priceInfo, setPriceInfo] = useState({});
  // console.log(state.name)
  useEffect(() => {
    (async () => {
      const infoData = await(
        await fetch(`https://api.coinpaprika.com/v1/coins/${coinId}`)
      ).json();
      const priceData = await(
        await fetch(`https://api.coinpaprika.com/v1/tickers/${coinId}`)
      ).json()
      setInfo(infoData)
      setPriceInfo(priceData)
    })();
  }, []);

  return (
    <Container>
      <Header>
        <Title>{state?.name || "Loading.."}</Title>
      </Header>
      {loading ? <Loader>"Loading..."</Loader> : <span></span>}
    </Container>
  );
}

export default Coin;