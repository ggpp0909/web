<template>
  <div v-if="modalState" class="black-bg" @click.self="onClickModal">
    <div class="white-bg">
      <h4>상세페이지임</h4>
      <p>상세페이지 내용임</p>
    </div>
  </div>

  <div class="menu">
    <a v-for="(item, idx) in menus" :key="idx">{{ item }}</a>
  </div>

  <div v-for="(item, idx) in onerooms" :key="idx">
    <img :src="onerooms[idx].image" alt="" class="room-img" />
    <h4>{{ onerooms[idx].title }}</h4>
    <p>{{ onerooms[idx].price }}원</p>
  </div>
</template>
<script>
import data from "./assets/oneroom";

export default {
  name: "App",
  // 자주 변할거 같은 데이터들은 밑의 데이터 통에다가 보관
  data() {
    return {
      onerooms: data,
      modalState: false,
      reportNum: [0, 0, 0],
      price1: 60,
      price2: 70,
      style: "color : blue",
      menus: ["Home", "Products", "About"],
      products: ["역삼동원룸", "천호동원룸", "마포구원룸"],
      prices: [50, 243, 12],
    };
  },
  methods: {
    increase(i) {
      this.reportNum[i] += 1;
    },
    onClickModal() {
      this.modalState = !this.modalState;
    },
  },
  components: {},
};
</script>

<style>
body {
  margin: 0;
}
div {
  box-sizing: border-box;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}
.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}
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

.room-img {
  width: 100%;
  margin-top: 40px;
}
</style>
