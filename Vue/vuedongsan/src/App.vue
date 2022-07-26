<template>
<!-- 반복문 v-for
v-for="작명 in 몇회" :kew="작명"
몇회 자리에는 데이터 집어넣기 가능-->
  <div class="menu">
    <a v-for="(item, idx) in menus" :key="idx">{{item}}</a>
  </div>
  <div>
    <h4 class="red" :style="style">{{ products[0] }}</h4>
    <p> {{ price1 }} 만원</p>
    <button @click="increase">허위매물신고</button> <span>신고수 : {{reportNum}}</span>
  </div>
  <div>
    <h4>{{ products[1] }}</h4>
    <p> {{ price2  }} 만원</p>
    <button></button>
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
      reportNum: 0,
      price1 : 60,
      price2 : 70,
      style: "color : blue",
      menus: ["Home", "Products", "About"],
      products : ["역삼동원룸", "천호동원룸", "마포구원룸"],
      prices: [50, 243, 12]
    }
  },
  methods: {
    increase() {
      this.reportNum += 1
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
