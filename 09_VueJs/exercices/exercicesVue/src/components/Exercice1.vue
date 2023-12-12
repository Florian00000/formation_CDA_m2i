<script setup>
import {ref, reactive, computed} from 'vue';

// exo1

let titre = ref("exo1"); 

const alertMessage = function () {
  alert("On peut le mettre dans prevent ;)")
}

const reverse = function () {
   titre.value = titre.value.split('').reverse().join('');
}

// exo2

let personne = reactive({
  prenom: "Georges",
  nom: "Abidbol",
  dateNaissance: new Date('1995-01-17')
})

let age = computed(()=> {
  const dateActuelle = new Date();
  let y = dateActuelle.getFullYear() - personne.dateNaissance.getFullYear();
  const m = dateActuelle.getMonth() - personne.dateNaissance.getMonth();    
    if (m < 0 || (m === 0 && dateActuelle.getDate() < personne.dateNaissance.getDate())) {
        y--;
    }
    return y 
})

function changerDate() {
  const anneRand =  Math.floor(Math.random() * (2023 - 1900)) + 1900
  personne.dateNaissance = new Date(`${anneRand}-01-17`)
  console.log(personne.dateNaissance);
}

</script>

<template>

  <h1>{{ titre }}</h1>

  <button v-on:click="reverse">bouton 1</button>
  <button v-on:click="titre += '!'">bouton 2</button>

  <a href="" v-on:click.prevent="alertMessage" >Un lien</a>

  <h1>exo 2</h1>

  <p> age : {{ age }} </p>

  <button v-on:click="changerDate">changer la date de naissance</button>
  
</template>

<style scoped>

</style>