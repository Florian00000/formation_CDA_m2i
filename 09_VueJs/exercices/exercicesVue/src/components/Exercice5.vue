<script setup>
import { ref, reactive } from 'vue';

let champSaisi = ref("");
let todoList = ref([]);
let todoListTrie = ref([]);
let todoListTrie2 = ref([]);
let tout = ref(false)

function ajouterTodo() {
  todoList.value.push(reactive({"nom": champSaisi, "fait": false}))
  champSaisi = ref("")
}

function tacheNonFaites() {
  todoListTrie.value = todoList.value.filter((objet)=> objet.fait === false)
}

function tacheTrie(option) {
  todoListTrie2.value = todoList.value.filter((objet)=> objet.fait === option)
  tout.value = false;
}

</script>

<template>

    <h1>exo 5</h1>

  <form v-on:submit.prevent="ajouterTodo">
    <input type="text" v-model="champSaisi">
        

    <div v-for="todo in todoList">
      <label for="">{{ todo.nom }}</label>
      <input type="checkbox" :name="todo.nom" :id="todo.nom" v-model="todo.fait">      
      <span v-if="todo.fait === false"> tâche à faire</span>
      <span v-else> tâche exécuté</span>
    </div>

    
  </form>

  <!-- 1e version du tri -->
  
  <button v-on:click="tacheNonFaites">Voir les taches restantes</button>
  <div v-for="todo2 in todoListTrie">
    <p>{{ todo2.nom }}</p>
  </div>

  <!-- version final du tri -->

  <div>
    <select >
      <option disabled value="">Sélectionner une option de tri</option>
        <option v-on:click="tout = true">Toutes les taches</option>
        <option v-on:click="tacheTrie(true)" >Tâches réalisés</option>
        <option v-on:click="tacheTrie(false)">Tâches à faire</option>
    </select>
  </div>

  <p>taches triés: </p>


  <div v-for="todo3 in todoListTrie2">
    <p>{{ todo3.nom }}</p>
  </div>

  <div v-if="tout === true">
    <div v-for="todo in todoList">
    <p>{{ todo.nom }}</p>
  </div>
  </div>

</template>

<style scoped>

</style>
