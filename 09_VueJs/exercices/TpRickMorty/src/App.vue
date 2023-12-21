<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <h1>Rick et Morty</h1>
  </header>

  <RouterView />
</template>

<style scoped>

header{
  background-color: rgb(104, 170, 251);
  display: flex;
  justify-content: center;
  align-items: center;
  
  & h1{
    color: whitesmoke;
  }
}

</style>
