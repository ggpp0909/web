# NOOM

Zoom Clone using NodeJS, WebRTC and Websockets

### 초기세팅

- 터미널에 npm i nodemon -D

- babel.config.json, nodemon.json 생성

- src 폴더 생성후 그 안에 server.js 생성

- babel 설치 npm i @babel/core @babel/cli @babel/node -D

- .gitignore 생성, /node_modules 등록

- nodemon.json

  ```json
  {
      "exec": "babel-node src/server.js"
  }
  ```

- npm i @babel/preset-env -D

- bable.config.json

  ```json
  {
      "presets": ["@babel/preset-env"]
  }
  ```

- npm i express
- npm i pug

- server.js

  ```js
  import express from "express";
  
  const app = express();
  
  console.log("hello");
  app.listen(3000);
  ```

---

