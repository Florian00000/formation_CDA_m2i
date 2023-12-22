<script setup>
import { useApiRickMorty } from '@/stores/apiRickMorty.js'
import { ref, onBeforeUpdate } from 'vue';


//Store Api Rick et Morty
const apiRickMorty = useApiRickMorty();



let page = ref(1);
let pageMax = ref(42);

//Mise à jour dun nombre de page en fonction des infos du JSON/ On utilise onBeforeUpdate pour chercher l'information après avoir recu le Json
onBeforeUpdate( async() => {  
  pageMax.value = +apiRickMorty.listCharacters?.info?.pages;  
})

function pageDebut(){
  page.value = 1;
  apiRickMorty.fetchListCharacters(1);
}

function pageFin(){
  page.value = pageMax.value;
  apiRickMorty.fetchListCharacters(pageMax.value);
}

function pagePrecedente(){
    page.value--;
    apiRickMorty.fetchListCharacters(page.value)
}

function inputPage(){ 
    if (page.value > pageMax.value) {
        page.value = pageMax.value
    }      
    apiRickMorty.fetchListCharacters(page.value)    
}

function pageSuivante(){
    page.value++;
  apiRickMorty.fetchListCharacters(page.value)
}


</script>

<template>

  
    <button v-on:click.prevent="pageDebut" class="btn btn-outline-secondary boutonSuper" :disabled="page<=1">Début</button>
    <button v-on:click.prevent="pagePrecedente" class="btn btn-outline-secondary boutonChevron" :disabled="page<=1">{{ '<' }}</button>
    <input @keyup.enter="inputPage" v-model="page" type="number" class="btn btn-outline-secondary" min="1"
      :max="apiRickMorty.listCharacters?.info?.pages"
      required >
    <button v-on:click.prevent="pageSuivante" class="btn btn-outline-secondary boutonChevron" :disabled="page>= apiRickMorty.listCharacters?.info?.pages">></button>   
    <button v-on:click.prevent="pageFin" class="btn btn-outline-secondary boutonSuper" :disabled="page>= apiRickMorty.listCharacters?.info?.pages">Fin</button>
    
  
    
  
</template>

<style scoped>

input[type=number] {
    appearance: textfield;
    width: 5rem;
}

button{
  margin: 0.3rem;
}

.boutonSuper{
  width: 5rem;
  margin: 2rem;
}

.boutonChevron{
  width: 2.5rem;
}



</style>
