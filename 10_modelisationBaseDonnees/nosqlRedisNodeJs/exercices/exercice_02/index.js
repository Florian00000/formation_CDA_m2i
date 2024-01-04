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

//===================  classe  ===================

class Produit {
    id;
    nom;
    quantite;
    prix;

    constructor(id, nom, quantite, prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }
}

//===================  Démarre  ===================
verifIndex()

menu();

//===================  Fonctions  ===================

async function menu() {
    console.log("==== Gestion de tâches ====");
    let choix = "";
    do {
        console.log(
            "1 -- Ajouter un produit\n2 -- Mettre à jour un produit\n"
        );
        choix = await questionAsync("Votre choix : ");
        switch (choix) {
            case "1":
                await ajouterProduit();
                break;

        }
    } while (choix != "0");
}

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

    let index = await getProduitIndex();
    if (!index) {
        await setProduitIndex(0);
    }
}

//Récupérer index
async function getProduitIndex() {
    const count = await client.get("produitIndex");
    return parseInt(count);
}


//Modifier Index
async function setProduitIndex(index) {
    await client.set("produitIndex", `produit${index}`);
}

//ajouter produit
async function ajouterProduit() {
    const nom = await questionAsync("Merci d'inscrire le nom du produit: ");
    const quantite = await questionAsync("Merci d'inscrire le nombre de produit: ");
    const prix = await questionAsync("Merci d'inscrire le prix du produit: ");
    const index = await getProduitIndex();
    const obj = new Produit(index, nom, quantite, prix);

    await client.hSet(`produit${index}`, obj);
    console.log(`Le produit ${obj.nom} a été ajouté à la BDD`);

    //On récupère un objet
    const readObj = await client.hGetAll(`produit${index}`);
    console.log(readObj);

    await setProduitIndex(index + 1)
}

//récupérer un produit par id
async function getByIdProduit(id) {
    const result = await client.hGetAll(`produit${id}`);
    return result;
}

// récupérer la liste des produits
async function getAllProduits() {
    const index = await getProduitIndex();
    const listProduit = [];
    for (let i = 0; i < index; i++) {
    let result = await getByIdProduit(i)
    if (result) {
        listProduit.push(result);      
    }
  }
  return listTodo;
}

// async function getProduit() {
//     const nom = await questionAsync("Merci d'inscrire le nom du produit recherché: ");
//     const listProduit = await getAllProduits();

    
// }