<template>
<!-- 반복문 v-for
v-for="작명 in 몇회" :kew="작명"
몇회 자리에는 데이터 집어넣기 가능-->
  <div class="menu">
    <a v-for="(item, idx) in menus" :key="idx">{{item}}</a>
  </div>
  <div v-for="(a, i) in 3" :key="i">
    <h4>{{ products[i] }}</h4>
    <p> {{ prices[i] }} 만원</p>
  </div>
  
  
</template>
<script>

export default {
  name: 'App',
  // 자주 변할거 같은 데이터들은 밑의 데이터 통에다가 보관
  data () {
    return {
      menus: ["Home", "Products", "About"],
      products : ["역삼동원룸", "천호동원룸", "마포구원룸"],
      prices: [50, 243, 12]
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
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
  text-decoration: none;
}
</style>
