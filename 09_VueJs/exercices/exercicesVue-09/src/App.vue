<script setup>
import AjouterTodo from './components/AjouterTodo.vue';
import ListeTodo from './components/ListeTodo.vue';

</script>

<template>  
  
    <header>
      <h1 class="text-center mb-2">Tâches à faire</h1>
  
      <AjouterTodo/>
      
    </header>
    <main>
  
      <ListeTodo/>
      
    </main>




</template>

<style scoped>

.container-fluid{
  height: 100 vh;
  width: 100 vw;  
}

header{
  background-color: rgb(231, 231, 231);
  height: 15vh;
  padding-top: 2rem;
}

main{
  background-color: rgb(242, 242, 242);
  height: 85vh;
}
</style>
