<script setup>

import { inject, onMounted, ref } from 'vue';
import { useApiRickMorty } from '@/stores/apiRickMorty.js';

//Store Api Rick et Morty
const apiRickMorty = useApiRickMorty();


let voirDetails = inject('details').voirDetails;
// const afficherDetails = inject('details').afficherDetails; 





</script>

<template>
    <div class="modal-background" v-if="voirDetails">
      <div class="modal-box"> 
        <button class="close-button" @click="voirDetails = false">fermer</button>           
               
         
         <h3>{{ apiRickMorty.character.name }}</h3>
         <img :src="apiRickMorty.character.image" alt="">
         <p>Status: {{ apiRickMorty.character.status }}</p>
         <p>Species: {{ apiRickMorty.character.species }}</p>
         <p>Type: {{ apiRickMorty.character.type }}</p>
         <p>Gender: {{ apiRickMorty.character.gender }}</p>
         <p>Origin: {{ apiRickMorty.character.origin.name }}</p>
         <p>Location: {{ apiRickMorty.character.location.name }}</p>
         <p>Created: {{ apiRickMorty.character.created }}</p>
      </div>
    </div>
  </template>

<style scoped>
    /* Style de fond pour obscurcir l'arrière-plan */
.modal-background {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); 
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* Style de la boîte modale */
.modal-box {
  background-color: #fff;
  max-width: 80%;
  max-height: 80%;
  overflow: auto;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}


</style>
