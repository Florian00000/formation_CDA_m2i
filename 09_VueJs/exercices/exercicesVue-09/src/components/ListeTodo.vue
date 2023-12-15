<script setup>
import { ref, computed } from 'vue';
import { useTodoStore } from '../stores/todo.js';

const todoStore = useTodoStore();

let afficherFav = ref(false);

function supprimerTodo(todo) {
    todoStore.removeTodo(todo)
}

function test() {
    console.log(todoStore.todos);
}    



</script>

<template>

    <div>
        <button v-on:click.prevent="afficherFav = false" class="btn btn-outline-primary">Toutes les tâches</button>
        <button v-on:click.prevent="afficherFav = true" class="btn btn-outline-primary">Tâches favorites</button>
        <button v-on:click.prevent="test" class="btn btn-outline-primary">test</button>
    </div>

 <!-- <template v-if="afficherFav === false"> -->
    
    <div v-for="todo in todoStore.todos">
        <template v-if="afficherFav === false">
            
            <span>{{ todo.nom }}</span>
            <button v-on:click.prevent="supprimerTodo(todo)" class="btn btn-danger">Supprimer</button>
            <input type="checkbox" v-model="todo.favori">
        </template>
        <template v-if="afficherFav === true && todo.favori === true">
            <span>{{ todo.nom }}</span>
            <button v-on:click.prevent="supprimerTodo(todo)" class="btn btn-danger">Supprimer</button>
            <input type="checkbox" v-model="todo.favori">
        </template>
    </div>
 <!-- </template> -->

 <!-- <template v-if="afficherFav === true">   
    
    <div v-for="todo in todosFav">
        <span>{{ todo.nom }}</span>
        <button v-on:click.prevent="supprimerTodo(todo)" class="btn btn-danger">Supprimer</button>
        <input type="checkbox" v-model="todo.favori">
    </div>
 </template> -->



</template>

<style scoped>

</style>