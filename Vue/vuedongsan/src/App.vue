<template>
  <div v-if="modalState" class="black-bg" @click="modalState = !modalState">
    <div class="white-bg">
      <h4>상세페이지임</h4>
      <p>상세페이지 내용임</p>
    </div>
  </div>

  <div class="menu">
    <a v-for="(item, idx) in menus" :key="idx">{{ item }}</a>
  </div>

  <div>
    <img src="./assets/room0.jpg" alt="" class="room-img" />
    <h4 class="red" :style="style" @click="modalState = !modalState">
      {{ products[0] }}
    </h4>
    <p>{{ price1 }} 만원</p>
    <button @click="increase(0)">허위매물신고</button>
    <span>신고수 : {{ reportNum[0] }}</span>
  </div>
  <div>
    <img src="./assets/room1.jpg" alt="" class="room-img" />
    <h4>{{ products[1] }}</h4>
    <p>{{ price2 }} 만원</p>
    <button @click="increase(1)">허위매물신고</button>
    <span>신고수 : {{ reportNum[1] }}</span>
  </div>
  <div>
    <img src="./assets/room2.jpg" alt="" class="room-img" />
    <h4>{{ products[2] }}</h4>
    <p>{{ price2 }} 만원</p>
    <button @click="increase(2)">허위매물신고</button>
    <span>신고수 : {{ reportNum[2] }}</span>
  </div>
</template>
<script>
export default {
  name: "App",
  // 자주 변할거 같은 데이터들은 밑의 데이터 통에다가 보관
  data() {
    return {
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
