//Démarrer un serveur web en nodejs
const http = require("http");

const config = {
  host: "127.0.0.1",
  port: 8080,
};

const server = http.createServer((req, res) => {
  console.log(req.method);
  const { headers } = req;
  console.log(headers);
  res.end("hello world!");
});

// Objet avec les méthodes pour l'intéraction avec une base de données redis
const redis = require("redis");
const host = "127.0.0.1";
const port = "6379";
const client = redis.createClient(port, host);

client
  .on("connect", () => {
    console.log("Connected to redis server");
  })
  .connect();

//demoRedis(client);
//demoObjectRedis();
demoListRedis("element 1");
demoListRedis("element 2");

server.listen(config, () => {
  console.log(`listening on: http://${config.host}:${config.port}`);
});

//Fonction pour ajouter dans redis
async function addToRedis(client, key, value) {
  try {
    await client.set(key, value);
  } catch (err) {
    console.error(err);
  }
}

//Fonction pour récupérer
async function getFromRedis(client, key) {
  try {
    const result = await client.get(key);
    return result;
  } catch (err) {
    console.error(err);
  }
}

//Fonction pour supprimer
async function deleteFromRedis(client, key) {
  try {
    await client.del(key);
  } catch (err) {
    console.error(err);
  }
}

async function demoRedis(client) {
  //Inserer des données dans redis string
  await client.set("key1", "value1");

  //Récupérer une valeur
  const valueKey1 = await client.get("key1");
  console.log(valueKey1);
}

//fonction demo objet
async function demoObjectRedis() {
  const obj = { name: "ihab", age: "36" };
  //On enregistre un objet
  await client.hSet("cle_object", obj);
  //On récupère un objet
  const readObj = await client.hGetAll("cle_object");
  console.log(readObj);
}

//Fonction demo list redis
async function demoListRedis(newElement) {
  await client.rPush("maListe", newElement);
  const liste = await client.lRange("maListe", 0, -1);
  console.log(liste);
}
