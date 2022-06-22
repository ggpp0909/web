import { useQuery } from "react-query";
import { useOutletContext } from "react-router-dom";
import { fetchCoinHistory } from "./api";
import ApexChart from "react-apexcharts";

interface IHistorical {
  close: string;
  high: string;
  low: string;
  market_cap: number;
  open: string;
  time_close: number;
  time_open: number;
  volume: string;
}

interface IChart {
  coinId: string;
}

const Chart = () => {
  const data = useOutletContext<IChart>();
  const { isLoading, data: chartdata } = useQuery<IHistorical[]>(
    ["ohlcv", data.coinId],
    () => fetchCoinHistory(data.coinId)
  );
  console.log(data);
  console.log(chartdata);
  return (
    <div>
      {isLoading ? (
        "Loading..."
      ) : (
        <ApexChart
          type="line"
          series={[
            {
              data: chartdata?.map((price) => Number(price.close)) as number[],
              name: "price",
            },
          ]}
          options={{
            theme: {
              mode: "dark",
            },
            chart: {
              height: 300,
              width: 500,
              toolbar: {
                show: false,
              },
              background: "transparent",
            },
            grid: {
              show: false,
            },
            stroke: {
              curve: "smooth",
              width: 3,
            },
            yaxis: {
              show: false,
            },
            xaxis: {
              labels: {
                show: false,
              },
              axisTicks: {
                show: false,
              },
              axisBorder: {
                show: false,
              },
            },
          }}
        />
      )}
    </div>
  );
};

export default Chart;
