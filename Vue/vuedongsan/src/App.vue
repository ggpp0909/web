<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <!-- {{데이터바인딩}} 하는 이유
  1. HTML에 하드코딩 해놓으면 나중에 변경 어려움
  2. Vue의 실시간 자동 렌더링을 위해(중요)
   -->
  <!-- 속성도 데이터바인딩 가능
  :속성="데이터이름" -->
  <div>
    <h4 class="red" :style="style">{{ products[0] }}</h4>
    <p> {{ price1 }} 만원</p>
  </div>
  <div>
    <h4>{{ products[1] }}</h4>
    <p> {{ price2  }} 만원</p>
  </div>
  <div>
    <h4>{{ products[2] }}</h4>
    <p> {{ price2  }} 만원</p>
  </div>
  
</template>
<script>

export default {
  name: 'App',
  // 자주 변할거 같은 데이터들은 밑의 데이터 통에다가 보관
  data () {
    return {
      price1 : 60,
      price2 : 70,
      style: "color : blue",
      products : ["역삼동원룸", "천호동원룸", "마포구원룸"]
    }
  },
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
