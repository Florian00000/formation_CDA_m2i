<script setup>

import { computed, ref } from 'vue';

// exo3

let paraRouge = ref(false);
let para2 = ref("color: red")
let isRed = ref(false);

const para1 = computed(() => {
  return { "text-error":  paraRouge.value}
})

function changerPara2() {
  if (para2.value === "color: red") {
    para2.value = "color: blue"
  }else{
    para2.value = "color: red"
  }
}

// exo4

let entiers = ref([1, 5, 8, 10 ,25])

let toggleList = ref(true)

function ajouterEntier() {
  entiers.value.push(Math.floor(Math.random() * (100 - 1)) + 1)
}

function supprimerEntier() {
  entiers.value.pop()
}

</script>

<template>

  <h1>exo 3</h1>
  <p v-on:click="paraRouge = !paraRouge" :class="para1">paragraphe possiblement rouge</p> 
  <p :class="{red: isRed}" @click="isRed = !isRed">2e paragraphe possiblement rouge</p> 

  <p v-on:click="changerPara2" :style="para2">paragraphe 2</p>

  <!-- exo4 -->
  <h1>exo 4</h1>

  <button v-on:click="toggleList = !toggleList">Toggle liste</button>
  <button v-on:click="ajouterEntier">Ajouter élément</button>
  <button v-on:click="supprimerEntier">Supprimer élément</button>
  <button v-on:click="entiers.reverse">Inverser la liste</button>

  <div v-if="entiers.length && toggleList === true">
    <ul v-for="entier in entiers">
      <li>{{ entier }}</li>
    </ul>
  </div>
  <div v-else-if="entiers.length && toggleList === false">
    <p>La liste des entiers est caché</p>
  </div>
  <div v-else>
    <p>La liste est vide</p>
  </div>
  
</template>

<style scoped>
.text-error {
  color: red;
}

.red {
    color: red;
}


</style>
