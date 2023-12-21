<script setup>
import listCharacter from '../components/listCharacter.vue';
import changePage from '../components/changePage.vue';

</script>

<template>
  <main class="container">   
    
    <changePage/>

    <listCharacter/>
  
  </main>
</template>

<style scoped>

main{
  margin-top: 1rem;  
}

</style>