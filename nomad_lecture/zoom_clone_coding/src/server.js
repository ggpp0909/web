import express from "express";

const app = express();

app.set("view engine", "pug")

console.log("hello");
app.listen(3000);