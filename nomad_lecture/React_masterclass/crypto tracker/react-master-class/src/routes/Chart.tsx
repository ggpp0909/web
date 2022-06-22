import { useQuery } from "react-query";
import { useOutletContext } from "react-router-dom";
import { fetchCoinHistory } from "./api";

interface IChart {
  coinId:string;
}

const Chart = () => {
  const data = useOutletContext<IChart>()
  const { isLoading, data:chartdata } = useQuery(["ohlcv", data.coinId], () => fetchCoinHistory(data.coinId))
  console.log(data)
  console.log(chartdata)
  return <h1>Chart</h1>
}

export default Chart;