<script setup>
import { ref, computed } from 'vue';
import { useTodoStore } from '../stores/todo.js';

const todoStore = useTodoStore();

let afficherFav = ref(false);

function supprimerTodo(todo) {
    todoStore.removeTodo(todo)
}


</script>

<template>

    <div class="container w-25 pt-3">
        <div class=" text-end">
            <button v-on:click.prevent="afficherFav = false" class="btn btn-outline-dark mx-1">Toutes les tâches</button>
            <button v-on:click.prevent="afficherFav = true" class="btn btn-outline-dark mx-1">Tâches favorites</button>        
        </div>
    
    
        <!-- Affichage de toutes les tâches -->
        
        <template v-for="todo in todoStore.todos" >
            <template v-if="afficherFav === false">
                <div class="taches">
                    <span>{{ todo.nom }}</span>
                    <div>
                        
                        <button v-on:click.prevent="supprimerTodo(todo)" class="btn btn-danger">Supprimer</button>
                        <input type="checkbox" v-model="todo.favori">
                    </div>
                    
                </div>
                
            </template>
    
            <!-- Affichage des tâches favorites -->
            <template v-if="afficherFav === true && todo.favori === true">
                <div class="taches">
                    <span>{{ todo.nom }}</span>
                    <div>
                        <button v-on:click.prevent="supprimerTodo(todo)" class="btn btn-danger">Supprimer</button>
                        <input type="checkbox" v-model="todo.favori" >
    
                    </div>

                </div>
            </template>
        </template>

    </div>

 


</template>

<style scoped>

.taches{
    background-color: rgb(255, 255, 255);
    padding: 1rem;
    margin: 0.5rem;
    border-radius: 0.2rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: 10px 5px 5px  rgb(221, 219, 219);

    & button {
        margin-right: 1rem;
    }
}

</style>