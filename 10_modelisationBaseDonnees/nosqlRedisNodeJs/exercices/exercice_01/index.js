//Création d'un objet pour communiquer avec Redis
const redis = require("redis");
const host = "127.0.0.1";
const port = "6379";
const client = redis.createClient(port, host);
client.on("connect", () => { }).connect();

//Création d'un objet pour intéragir avec la console
const readline = require("readline");
const { stdin: input, stdout: output } = require("process");

const rl = readline.createInterface({ input, output });

verifIndex();


//Démarre
menu();

//Fonctions
//Question en async
function questionAsync(question) {
  return new Promise((resolve, reject) => {
    rl.question(question, (response) => {
      resolve(response);
    });
  });
}

//vérif index 
async function verifIndex() {

  let index = await getTaskIndex();
  if (!index) {
    //Mettre l'index à 0
    await setTaskIndex(0);
    // console.log('l index actuelle est ' + index);
  // } else {
  //   console.log('l index actuelle est ' + index);
  }
}

// Menu
async function menu() {
  console.log("==== Gestion de tâches ====");
  let choix = "";
  do {
    console.log(
      "1 -- Ajouter une tâche \n2 -- Afficher les tâches\n3 -- Supprimer une tâche\n"
    );
    choix = await questionAsync("Votre choix : ");
    switch (choix) {
      case "1":
        await addTask();
        break;
      case "2":
        await showTasks();
        break;
      case "3":
        await delTask();
        break;
    }
  } while (choix != "0");
}

//Récupérer index
async function getTaskIndex() {
  const count = await client.get("taskIndex");
  return parseInt(count);
}

//Set Index
async function setTaskIndex(index) {
  await client.set("taskIndex", index);
}

//Ajouter une tâche
async function addTask() {
  const task = await questionAsync("Merci de saisir la tâche : ");
  const index = await getTaskIndex();
  const result = await client.set(`${index }`, task);
  await setTaskIndex(index + 1);
  console.log("Task ajoutée " + result);
}

//Afficher une tâche
async function getTask(key) {
  const result = await client.get(key);
  return result;
}

//afficher les tâches
async function getAllTask() {
  const index = await getTaskIndex();
  const listTodo = [];
  for (let i = 0; i < index; i++) {
    let result = await getTask(`${i}`)
    if (result) {
      listTodo.push(result);      
    }
  }
  return listTodo;
}

async function showTasks() {
  const result = await getAllTask();
  console.log(result);
}

//supprimer une tache
async function delTask() {
  const index = await getTaskIndex(); 
  const taskToDel = await questionAsync("Merci de saisir la tâche à supprimmer : "); 
  for (let i = 0; i < index; i++) {
    let task = await getTask(`${i}`);
    if (taskToDel === task) {
      await client.del(`${i}`);    

      console.log("la tache a été supprimé");
    }
  }
}
