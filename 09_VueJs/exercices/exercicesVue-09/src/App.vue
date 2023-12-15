<script setup>
import AjouterTodo from './components/AjouterTodo.vue';
import ListeTodo from './components/ListeTodo.vue';

</script>

<template>

  <header>
    <h1>Tâches à faire</h1>

    <AjouterTodo/>
    
  </header>
  <main>

    <ListeTodo/>
    
  </main>

</template>

<style scoped>

</style>
