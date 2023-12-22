<script setup>
import listCharacter from '../components/listCharacter.vue';
import changePage from '../components/changePage.vue';

</script>

<template>
  <main class="container">
    
    <div class="boutonsPages">
      <changePage/>

    </div>
    

    <listCharacter/>

    <div class="boutonsPages">
      <changePage/>

    </div>
  
  </main>
</template>

<style scoped>

main{
  margin-top: 1rem;  
}

.boutonsPages{
  text-align: center;  
}

</style>