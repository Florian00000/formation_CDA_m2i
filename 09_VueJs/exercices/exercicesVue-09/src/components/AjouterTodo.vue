<script setup>
import { ref } from 'vue';
import { useTodoStore } from '../stores/todo.js';
import { v4 as uuid} from "uuid";

const todoStore = useTodoStore();
let nomTodo = ref('');

function ajouterTodo() {
  todoStore.addTodo({
    id: uuid(), 
    nom: nomTodo.value,
    favori: false
  });
  nomTodo.value = '';
  console.log(todoStore.todos);
}



</script>

<template>

    
    <form v-on:submit.prevent="ajouterTodo" >
      <input type="text" placeholder="J'ai besoin de..." class="form-control" v-model="nomTodo">
      <button type="submit" class="btn btn-warning ms-1">Ajouter</button>
    </form>
  

</template>

<style scoped>

input{
  width: 20%;
  margin-left: auto;
}

button{
  margin-right: auto;
}

form{
  margin-top: 2rem;
  display: flex;
  justify-content: center;
}

</style>
